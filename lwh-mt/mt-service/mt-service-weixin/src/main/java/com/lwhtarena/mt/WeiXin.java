package com.lwhtarena.mt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author liwh
 * @Title: WeiXin
 * @Package com.lwhtarena.mt
 * @Description: 微信服务启动
 * @Version 1.0.0
 * @date 2020/5/16 21:59
 */
@SpringBootApplication
@EnableEurekaClient
public class WeiXin {
    public static void main(String[] args) {
        SpringApplication.run(WeiXin.class,args);
    }
}
