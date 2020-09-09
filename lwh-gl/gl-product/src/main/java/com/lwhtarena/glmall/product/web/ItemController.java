package com.lwhtarena.glmall.product.web;

import com.lwhtarena.glmall.product.service.SkuInfoService;
import com.lwhtarena.glmall.product.vo.SkuItemVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.concurrent.ExecutionException;

/**
 * @author liwh
 * @Title: ItemController
 * @Package com.lwhtarena.glmall.product
 * @Description:
 * @Version 1.0.0
 * @date 2020/9/4 19:07
 */
public class ItemController {

    @Autowired
    private SkuInfoService skuInfoService;

    /**
     * 展示当前sku的详情
     * @param skuId
     * @return
     */
    @GetMapping("/{skuId}.html")
    public String skuItem(@PathVariable("skuId") Long skuId, Model model) throws ExecutionException, InterruptedException {

        System.out.println("准备查询" + skuId + "详情");
        SkuItemVo vos = skuInfoService.item(skuId);
        model.addAttribute("item",vos);

        return "item";
    }
}
