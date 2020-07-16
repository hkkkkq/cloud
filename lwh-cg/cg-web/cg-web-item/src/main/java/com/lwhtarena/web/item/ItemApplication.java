package com.lwhtarena.web.item;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author liwh
 * @Title: ItemApplication
 * @Package com.lwhtarena.web.item
 * @Description:
 * @Version 1.0.0
 * @date 2020/7/15 18:25
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages = "com.lwhtarena.cg.goods.feign")
public class ItemApplication {
    public static void main(String[] args) {
        SpringApplication.run(ItemApplication.class,args);
    }
}
