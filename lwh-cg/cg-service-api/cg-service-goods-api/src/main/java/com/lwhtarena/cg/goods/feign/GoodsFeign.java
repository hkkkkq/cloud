package com.lwhtarena.cg.goods.feign;

import com.lwhtarena.cg.entity.Result;
import com.lwhtarena.cg.goods.pojo.Category;
import com.lwhtarena.cg.goods.pojo.Sku;
import com.lwhtarena.cg.goods.pojo.Spu;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

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
public interface GoodsFeign {

    /**----====================== Sku ===========================----**/
    /**
     * 查询符合条件的状态的SKU的列表
     * @param status
     * @return
     */
    @GetMapping("/sku/status/{status}")
    public Result<List<Sku>> findByStatus(@PathVariable(name="status") String status);

    /**
     * 根据条件搜索的SKU的列表
     * @param sku
     * @return
     */
    @PostMapping(value = "/sku/search")
    public Result<List<Sku>> findSkuList(@RequestBody(required = false) Sku sku);

    @GetMapping("/sku/{id}")
    public Result<Sku> findById(@PathVariable(name="id") Long id);

//    @PostMapping(value = "/decr/count")
//    public Result decrCount(@RequestBody OrderItem orderItem);


    /**----====================== category ===========================----**/
    /**
     * 获取分类的对象信息
     * @param id
     * @return
     */
    @GetMapping("/category/{id}")
    public Result<Category> findCategoryById(@PathVariable(name = "id") Integer id);

    /**----====================== spu ===========================----**/
    @GetMapping("/spu/{id}")
    public Result<Spu> findSpuById(@PathVariable(name = "id") Long id);
}
