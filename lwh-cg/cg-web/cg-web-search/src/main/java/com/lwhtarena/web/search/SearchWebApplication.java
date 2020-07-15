package com.lwhtarena.web.search;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author liwh
 * @Title: SearchWebApplication
 * @Package com.lwhtarena.web.search
 * @Description:
 * @Version 1.0.0
 * @date 2020/7/15 10:48
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages = "com.lwhtarena.cg.search.feign")
public class SearchWebApplication {
    public static void main(String[] args) {
        SpringApplication.run(SearchWebApplication.class,args);
    }
}
