package com.lwhtarena.pay;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

/**
 * @author liwh
 * @Title: WeixinPayApplication
 * @Package com.lwhtarena
 * @Description:
 * @Version 1.0.0
 * @date 2020/8/2 06:31
 */
@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
@EnableEurekaClient
public class WeixinPayApplication {

    public static void main(String[] args) {
        SpringApplication.run(WeixinPayApplication.class,args);
    }

    /**
     * 业务开发中可能需要当前环境的判断，比如某些接口严禁生产环境下调用，有些接口只能再预发环境下才可用等。
     * 这个时候在Spring中可以使用Environment类。
     * 通常有两种方式, 一种是基于接口，一种是直接注入。
     * - 实现EnvironmentAware接口
     *  <pre>
     *      @Component
     *      public class EnvironmentHelper implements EnvironmentAware {
     *          private Environment environment;
     *
     *          private static final String PROD = "prod";
     *          private static final String PRE = "pre";
     *          private static final String QA = "qa";
     *
     *          public boolean isProd() { return environment.acceptsProfiles(PROD);}
     *          public boolean isPre() { return environment.acceptsProfiles(PRE);}
     *          public boolean isQa() { return environment.acceptsProfiles(QA);}
     *
     *          public String[] getActiveProfiles() {
     *              return environment.getActiveProfiles();
     *          }
     *
     *          @Override
     *          public void setEnvironment(Environment environment) {
     *              this.environment = environment;
     *          }
     *      }
     *  </pre>
     * - 直接注入
     *  <pre>
     *      @Component
     *      public class EnvironmentHelper{
     *
     *          @Autowired
     *          private Environment environment;
     *
     *          private static final String PROD = "prod";
     *          private static final String PRE = "pre";
     *          private static final String QA = "qa";
     *
     *          public boolean isProd() { return environment.acceptsProfiles(PROD);}
     *          public boolean isPre() { return environment.acceptsProfiles(PRE);}
     *          public boolean isQa() { return environment.acceptsProfiles(QA);}
     *
     *          public String[] getActiveProfiles() {
     *              return environment.getActiveProfiles();
     *          }
     *       }
     *  </pre>
     *
     */
    @Autowired
    private Environment env;

    /***
     * 创建DirectExchange交换机
     * @return
     */
    @Bean
    public DirectExchange basicExchange(){
        return new DirectExchange(env.getProperty("mq.pay.exchange.order"), true,false);
    }

    /***
     * 创建队列
     * @return
     */
    @Bean(name = "queueOrder")
    public Queue queueOrder(){
        return new Queue(env.getProperty("mq.pay.queue.order"), true);
    }

    /****
     * 队列绑定到交换机上
     * @return
     */
    @Bean
    public Binding basicBinding(){
        return BindingBuilder.bind(queueOrder()).to(basicExchange()).with(env.getProperty("mq.pay.routing.key"));
    }
}
