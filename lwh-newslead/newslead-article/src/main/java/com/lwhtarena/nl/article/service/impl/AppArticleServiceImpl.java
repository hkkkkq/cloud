package com.lwhtarena.nl.article.service.impl;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.lwhtarena.nl.article.service.AppArticleService;
import com.lwhtarena.nl.common.article.constans.ArticleConstans;
import com.lwhtarena.nl.model.article.dtos.ArticleHomeDto;
import com.lwhtarena.nl.model.article.pojos.ApArticle;
import com.lwhtarena.nl.model.article.pojos.ApHotArticles;
import com.lwhtarena.nl.model.behavior.pojos.ApBehaviorEntry;
import com.lwhtarena.nl.model.common.dtos.ResponseResult;
import com.lwhtarena.nl.model.mappers.app.ApArticleMapper;
import com.lwhtarena.nl.model.mappers.app.ApBehaviorEntryMapper;
import com.lwhtarena.nl.model.mappers.app.ApHotArticlesMapper;
import com.lwhtarena.nl.model.mappers.app.ApUserArticleListMapper;
import com.lwhtarena.nl.model.mess.app.ArticleVisitStreamDto;
import com.lwhtarena.nl.model.user.pojos.ApUser;
import com.lwhtarena.nl.model.user.pojos.ApUserArticleList;
import com.lwhtarena.nl.utils.threadlocal.AppThreadLocalUtils;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author liwh
 * @Title: AppArticleServiceImpl
 * @Package com.lwhtarena.nl.article.service.impl
 * @Description:
 * @Version 1.0.0
 * @date 2020/5/15 20:12
 */

@Log4j2
@Service
public class AppArticleServiceImpl implements AppArticleService {
    private static final short MAX_PAGE_SIZE = 50;

    @Autowired
    private ApHotArticlesMapper apHotArticlesMapper;
    @Autowired
    private ApArticleMapper apArticleMapper;
    @Autowired
    private ApUserArticleListMapper apUserArticleListMapper;

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Override
    public ResponseResult load(ArticleHomeDto dto, Short type) {
        //参数校验
        if(dto ==null ){
            dto = new ArticleHomeDto();
        }
        //时间校验
        if(dto.getMaxBehotTime()==null){
            dto.setMaxBehotTime(new Date());
        }

        if(dto.getMinBehotTime()==null){
            dto.setMinBehotTime(new Date());
        }

        //分页参数的校验
        Integer size = dto.getSize();
        if(size==null || size <= 0){
            size = 20;
        }
        size = Math.min(size,MAX_PAGE_SIZE);
        dto.setSize(size);

        //文章频道参数校验
        if(StringUtils.isEmpty(dto.getTag())){
            dto.setTag(ArticleConstans.DEFAULT_TAG);
        }

        //类型参数校验
        if(!type.equals(ArticleConstans.LOADTYPE_LOAD_MORE)&&!type.equals(ArticleConstans.LOADTYPE_LOAD_NEW)){
            type = ArticleConstans.LOADTYPE_LOAD_MORE;
        }

        //获取用户的信息
        ApUser user = AppThreadLocalUtils.getUser();

        //判断用户是否存在
        if(user != null){
            //存在 已登录 加载推荐的文章
            List<ApArticle> apArticleList = getUserArticle(user,dto,type);
            return ResponseResult.okResult(apArticleList);
        }else{
            //不存在 未登录，加载默认的文章
            List<ApArticle> apArticles = getDefaultArticle(dto,type);
            return ResponseResult.okResult(apArticles);
        }

    }

    @Override
    public ResponseResult updateArticleView(ArticleVisitStreamDto dto) {
        int rows = apArticleMapper.updateArticleView(dto.getArticleId(),dto.getView(),dto.getCollect(),dto.getCommont(),dto.getLike());
        return ResponseResult.okResult(rows);
    }

    /**
     * 加载默认的文章信息
     * @param dto
     * @param type
     * @return
     */
    private List<ApArticle> getDefaultArticle(ArticleHomeDto dto, Short type) {
        return apArticleMapper.loadArticleListByLocation(dto,type);
    }

    /**
     * 先从用户的推荐表中查找文章信息，如果没有再从默认文章信息获取数据
     * @param user
     * @param dto
     * @param type
     * @return
     */
    private List<ApArticle> getUserArticle(ApUser user, ArticleHomeDto dto, Short type) {
        List<ApUserArticleList> list = apUserArticleListMapper.loadArticleIdListByUser(user,dto,type);
        if(!list.isEmpty()){
            return apArticleMapper.loadArticleListByIdList(list);
        }else{
            return getDefaultArticle(dto,type);
        }
    }

    @Override
    public ResponseResult loadV2(Short type, ArticleHomeDto dto, boolean firstPage) {
        //参数校验
        if(dto ==null ){
            dto = new ArticleHomeDto();
        }
        //时间校验
        if(dto.getMaxBehotTime()==null){
            dto.setMaxBehotTime(new Date());
        }

        if(dto.getMinBehotTime()==null){
            dto.setMinBehotTime(new Date());
        }

        //分页参数的校验
        Integer size = dto.getSize();
        if(size==null || size <= 0){
            size = 20;
        }
        size = Math.min(size,MAX_PAGE_SIZE);
        dto.setSize(size);

        //文章频道参数校验
        if(StringUtils.isEmpty(dto.getTag())){
            dto.setTag(ArticleConstans.DEFAULT_TAG);
        }

        //类型参数校验
        if(!type.equals(ArticleConstans.LOADTYPE_LOAD_MORE)&&!type.equals(ArticleConstans.LOADTYPE_LOAD_NEW)){
            type = ArticleConstans.LOADTYPE_LOAD_MORE;
        }

        //获取用户的信息
        ApUser user = AppThreadLocalUtils.getUser();

        //是否是首页  是首页，从缓存中获取数据  不是首页 从数据库中获取数据
        if(firstPage){
            List<ApArticle> cacheList = getCacheArticleV2(dto);
            if(cacheList.size()>0){
                log.info("使用缓存加载数据#tag:{}",dto.getTag());
                return ResponseResult.okResult(cacheList);
            }
        }
        //用户是否为空 为空加载默认的  不为空，先去找推荐的热文章，找不到推荐的，再去查找默认推荐的热文章
        if(user!=null){
            List<ApArticle> userArticleList = getUserArticleV2(user,dto,type);
            return ResponseResult.okResult(userArticleList);
        }else{
            List<ApArticle> defualtArticleList = getDefaultArticleV2(dto,type);
            return ResponseResult.okResult(defualtArticleList);
        }
    }

    @Autowired
    private ApBehaviorEntryMapper apBehaviorEntryMapper;

    /**
     * 先从用户推荐的表中查找热文章，如果没有再从大文章列表查询数据
     * @param user
     * @param dto
     * @param type
     * @return
     */
    private List<ApArticle> getUserArticleV2(ApUser user, ArticleHomeDto dto, Short type) {
        // 用户和设备不能同时为空
        if(user == null){
            return Lists.newArrayList();
        }
        Long userId = user.getId();
        ApBehaviorEntry apBehaviorEntry = apBehaviorEntryMapper.selectByUserIdOrEquipemntId(userId, null);
        // 行为实体找以及注册了，逻辑上这里是必定有值得，除非参数错误
        if(apBehaviorEntry==null){
            return Lists.newArrayList();
        }
        Integer entryId =  apBehaviorEntry.getId();
        //如果没查到 查询全局热文章
        if(entryId==null){
            entryId = 0;
        }
        List<ApHotArticles> list = apHotArticlesMapper.loadArticleIdListByEntryId(entryId, dto, type);
        //默认从热文章里查找
        if(!list.isEmpty()){
            List<Integer> articleIdList = list.stream().map(p->
                    p.getArticleId()).collect(Collectors.toList());
            List<ApArticle> apArticles = apArticleMapper.loadArticleListByIdListV2(articleIdList);
            return apArticles;
        }else{
            return getDefaultArticleV2(dto,type);
        }
    }

    /**
     * 加载默认的热文章数据
     * @param dto
     * @param type
     * @return
     */
    private List<ApArticle> getDefaultArticleV2(ArticleHomeDto dto, Short type) {
        List<ApHotArticles> hotList = apHotArticlesMapper.loadHotListByLocation(dto, type);
        List<ApArticle> articleList = Lists.newArrayList();
        if(null != hotList && !hotList.isEmpty()){
            for (ApHotArticles hotArticles : hotList) {
                ApArticle apArticle = apArticleMapper.selectById(Long.valueOf(hotArticles.getArticleId()));
                articleList.add(apArticle);
            }
        }
        return articleList;
    }

    /**
     * 查询缓存首页文章数据
     * @param dto
     * @return
     */
    private List<ApArticle> getCacheArticleV2(ArticleHomeDto dto) {
        log.info("查询缓存热文章数据#tag:{}",dto.getTag());
        String ret = redisTemplate.opsForValue().get(ArticleConstans.HOT_ARTICLE_FIRST_PAGE + dto.getTag());
        if(StringUtils.isEmpty(ret)){
            return Lists.newArrayList();
        }
        List<ApArticle> list = JSON.parseArray(ret, ApArticle.class);
        log.info("查询缓存文章热数据#tag:{},size:{}",dto.getTag(),list.size());
        return list;
    }
}
