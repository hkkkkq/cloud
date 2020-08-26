package com.lwhtarena.pay.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author liwh
 * @Title: RabbitMQConfig
 * @Package com.lwhtarena.pay.config
 * @Description:
 * @Version 1.0.0
 * @date 2020/8/2 11:57
 */
@Configuration
public class RabbitMQConfig {

    public static final String ORDER_PAY="order_pay";

    @Bean
    public Queue queue(){
        return  new Queue(ORDER_PAY);
    }
}
