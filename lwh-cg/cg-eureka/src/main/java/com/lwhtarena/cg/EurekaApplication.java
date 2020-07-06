package com.lwhtarena.cg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author liwh
 * @Title: EurekaApplication
 * @Package com.lwhtarena.cg
 * @Description: Eureka注册中心
 * @Version 1.0.0
 * @date 2020/7/2 05:19
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaApplication {
    public static void main(String[] args) {
        SpringApplication.run(EurekaApplication.class,args);
    }
}
