package com.lwhtarena.cg.constants;

/**
 * @author jiangli
 * @since 2020/2/20 10:15
 */
public interface MQConstants {
	//订单相关的消息路由器
	String ORDER_EXCHANGE = "ORDER-EXCHANGE";

	//支付成功消息的routingKey
	String PAY_SUCCESS_ROUTING_KEY = "pay.success";

	//秒杀订单支付成功消息的routingKey
	String SECKILL_PAY_SUCCESS_ROUTING_KEY = "seckillpay.success";

}
