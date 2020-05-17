package com.lwhtarena.mt.config;

import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.annotation.Order;
import springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author liwh
 * @Title: SwaggerConfiguration
 * @Package com.lwhtarena.mt.config
 * @Description: 配置扫描目录包
 *   通过@EnableSwagger2和@EnableSwaggerBootstrapUi来开启swagger和增强特性
 *   @EnableSwaggerBootstrapUi 在2.0.0 之后删除，取而代之是 @EnableKnife4j
 * @Version 1.0.0
 * @date 2020/5/17 13:10
 */
@Configuration
@EnableSwagger2
@EnableKnife4j
@Import(BeanValidatorPluginsConfiguration.class)
public class SwaggerConfiguration {

    @Bean(value = "WeiXinApi")
    @Order(value = 1)
    public Docket groupRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(groupApiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.lwhtarena.mt.**.controller"))
                .paths(PathSelectors.any())
                .build();
    }


    private ApiInfo groupApiInfo(){
        return new ApiInfoBuilder()
                .title("swagger-bootstrap-ui很棒~~~！！！")
                .description("<div style='font-size:14px;color:red;'>MT 商城 RESTful APIs</div>")
                .termsOfServiceUrl("http://www.lwhtarena.com/")
                .contact("lwhtarena@163.com")
                .version("1.0.0")
                .build();
    }

}
