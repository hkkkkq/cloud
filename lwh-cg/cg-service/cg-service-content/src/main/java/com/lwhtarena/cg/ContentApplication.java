package com.lwhtarena.cg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author liwh
 * @Title: ContentApplication
 * @Package com.lwhtarena.cg
 * @Description:
 * @Version 1.0.0
 * @date 2020/7/13 06:14
 */
@SpringBootApplication
@EnableEurekaClient
@MapperScan(basePackages = {"com.lwhtarena.cg.dao"})
public class ContentApplication {

    public static void main(String[] args) {
        SpringApplication.run(ContentApplication.class);
    }
}
