package com.lwhtarena.glmall.order.service.impl;

import com.lwhtarena.glmall.order.entity.OrderReturnReasonEntity;
import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lwhtarena.common.utils.PageUtils;
import com.lwhtarena.common.utils.Query;

import com.lwhtarena.glmall.order.dao.OrderItemDao;
import com.lwhtarena.glmall.order.entity.OrderItemEntity;
import com.lwhtarena.glmall.order.service.OrderItemService;


@Service("orderItemService")
public class OrderItemServiceImpl extends ServiceImpl<OrderItemDao, OrderItemEntity> implements OrderItemService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<OrderItemEntity> page = this.page(
                new Query<OrderItemEntity>().getPage(params),
                new QueryWrapper<OrderItemEntity>()
        );

        return new PageUtils(page);
    }


    /**
     * queues：声明需要监听的队列
     * channel：当前传输数据的通道
     *
     *    org.springframework.amqp.core.Message
     *
     * 参数参考一下类型：
     *  1、Message message：原生消息详细，头+体；
     *  2、T<发送的消息的类型> OrderReturnReasonEntity content；
     *  3、Channel channel：当前传输数据的通道
     *
     *  Queue：可以很多人都来监听，只要收到消息，队列删除消息，而且只能有一个收到此消息
     *  场景：
     *     1）订单服务启动多个，同一个消息，只能有一个客户端收到；
     *     2）只有一个消息完全处理完，方法运行结束，我们就可以接收到下一个消息
     */
    @RabbitListener(queues = {"hello-java-queue"})
    public void revieveMessage(Message message,
                               OrderReturnReasonEntity content, Channel channel) {
        //拿到主体内容
        byte[] body = message.getBody();
        //拿到的消息头属性信息
        MessageProperties messageProperties = message.getMessageProperties();
        System.out.println("接受到的消息...内容" + message + "===内容：" + content);

        /**channel内容顺序自增的**/
        long tag = message.getMessageProperties().getDeliveryTag();
        System.out.println("deliveryTag ===> "+tag);
        /**签收货物,非批量**/
        try {
            if (tag%2 == 0){
                channel.basicAck(tag,false);
                System.out.println("签收了货物..."+ tag);
            }else {
                /**退货 requeue=false 丢弃，requeue=true 发回服务器，服务器重新入队 **/
                channel.basicNack(tag,false,true);
//                channel.basicReject();
                System.out.println("没有签收了货物..."+tag);
            }
        } catch (IOException e) {
            /**网络中断**/
            e.printStackTrace();
        }


    }

}