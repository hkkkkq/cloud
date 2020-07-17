package com.lwhtarena.cg;

import com.lwhtarena.cg.entity.IdWorker;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author liwh
 * @Title: OrderApplication
 * @Package com.lwhtarena.cg
 * @Description:
 * @Version 1.0.0
 * @date 2020/7/17 21:59
 */
@SpringBootApplication
@EnableEurekaClient
@MapperScan(basePackages = "com.lwhtarena.cg.dao")
@EnableFeignClients(basePackages = {"com.lwhtarena.cg.goods.feign", "com.lwhtarena.cg.user.feign"})
public class OrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderApplication.class, args);
    }

    @Bean
    public IdWorker idWorker(){
        return new IdWorker(0,1);
    }
}
