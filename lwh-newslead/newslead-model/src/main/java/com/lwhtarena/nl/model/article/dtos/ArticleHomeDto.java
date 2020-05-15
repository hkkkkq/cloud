package com.lwhtarena.nl.model.article.dtos;

import lombok.Data;

import java.util.Date;

/**
 * @author liwh
 * @Title: ArticleHomeDto
 * @Package com.lwhtarena.nl.model.article.dtos
 * @Description: 文章主页
 * @Version 1.0.0
 * @date 2020/5/15 19:44
 */
@Data
public class ArticleHomeDto {
    // 省市
    Integer provinceId;
    // 市区
    Integer cityId;
    // 区县
    Integer countyId;
    // 最大时间
    Date maxBehotTime;
    // 最小时间
    Date minBehotTime;
    // 分页size
    Integer size;
    // 数据范围，比如频道ID
    String tag;
}
