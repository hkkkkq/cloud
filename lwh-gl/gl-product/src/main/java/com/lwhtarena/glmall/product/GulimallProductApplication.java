package com.lwhtarena.glmall.product;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author liwh
 * @Title: GulimallProductApplication
 * @Package com.lwhtarena.glmall.product
 * @Description:
 *
 * 1、整合MyBatis-Plus
 *      1）、导入依赖
 *      <dependency>
 *             <groupId>com.baomidou</groupId>
 *             <artifactId>mybatis-plus-boot-starter</artifactId>
 *             <version>3.2.0</version>
 *      </dependency>
 *      2）、配置
 *          1、配置数据源；
 *              1）、导入数据库的驱动。https://dev.mysql.com/doc/connector-j/8.0/en/connector-j-versions.html
 *              2）、在application.yml配置数据源相关信息
 *          2、配置MyBatis-Plus；
 *              1）、使用@MapperScan
 *              2）、告诉MyBatis-Plus，sql映射文件位置
 *
 * 2、逻辑删除
 *  1）、配置全局的逻辑删除规则（省略）
 *  2）、配置逻辑删除的组件Bean（省略）
 *  3）、给Bean加上逻辑删除注解@TableLogic
 *
 * 3、JSR303
 *   1）、给Bean添加校验注解:javax.validation.constraints，并定义自己的message提示
 *   2)、开启校验功能@Valid
 *      效果：校验错误以后会有默认的响应；
 *   3）、给校验的bean后紧跟一个BindingResult，就可以获取到校验的结果
 *   4）、分组校验（多场景的复杂校验）
 *         1)、	@NotBlank(message = "品牌名必须提交",groups = {AddGroup.class,UpdateGroup.class})
 *          给校验注解标注什么情况需要进行校验
 *         2）、@Validated({AddGroup.class})
 *         3)、默认没有指定分组的校验注解@NotBlank，在分组校验情况@Validated({AddGroup.class})下不生效，只会在@Validated生效；
 *
 *   5）、自定义校验
 *      1）、编写一个自定义的校验注解
 *      2）、编写一个自定义的校验器 ConstraintValidator
 *      3）、关联自定义的校验器和自定义的校验注解
 *      @Documented
 * @Constraint(validatedBy = { ListValueConstraintValidator.class【可以指定多个不同的校验器，适配不同类型的校验】 })
 * @Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE })
 * @Retention(RUNTIME)
 * public @interface ListValue {
 *
 * 4、统一的异常处理
 * @ControllerAdvice
 *  1)、编写异常处理类，使用@ControllerAdvice。
 *  2)、使用@ExceptionHandler标注方法可以处理的异常。
 * @Version 1.0.0
 * @date 2020/7/25 12:42
 *
 *  5、模板引擎
 *   1)、thymeleaf-starter：关闭缓存--开发期间
 *   2)、静态资源都放在static文件下就可以安装路径直接访问
 *   3)、页面放在templates下，直接可以访问
 *      springboot，访问项目的时候，默认找index
 *   4)、页面修改不重启服务器实时更新
 *     4.1)、引入dev-tools
 *     4.2)、修改页面controller --shift f9重新自动编译页面。代码配置，推荐重启
 *
 *  6、整合redis
 *   1)、引入data-redis-starter
 *   2)、简单配置redis的host等信息
 *   3)、使用SpringBoot自动配置好的StringRedisTemplate来操作redis
 *      redis -> map ;存放数据key，数据值value
 *
 *  7、整合redisson作为分布式锁等功能框架
 *   1)、引入依赖
 *         <dependency>
 *             <groupId>org.redisson</groupId>
 *             <artifactId>redisson</artifactId>
 *             <version>3.12.0</version>
 *         </dependency>
 *    2)、配置redisson
 *      MyRedissonConfig给容器中配置一个RedissonClient实例即可
 *    3)、使用
 *      参照文档做
 *
 *  8、整合Spring cache 简化缓存开发
 *    1)、引入依赖`spring-boot-starter-cache、spring-boot-starter-data-redis`
 *         <dependency>
 *             <groupId>org.springframework.boot</groupId>
 *             <artifactId>spring-boot-starter-cache</artifactId>
 *         </dependency>
 *         <dependency>
 *             <groupId>org.springframework.boot</groupId>
 *             <artifactId>spring-boot-starter-data-redis</artifactId>
 *         </dependency>
 *    2)、写配置
 *      （1）自动配置了哪些？
 *          CacheAutoConfiguration会导入RedisAutoConfiguration；
 *          自动配好了缓存管理器RedisCacheManager
 *      （2）配置使用redis作为缓存
 *    3)、测试使用缓存
 *     @Cacheable：触发将数据保存到缓存的操作
 *     @CacheEvict：触发将数据从缓存删除的操作
 *     @CachePut：不影响方法执行更新缓存
 *     @Caching：组合以上多个操作
 *     @CacheConfig：在类级别共享缓存的相同配置
 *
 *      （1）开启缓存功能，@EnableCaching
 *          在主程序入口`@EnableCaching`
 *      （2）只需要使用注解就能完成缓存操作
 *     4)、原理：
 *      CacheAutoConfiguration->RedisCacheConfiguration->自动配置了RedisCacheManager
 *     ->初始化所有的缓存->每个缓存决定使用什么配改置->如果redisCacheConfiguration有就用已有的，没有就用默认配置
 *     ->想改缓存的配置，只需要给容器中放一个RedisCacheConfiguration即可->就会应用到当前RedisCacheManager管理的所有缓存分区中
 *
 *
 *
 */

@EnableFeignClients(basePackages = "com.lwhtarena.glmall.product.feign")
@EnableDiscoveryClient
@MapperScan("com.lwhtarena.glmall.product.dao")
@SpringBootApplication
public class GulimallProductApplication {

    public static void main(String[] args) {
        SpringApplication.run(GulimallProductApplication.class, args);
    }

}
