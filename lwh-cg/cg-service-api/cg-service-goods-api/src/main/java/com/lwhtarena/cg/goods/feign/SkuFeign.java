package com.lwhtarena.cg.goods.feign;

import com.lwhtarena.cg.entity.Result;
import com.lwhtarena.cg.goods.pojo.Sku;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author liwh
 * @Title: SkuFeign
 * @Package com.lwhtarena.cg.goods.feign
 * @Description:
 * @Version 1.0.0
 * @date 2020/7/13 21:15
 */
@FeignClient(value="goods")
@RequestMapping("/sku")
public interface SkuFeign {
    /**
     * 查询符合条件的状态的SKU的列表
     * @param status
     * @return
     */
    @GetMapping("/status/{status}")
    public Result<List<Sku>> findByStatus(@PathVariable(name="status") String status);
}