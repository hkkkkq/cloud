package com.lwhtarena.red;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author liwh
 * @Title: Eureka
 * @Package com.lwhtarena.red
 * @Description:
 * @Version 1.0.0
 * @date 2020/9/21 21:41
 */

@SpringBootApplication
@EnableEurekaServer
public class Eureka {

    public static void main(String[] args) {
        new SpringApplicationBuilder(Eureka.class).run(args);
    }
}
