# MT互联网微服务电商

## 1、技术架构与技术选型

### 微服务分布式选型：
- SpringBoot2.X + SpringCloud2.X 构建
- Eureka 注册服务
- Gateway 网关
- Ribbon 本地负载均衡
- OpenFegin 服务调用
- Hystrix 服务降级、隔离、熔断、限流
- SpringCloud Bus + SpringCloud Stream + RabbitMQ + Kafak 
- CAS + JWT + Oauth2.0 安全控制和单点系统登录

### 分布式基础设施环境构建
- 分布式任务调度平台 XXL-Job
- 分布式日志采集系统 ELK
- 分布式事务解决方案 LCN
- 分布式锁解决方案 Zookeeper、Redis
- 分布式配置中心携程阿波罗
- 高并发分布式去全局ID生成雪花算法
- 分布式Session框架Spring-Session
- 分布式服务追踪与调度链ZipKin

### 部署环境
1、分布式设施环境，统一采用docker安装；
2、使用jenkins+docker+k8s实现自动化部署
3、

### 微服务接口整合swagger2

微服务项目中如何统一管理Swagger文档？

在网关实现

集群步骤：
- 在会员和微信模块加入swagger依赖jar包

### 微服务接口整合knife4j

#### Spring Boot单服务架构
maven中的pom.xml文件引入starter即可
```xml
<dependency>
    <groupId>com.github.xiaoymin</groupId>
    <artifactId>knife4j-spring-boot-starter</artifactId>
    <!--在引用时请在maven中央仓库搜索最新版本号-->
    <version>2.0.2</version>
</dependency>
```

knife4j-spring-boot-starter主要为我们引用的相关jar包：
- knife4j-spring:Swagger增强处理类
- knife4j-spring-ui:swagger的增强ui文档
- springfox-swagger:springfox最新2.9.2版本
- springfox-swagger-ui:springfox提供的ui
- springfox-bean-validators：springfxo验证支持组件

此时,位于包路径com.github.xiaoymin.knife4j.spring.configuration.Knife4jAutoConfiguration.java

类会为我们开启Swagger的增强注解,您只需要在项目中创建Swagger的Docket对象即可
```java
@Configuration
@EnableSwagger2
@EnableKnife4j
@Import(BeanValidatorPluginsConfiguration.class)
public class SwaggerConfiguration {
    
}
```

#### Spring Cloud微服务架构
在微服务架构下,引入微服务的starter
```xml
<dependency>
    <groupId>com.github.xiaoymin</groupId>
    <artifactId>knife4j-micro-spring-boot-starter</artifactId>
    <!--在引用时请在maven中央仓库搜索最新版本号-->
    <version>2.0.2</version>
</dependency>
```

knife4j-micro-spring-boot-starter的区别在于去掉了Swagger的前端UI包,只引入了后端的Java代码模块

主要包含的核心模块jar：
- knife4j-spring:Swagger增强处理类
- springfox-swagger:springfox最新2.9.2版本
- springfox-bean-validators：springfxo验证支持组件

注意：将swagger 依赖放入api模块中，注意统一写在接口中

### 架构设计注意事项
1、Maven项目中pom可以实现依赖继承

2、为什么项目需要把公开接口单独抽取出来的？目的是为什么？

就是为了feign客户端复用调用接口代码


