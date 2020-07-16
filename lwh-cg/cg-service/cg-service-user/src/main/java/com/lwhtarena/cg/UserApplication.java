package com.lwhtarena.cg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author liwh
 * @Title: UserApplication
 * @Package com.lwhtarena.cg
 * @Description:
 * @Version 1.0.0
 * @date 2020/7/16 19:23
 */
@SpringBootApplication
@EnableEurekaClient
/**mapper扫描 用通用的ampper扫描器**/
@MapperScan("com.lwhtarena.cg.dao")
public class UserApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserApplication.class, args);
    }
}
