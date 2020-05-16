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



