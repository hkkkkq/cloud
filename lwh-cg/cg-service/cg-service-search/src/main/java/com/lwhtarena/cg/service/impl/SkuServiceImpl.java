package com.lwhtarena.cg.service.impl;

import com.alibaba.fastjson.JSON;
import com.lwhtarena.cg.dao.SkuEsMapper;
import com.lwhtarena.cg.entity.Result;
import com.lwhtarena.cg.goods.feign.SkuFeign;
import com.lwhtarena.cg.goods.pojo.Sku;
import com.lwhtarena.cg.search.pojo.SkuInfo;
import com.lwhtarena.cg.service.SkuService;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.aggregations.bucket.terms.StringTerms;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.elasticsearch.search.sort.SortBuilders;
import org.elasticsearch.search.sort.SortOrder;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.aggregation.AggregatedPage;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import javax.annotation.Resource;
import java.util.*;

/**
 * @author liwh
 * @Title: SkuServiceImpl
 * @Package com.lwhtarena.cg.service.impl
 * @Description:
 * @Version 1.0.0
 * @date 2020/7/13 21:18
 */
@Service
public class SkuServiceImpl implements SkuService {


    @Resource
    private SkuFeign skuFeign;

    @Resource
    private SkuEsMapper skuEsMapper;

    @Resource
    private ElasticsearchTemplate elasticsearchTemplate;


    @Override
    public void importEs() {
        /**1.调用 goods微服务的fegin 查询 符合条件的sku的数据**/
        Result<List<Sku>> skuResult = skuFeign.findByStatus("1");
        /**sku的列表**/
        List<Sku> data = skuResult.getData();
        //将sku的列表 转换成es中的skuinfo的列表
        List<SkuInfo> skuInfos = JSON.parseArray(JSON.toJSONString(data), SkuInfo.class);
        for (SkuInfo skuInfo : skuInfos) {
            /**
             * 获取规格的数据
             * 获取sec -> Map(String) ->Map类型 {"电视音响效果":"立体声","电视屏幕尺寸":"20英寸","尺码":"165"}
             * 如果需要生成动态的域，只需要将该域存入到一个Map<String,Object>对象中即可，该Map<String,Object>的key会生成一个域，域的名字为该Map的key
             * 当前Map<String,Object>后面的Object的值会作为当前Sku对象该域（key）对应的值
             *
             * 转成map  key: 规格的名称  value:规格的选项的值
             */
            Map<String, Object> map = JSON.parseObject(skuInfo.getSpec(), Map.class);
            skuInfo.setSpecMap(map);
        }


        /**2.调用spring data elasticsearch的API 导入到ES中**/
        skuEsMapper.saveAll(skuInfos);
    }


    /**
     * 多条件查询
     * key:
     *      category     商品分类的过滤查询
     *
     *      brand        商品品牌的过滤查询   TCL
     *
     *      spec_规格的名称   value  规格的值      规格相关
     *
     *      price           value 价格区间的字符串 0-500   3000-*
     *
     *
     *      pageNum   当前的页码
     *      pageSize  不用传递   (写死)
     *
     *
     *      sortField  要排序的字段  price
     *      sortRule   要排序的规则 (ASC DESC)
     *
     * @param searchMap
     * @return
     */
    @Override
    public Map search(Map<String, String> searchMap) {
        /**1.获取到关键字**/
        String keywords = searchMap.get("keywords");

        /**2.判断是否为空 如果 为空 给一个默认 值:华为**/
        if (StringUtils.isEmpty(keywords)) {
            keywords = "华为";
        }

        /**
         * 3.创建 查询构建对象
         * NativeSearchQueryBuilder:搜索条件构造对象，用于封装各种搜索条件
         */
        NativeSearchQueryBuilder nativeSearchQueryBuilder = new NativeSearchQueryBuilder();

        /**
         * 4.1 商品分类的列表展示: 按照商品分类的名称来分组
         * terms  指定分组的一个别名
         * field 指定要分组的字段名
         * size 指定查询结果的数量 默认是10个
         **/
        nativeSearchQueryBuilder.addAggregation(AggregationBuilders.terms("skuCategorygroup").field("categoryName").size(50));
        /**4.2 商品的品牌的列表展示  按照商品品牌来进行分组**/
        nativeSearchQueryBuilder.addAggregation(AggregationBuilders.terms("skuBrandgroup").field("brandName").size(100));

        /**
         * 4.3 商品的规格的列表展示   按照商品的规格的字段spec 进行分组
         * 规则 要求 字段 是一个keyword类型的  spec.keyword
         ***/
        nativeSearchQueryBuilder.addAggregation(AggregationBuilders.terms("skuSpecgroup").field("spec.keyword").size(500));

        /**
         * 4.4 设置高亮的字段 设置前缀 和 后缀
         * 设置高亮的字段 针对 商品的名称进行高亮
         * 设置前缀 和 后缀
         * **/
        nativeSearchQueryBuilder.withHighlightFields(new HighlightBuilder.Field("name"));
        nativeSearchQueryBuilder.withHighlightBuilder(new HighlightBuilder().preTags("<em style=\"color:red\">").postTags("</em>"));

        /**
         * 匹配查询  先分词 再查询  主条件查询
         * 参数1 指定要搜索的字段
         * 参数2 要搜索的值(先分词 再搜索)
         * nativeSearchQueryBuilder.withQuery(QueryBuilders.matchQuery("name", keywords));
         *
         * 从多个字段中搜索数据
         **/
        nativeSearchQueryBuilder.withQuery(QueryBuilders.multiMatchQuery(keywords,"name","category","brandName"));

        /**========================过滤查询 开始=====================================**/
        BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();

        /**4.5 过滤查询的条件设置   商品分类的条件**/
        String category = searchMap.get("category");
        if(!StringUtils.isEmpty(category)) {
            boolQueryBuilder.filter(QueryBuilders.termQuery("categoryName", category));
        }

        /**4.6 过滤查询的条件设置   商品品牌的条件**/
        String brand = searchMap.get("brand");
        if(!StringUtils.isEmpty(brand)) {
            boolQueryBuilder.filter(QueryBuilders.termQuery("brandName", brand));
        }

        /**4.7 过滤查询的条件设置   规格条件**/
        if(searchMap!=null){
            /**{ brand:"",category:"",spec_网络:"电信4G"}**/
            for (String key : searchMap.keySet()) {
                if(key.startsWith("spec_"))  {
                    //截取规格的名称
                    boolQueryBuilder.filter(QueryBuilders.termQuery("specMap."+key.substring(5)+".keyword", searchMap.get(key)));
                }
            }
        }

        /**4.8 过滤查询的条件设置   价格区间的过滤查询**/
        String price = searchMap.get("price");
        if(!StringUtils.isEmpty(price)){
            /**获取值 按照- 切割**/
            String[] split = price.split("-");
            /**过滤范围查询,0<=price<=500**/
            if(!split[1].equals("*")) {
                boolQueryBuilder.filter(QueryBuilders.rangeQuery("price").from(split[0], true).to(split[1], true));
            }else{
                boolQueryBuilder.filter(QueryBuilders.rangeQuery("price").gte(split[0]));
            }

        }

        /**过滤查询**/
        nativeSearchQueryBuilder.withFilter(boolQueryBuilder);
        //========================过滤查询 结束=====================================

        /**=========== 分页查询 =========**/
        /**
         * 第一个参数:指定当前的页码  注意: 如果是第一页 数值为0
         * 第二个参数:指定当前的页的显示的行
         *
         * 分页，用户如果不传分页参数，则默认第1页
         */
        Integer pageNum =coverterPage(searchMap);
        Integer pageSize=30;
        nativeSearchQueryBuilder.withPageable(PageRequest.of(pageNum-1,pageSize));

        /**
         * 排序操作
         * 获取排序的字段 和要排序的规则
         */
        /**price**/
        String sortField = searchMap.get("sortField");
        /**DESC ASC**/
        String sortRule = searchMap.get("sortRule");
        if(!StringUtils.isEmpty(sortField) && !StringUtils.isEmpty(sortRule)) {
            //执行排序
            nativeSearchQueryBuilder
                    .withSort(SortBuilders.fieldSort(sortField)
                    .order(sortRule.equalsIgnoreCase("ASC")? SortOrder.ASC:SortOrder.DESC));
            //nativeSearchQueryBuilder.withSort(SortBuilders.fieldSort(sortField).order(SortOrder.valueOf(sortRule)));
        }

        /**5.构建查询对象(封装了查询的语法)**/
        NativeSearchQuery nativeSearchQuery = nativeSearchQueryBuilder.build();
        /**
         * 6.执行查询
         * 1) 搜索条件封装对象
         * 2）搜索的结果集（集合数据）需要转换的类型
         * 3）AggregatedPage<SkuInfo>：搜索结果集的封装
         */
        AggregatedPage<SkuInfo> skuInfos = elasticsearchTemplate.queryForPage(nativeSearchQuery, SkuInfo.class,new SearchResultMapperImpl());

        /**
         * 6.2 获取聚合分组结果  获取商品分类的列表数据
         */
        StringTerms stringTermsCategory = (StringTerms) skuInfos.getAggregation("skuCategorygroup");
        List<String> categoryList = getStringsCategoryList(stringTermsCategory);

        /**
         * 品牌分组查询
         * 6.3 获取 品牌分组结果 列表数据
         */
        StringTerms stringTermsBrand = (StringTerms) skuInfos.getAggregation("skuBrandgroup");
        List<String> brandList = getStringsBrandList(stringTermsBrand);

        /**6.4 获取 规格的分组结果 列表数据map**/
        StringTerms stringTermsSpec = (StringTerms) skuInfos.getAggregation("skuSpecgroup");
        Map<String, Set<String>> specMap = getStringSetMap(stringTermsSpec);


        /**
         * 7.获取结果  返回map
         * 当前的页的集合
         */
        List<SkuInfo> content = skuInfos.getContent();
        /**总页数**/
        int totalPages = skuInfos.getTotalPages();
        /**总记录数**/
        long totalElements = skuInfos.getTotalElements();

        Map<String,Object> resultMap =new HashMap<>();
        /**商品分类的列表数据**/
        resultMap.put("categoryList",categoryList);
        /**品牌分组查询**/
        resultMap.put("brandList",brandList);
        /**商品规格的列表数据展示**/
        resultMap.put("specMap", specMap);
        resultMap.put("rows",content);
        resultMap.put("total",totalElements);
        resultMap.put("totalPages",totalPages);
        resultMap.put("pageNum",pageNum);
        resultMap.put("pageSize",pageSize);

        return resultMap;
    }

    /**
     *        //4.设置 查询的条件
     *
     *         // 4.1 商品分类的列表展示: 按照商品分类的名称来分组
     *         //terms  指定分组的一个别名
     *         //field 指定要分组的字段名
     *         // size 指定查询结果的数量 默认是10个
     * @param stringTerms
     * @return
     */
    private List<String> getStringsCategoryList(StringTerms stringTerms) {
        List<String> categoryList = new ArrayList<>();
        if (stringTerms != null) {
            for (StringTerms.Bucket bucket : stringTerms.getBuckets()) {
                String keyAsString = bucket.getKeyAsString();
                /**就是商品分类的数据**/
                System.out.println(keyAsString);
                categoryList.add(keyAsString);
            }
        }
        return categoryList;
    }

    /**
     * 品牌分组查询
     * @param stringTerms
     * @return
     */
    public List<String> getStringsBrandList(StringTerms stringTerms){
        List<String> brandList =new ArrayList<>();
        for(StringTerms.Bucket bucket : stringTerms.getBuckets()){
            String brandName =bucket.getKeyAsString();
            brandList.add(brandName);
        }
        return brandList;
    }


    private Map<String, Set<String>> getStringSetMap(StringTerms stringTermsSpec) {
        /**
         * key :规格的名称
         * value :规格名称对应的选项的多个值集合set
         */
        Map<String, Set<String>> specMap = new HashMap<String, Set<String>>();
        Set<String> specValues = new HashSet<String>();
        if (stringTermsSpec != null) {
            //1. 获取分组的结果集
            for (StringTerms.Bucket bucket : stringTermsSpec.getBuckets()) {
                /**2.去除结果集的每一行数据()
                 * {"手机屏幕尺寸":"5.5寸","网络":"电信4G","颜色":"白","测试":"s11","机身内存":"128G","存储":"16G","像素":"300万像素"}
                 **/
                String keyAsString = bucket.getKeyAsString();

                /**
                 * 3.转成JSON 对象  map  key :规格的名称  value:规格名对应的选项的单个值
                 */
                Map<String, String> map = JSON.parseObject(keyAsString, Map.class);
                for (Map.Entry<String, String> stringStringEntry : map.entrySet()) {
                    /**规格名称   手机屏幕尺寸**/
                    String key = stringStringEntry.getKey();
                    /**规格的名称对应的单个选项值 5.5寸**/
                    String value = stringStringEntry.getValue();

                    /**先从原来的specMap中 获取 某一个规格名称 对应的规格的选项值集合**/
                    specValues = specMap.get(key);
                    if (specValues == null) {
                        specValues = new HashSet<>();
                    }
                    specValues.add(value);
                    /**4.提取map中的值放入到返回的map中**/
                    specMap.put(key, specValues);
                }
            }
        }
        return specMap;
    }

    /**
     * 接收前端传入的分页参数
     * @param searchMap
     * @return
     */
    private Integer coverterPage(Map<String, String> searchMap) {
        if(searchMap!=null){
            String pageNum =searchMap.get("pageNum");
            try {
                if(StringUtils.isEmpty(pageNum) || pageNum.equals("null")){
                    return 1;
                }
                return Integer.parseInt(pageNum);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return 1;
    }
}
