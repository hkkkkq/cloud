package com.lwhtarena.mt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author liwh
 * @Title: EurekaService
 * @Package com.lwhtarena.mt
 * @Description: eureka注册中心
 * @Version 1.0.0
 * @date 2020/5/16 21:25
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaService {
    public static void main(String[] args) {
        SpringApplication.run(EurekaService.class,args);
    }
}
