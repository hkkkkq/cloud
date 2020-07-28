package com.lwhtarena.glmall.thirdparty;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author liwh
 * @Title: GulimallThirdPartyApplication
 * @Package com.lwhtarena.glmall.thirdparty
 * @Description:
 * @Version 1.0.0
 * @date 2020/7/27 22:32
 */
@EnableDiscoveryClient
@SpringBootApplication
public class GulimallThirdPartyApplication {

    public static void main(String[] args) {
        SpringApplication.run(GulimallThirdPartyApplication.class, args);
    }

}
