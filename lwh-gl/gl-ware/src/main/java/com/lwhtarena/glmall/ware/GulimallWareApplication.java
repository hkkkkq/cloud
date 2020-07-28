package com.lwhtarena.glmall.ware;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author liwh
 * @Title: GulimallWareApplication
 * @Package com.lwhtarena.glmall.ware
 * @Description:
 * @Version 1.0.0
 * @date 2020/7/25 14:18
 */
@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class GulimallWareApplication {

    public static void main(String[] args) {
        SpringApplication.run(GulimallWareApplication.class, args);
    }

}
