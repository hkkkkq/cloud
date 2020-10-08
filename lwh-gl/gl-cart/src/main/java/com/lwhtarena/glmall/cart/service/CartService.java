package com.lwhtarena.glmall.cart.service;

import com.lwhtarena.glmall.cart.vo.CartItemVo;
import com.lwhtarena.glmall.cart.vo.CartVo;

import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * @author liwh
 * @Title: CartService
 * @Package com.lwhtarena.glmall.cart.service
 * @Description:
 * @Version 1.0.0
 * @date 2020/10/9 03:55
 */
public interface CartService {

    /**
     * 将商品添加至购物车
     * @param skuId
     * @param num
     * @return
     */
    CartItemVo addToCart(Long skuId, Integer num) throws ExecutionException, InterruptedException;

    /**
     * 获取购物车某个购物项
     * @param skuId
     * @return
     */
    CartItemVo getCartItem(Long skuId);

    /**
     * 获取购物车里面的信息
     * @return
     */
    CartVo getCart() throws ExecutionException, InterruptedException;

    /**
     * 清空购物车的数据
     * @param cartKey
     */
    public void clearCartInfo(String cartKey);

    /**
     * 勾选购物项
     * @param skuId
     * @param check
     */
    void checkItem(Long skuId, Integer check);

    /**
     * 改变商品数量
     * @param skuId
     * @param num
     */
    void changeItemCount(Long skuId, Integer num);


    /**
     * 删除购物项
     * @param skuId
     */
    void deleteIdCartInfo(Integer skuId);

    List<CartItemVo> getUserCartItems();

}
