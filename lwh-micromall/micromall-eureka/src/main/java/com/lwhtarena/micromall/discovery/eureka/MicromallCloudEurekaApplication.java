package com.lwhtarena.micromall.discovery.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author liwh
 * @Title: MicromallCloudEurekaApplication
 * @Package com.lwhtarena.micromall.discovery.eureka
 * @Description:
 * @Version 1.0.0
 * @date 2020/5/20 15:04
 */
@EnableEurekaServer
@SpringBootApplication
public class MicromallCloudEurekaApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicromallCloudEurekaApplication.class,args);
    }
}
