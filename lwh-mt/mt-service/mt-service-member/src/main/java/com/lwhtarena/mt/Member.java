package com.lwhtarena.mt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author liwh
 * @Title: Member
 * @Package com.lwhtarena.mt
 * @Description: 会员服务接口
 * @Version 1.0.0
 * @date 2020/5/16 23:24
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class Member {
    public static void main(String[] args) {
        SpringApplication.run(Member.class,args);
    }
}
