package com.lwhtarena.cg.listener;

import com.alibaba.fastjson.JSON;
import com.lwhtarena.cg.service.OrderService;
import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.amqp.core.Message;
import org.springframework.stereotype.Component;
import java.io.IOException;
import java.util.Map;

/**
 * @author liwh
 * @Title: OrderPayMessageListener
 * @Package com.lwhtarena.cg.listener
 * @Description: 在订单微服务于中创建OrderPayMessageListener，并在该类中consumeMessage方法，
 * 用于监听消息，并根据支付状态处理订单
 * @Version 1.0.0
 * @date 2020/8/2 19:47
 */
@Slf4j
@Component
@RabbitListener(queues = {"${mq.pay.queue.order}"})
public class OrderPayMessageListener {

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private OrderService orderService;

    /***
     * 接收消息
     * 监听订单支付回调中的消息然后修改订单状态
     */
    @RabbitHandler
    public void consumeMessage(String msg){
        //将数据转成Map
        Map<String,String> result = JSON.parseObject(msg,Map.class);

        //return_code=SUCCESS
        String return_code = result.get("return_code");
        //业务结果
        String result_code = result.get("result_code");

        //业务结果 result_code=SUCCESS/FAIL，修改订单状态
        if(return_code.equalsIgnoreCase("success") ){
            //获取订单号
            String outtradeno = result.get("out_trade_no");
            //业务结果
            if(result_code.equalsIgnoreCase("success")){
                if(outtradeno!=null){
                    //修改订单状态  out_trade_no
                    orderService.updateStatus(outtradeno,result.get("transaction_id"));
                }
            }else{
                //订单删除
                orderService.deleteOrder(outtradeno);
            }
        }
    }

    /**
     * 监听死信队列,定时关单
     *
     * 在现实场景中，可能会出现这么种情况，就是用户支付后，有可能畅购服务网络不通或者服务器挂了，此时会导
     * 致回调地址无法接收到用户支付状态，这时候我们需要取微信服务器查询。所以我们之前订单信息的ID存入到
     * 了Redis队列，主要用于解决这种网络不可达造成支付状态无法回调获取的问题。
     *实现思路如下：
     * 1.每次下单，都将订单存入到Reids List队列中
     * 2.定时每5秒检查一次Redis 队列中是否有数据，如果有，则再去查询微信服务器支付状态
     * 3.如果已支付，则修改订单状态
     * 4.如果没有支付，是等待支付，则再将订单存入到Redis队列中，等会再次检查
     * 5.如果是支付失败，直接删除订单信息并修改订单状态
     *
     */
    @RabbitListener(queues = {"ORDER-CLOSE-QUEUE"})
    public void closeOrder(String orderToken, Channel channel, Message message) {
        try {
            // 关单
            if (orderService.closeOrder(orderToken) == 1) {
                // 如果关单成功，发送消息给库存系统，释放库存
//				this.amqpTemplate.convertAndSend("gmall-cart-exchange", "cart.unlock", orderToken);
            }
            // 如果关单失败，说明订单可能已被关闭，直接确认消息
            // 手动ACK
            channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
        } catch (IOException e) {
            // 消费失败后重新入队
            try {
                channel.basicReject(message.getMessageProperties().getDeliveryTag(), true);
            } catch (IOException e1) {
                log.error("释放库存失败,orderToken=[{}]", orderToken);
            }
        }
    }
}
