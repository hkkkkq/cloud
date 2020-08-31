package com.lwhtarena.glmall.product.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author liwh
 * @Title: MybatisConfig
 * @Package com.lwhtarena.glmall.product.config
 * @Description: mybatis 配置
 *
 * @Version 1.0.0
 * @date 2020/8/31 16:15
 */
@Configuration
@EnableTransactionManagement //开启事务
@MapperScan("com.lwhtarena.glmall.product.dao")
public class MybatisConfig {

    /**
     * 引入分页插件
     * @return
     */
    @Bean
    public PaginationInterceptor paginationInterceptor(){
        PaginationInterceptor interceptor = new PaginationInterceptor();

        /**设置请求的页面大于最大页面后操作，true返回首页，false为继续请求，默认为false**/
        interceptor.setOverflow(true);
        /**设置最大单页限制数量，默认是500，-1不受限制**/
        interceptor.setLimit(1000);
        return interceptor;
    }

}
