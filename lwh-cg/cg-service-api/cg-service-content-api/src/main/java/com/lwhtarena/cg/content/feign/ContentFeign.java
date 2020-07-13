package com.lwhtarena.cg.content.feign;

import com.lwhtarena.cg.content.pojo.Content;
import com.lwhtarena.cg.entity.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author liwh
 * @Title: ContentFeign
 * @Package com.lwhtarena.cg.content.feign
 * @Description:
 * @Version 1.0.0
 * @date 2020/7/13 06:02
 */
@FeignClient(name="content")
@RequestMapping("/content")
public interface ContentFeign {

    /**
     * 根据分类的ID 获取到广告列表
     * @param id
     * @return
     */
    @GetMapping(value = "/list/category/{id}")
    Result<List<Content>> findByCategory(@PathVariable(name="id") Long id);
}