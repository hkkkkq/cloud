package com.lwhtarena.cg.search.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * @author liwh
 * @Title: SkuFeign
 * @Package com.lwhtarena.cg.search.feign
 * @Description:
 * @Version 1.0.0
 * @date 2020/7/15 10:54
 */
@FeignClient(name="search")
@RequestMapping("/search")
public interface SkuFeign {

    @GetMapping
    public Map search(@RequestParam(required = false) Map searchMap);

//    /**
//     * 查询符合条件的状态的SKU的列表
//     * @param status
//     * @return
//     */
//    @GetMapping("/status/{status}")
//    public Result<List<Sku>> findByStatus(@PathVariable(name="status") String status);

}
