package com.lwhtarena.oauth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author liwh
 * @Title: OAuthApplication
 * @Package com.lwhtarena.oauth
 * @Description:
 * @Version 1.0.0
 * @date 2020/7/17 09:47
 */
@SpringBootApplication
@EnableDiscoveryClient
@MapperScan(basePackages = "com.lwhtarena.auth.dao")
@EnableFeignClients(basePackages = {"com.lwhtarena.cg.user.feign"})
public class OAuthApplication {

    public static void main(String[] args) {
        SpringApplication.run(OAuthApplication.class,args);
    }


    @Bean(name = "restTemplate")
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
