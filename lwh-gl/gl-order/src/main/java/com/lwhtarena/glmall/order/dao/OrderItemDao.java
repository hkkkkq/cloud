package com.lwhtarena.glmall.order.dao;

import com.lwhtarena.glmall.order.entity.OrderItemEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 订单项信息
 * 
 * @author liwh
 * @email lwhtarena@gmail.com
 * @date 2020-07-25 13:57:03
 */
@Mapper
public interface OrderItemDao extends BaseMapper<OrderItemEntity> {
	
}
