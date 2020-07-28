package com.lwhtarena.glmall.order.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lwhtarena.common.utils.PageUtils;
import com.lwhtarena.glmall.order.entity.OrderEntity;

import java.util.Map;

/**
 * 订单
 *
 * @author liwh
 * @email lwhtarena@gmail.com
 * @date 2020-07-25 13:57:03
 */
public interface OrderService extends IService<OrderEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

