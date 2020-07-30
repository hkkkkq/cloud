package com.lwhtarena.web.search.controller;

import com.lwhtarena.cg.vo.Page;
import com.lwhtarena.cg.search.feign.SkuFeign;
import com.lwhtarena.cg.search.pojo.SkuInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * @author liwh
 * @Title: SkuController
 * @Package com.lwhtarena.web.search.controller
 * @Description:
 * @Version 1.0.0
 * @date 2020/7/15 11:10
 */
@Controller
@RequestMapping("/search")
public class SkuController {

    @Autowired
    private SkuFeign skuFeign;


    @GetMapping("/list")
    public String search(@RequestParam(required = false) Map<String, String> searchMap, Model model) {
        //1.调用搜索微服务的 feign  根据搜索的条件参数 查询 数据
        Map resultmap = skuFeign.search(searchMap);
        //2.将数据设置到model中     (模板文件中 根据th:标签数据展示)
        //搜索的结果设置
        model.addAttribute("result", resultmap);

        //3.设置搜索的条件 回显
        model.addAttribute("searchMap",searchMap);

        //4.记住之前的URL
        //拼接url
        String url = url(searchMap);
        model.addAttribute("url",url);

        //创建一个分页的对象  可以获取当前页 和总个记录数和显示的页码(以当前页为中心的5个页码)
        Page<SkuInfo> infoPage = new Page<SkuInfo>(
                Long.valueOf(resultmap.get("total").toString()),
                Integer.valueOf(resultmap.get("pageNum").toString()),
                Integer.valueOf(resultmap.get("pageSize").toString())
        );

        model.addAttribute("page",infoPage);
        //3.返回
        return "search";
    }

    private String url(Map<String, String> searchMap) {
        /**初始化地址**/
        String url = "/search/list";
        if(searchMap!=null && searchMap.size()>0){
            url+="?";
            for (Map.Entry<String, String> stringStringEntry : searchMap.entrySet()) {
                /**keywords / brand  / category**/
                String key = stringStringEntry.getKey();
                /**华为  / 华为  / 笔记本**/
                String value = stringStringEntry.getValue();

                /**跳过分页参数**/
                if(key.equals("pageNum")){
                    continue;
                }
                /**排序参数，跳过**/
                if(key.equalsIgnoreCase("sortFiel")||key.equalsIgnoreCase("sortRule")){
                    continue;
                }
                url+=key+"="+value+"&";
            }

            //去掉多余的&
            if(url.lastIndexOf("&")!=-1){
                url =  url.substring(0,url.lastIndexOf("&"));
            }

        }
        return url;
    }
}
