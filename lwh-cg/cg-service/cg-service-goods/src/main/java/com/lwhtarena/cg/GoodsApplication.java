package com.lwhtarena.cg;

import com.lwhtarena.cg.entity.IdWorker;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author liwh
 * @Title: GoodsApplication
 * @Package com.lwhtarena.cg
 * @Description:
 *
 * <pre>
 * mapper接口继承了通用的mapper
 * 默认提供一些方法:
 * insert
 * update
 * delete
 * select
 * </pre>
 * @Version 1.0.0
 * @date 2020/7/2 06:08
 */
@SpringBootApplication
@EnableEurekaClient
/**注意 要使用通用的mapper的组件扫描**/
@MapperScan(basePackages = {"com.lwhtarena.cg.dao"})
public class GoodsApplication {
    public static void main(String[] args) {
        SpringApplication.run(GoodsApplication.class, args);
    }

    @Bean
    public IdWorker idWorker(){
        return new IdWorker(0,1);
    }
}
