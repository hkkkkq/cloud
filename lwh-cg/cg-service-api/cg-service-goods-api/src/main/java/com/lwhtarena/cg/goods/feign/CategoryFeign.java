//package com.lwhtarena.cg.goods.feign;
//
//import com.lwhtarena.cg.entity.Result;
//import com.lwhtarena.cg.goods.pojo.Category;
//import org.springframework.cloud.openfeign.FeignClient;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//
///**
// * @author liwh
// * @Title: CategoryFeign
// * @Package com.lwhtarena.cg.goods.feign
// * @Description:
// * @Version 1.0.0
// * @date 2020/7/15 20:28
// */
//@FeignClient(value="goods")
//@RequestMapping("/category")
//public interface CategoryFeign {
//
//    /**
//     * 获取分类的对象信息
//     * @param id
//     * @return
//     */
//    @GetMapping("/{id}")
//    public Result<Category> findById(@PathVariable(name = "id") Integer id);
//}
