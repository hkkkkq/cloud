//package com.lwhtarena.cg.goods.feign;
//
//import com.lwhtarena.cg.entity.Result;
//import com.lwhtarena.cg.goods.pojo.Spu;
//import org.springframework.cloud.openfeign.FeignClient;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//
///**
// * @author liwh
// * @Title: SpuFeign
// * @Package com.lwhtarena.cg.goods.feign
// * @Description:
// * @Version 1.0.0
// * @date 2020/7/15 20:31
// */
//@FeignClient(value="goods")
//@RequestMapping("/spu")
//public interface SpuFeign {
//
//    @GetMapping("/{id}")
//    public Result<Spu> findById(@PathVariable(name = "id") Long id);
//}
//
