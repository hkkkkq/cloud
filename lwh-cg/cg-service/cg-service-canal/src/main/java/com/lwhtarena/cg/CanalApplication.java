package com.lwhtarena.cg;

import com.lwhtarena.cg.annotation.EnableCanalClient;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;

/**
 * @author liwh
 * @Title: CanalApplication
 * @Package com.lwhtarena.cg
 * @Description:
 * @Version 1.0.0
 * @date 2020/7/12 14:36
 */

@SpringCloudApplication
@EnableCanalClient
public class CanalApplication {
    public static void main(String[] args) {
        SpringApplication.run(CanalApplication.class,args);
    }
}
