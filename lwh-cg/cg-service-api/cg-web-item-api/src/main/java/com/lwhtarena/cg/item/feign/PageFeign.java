package com.lwhtarena.cg.item.feign;

import com.lwhtarena.cg.entity.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author liwh
 * @Title: PageFeign
 * @Package com.lwhtarena.cg.item.feign
 * @Description:
 * @Version 1.0.0
 * @date 2020/7/16 10:25
 */
@FeignClient(name = "item")
@RequestMapping("/page")
public interface PageFeign {

    /**
     * 根据spuId生成静态页
     * @param id
     * @return
     */
    @RequestMapping("/createHtml/{id}")
    Result createHtml(@PathVariable(name = "id") Long id);
}
