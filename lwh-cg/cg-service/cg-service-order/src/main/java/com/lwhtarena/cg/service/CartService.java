package com.lwhtarena.cg.service;


import com.lwhtarena.cg.order.pojo.OrderItem;

import java.util.List;
import java.util.Map;

/**
 * 描述
 *
 * @author www.itheima.com
 * @version 1.0
 * @package com.changgou.order.service *
 * @since 1.0
 */
public interface CartService {
    /**
     * 添加购物车
     * @param id  sku的ID
     * @param num 购买的数量
     * @param username  购买的商品的用户名
     */
    void add(Long id, Integer num, String username);

    /**
     * 查询购物车数据
     * 从redis中获取当前的用户的购物车的列表数据
     * @param username
     * @return
     */
    Map list(String username);
}
