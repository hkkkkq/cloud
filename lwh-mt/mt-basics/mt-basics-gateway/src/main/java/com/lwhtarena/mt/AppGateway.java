package com.lwhtarena.mt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author liwh
 * @Title: AppGateway
 * @Package com.lwhtarena.mt
 * @Description: 网关入口
 * @Version 1.0.0
 * @date 2020/5/17 19:24
 */
@EnableEurekaClient
@EnableDiscoveryClient
@SpringBootApplication
public class AppGateway {
    public static void main(String[] args) {
        SpringApplication.run(AppGateway.class,args);
    }
}
