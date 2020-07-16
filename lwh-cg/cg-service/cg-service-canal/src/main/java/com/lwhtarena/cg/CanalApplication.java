package com.lwhtarena.cg;

import com.lwhtarena.cg.annotation.EnableCanalClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author liwh
 * @Title: CanalApplication
 * @Package com.lwhtarena.cg
 * @Description:
 * @SpringCloudApplication是一个注解的集合，其中包含@SpringBootApplication。
 *
 * 注解@SpringCloudApplication包括：@SpringBootApplication、@EnableDiscoveryClient、@EnableCircuitBreaker，
 * 分别是SpringBoot注解、注册服务中心Eureka注解、断路器注解。对于SpringCloud来说，这是每一微服务必须应有的三个注解，所以
 * 才推出了@SpringCloudApplication这一注解集合。
 *
 * @Version 1.0.0
 * @date 2020/7/12 14:36
 */
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
@SpringCloudApplication()
@EnableCanalClient
@EnableFeignClients(basePackages = {"com.lwhtarena.cg.content.feign","com.lwhtarena.cg.item.feign"})
public class CanalApplication {
    public static void main(String[] args) {
        SpringApplication.run(CanalApplication.class,args);
    }
}
