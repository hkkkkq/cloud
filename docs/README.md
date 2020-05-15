# 微服务扫盲

1、微服务后台启动：
`nohup java -jar xxx.jar > dev/null 2>&1 &`

2、服务发现的两种方式

客户端发现：
 - Eureka 

服务端发现:
 - Nginx
 - Zookeeper
 - Kubernetes

3、微服务的特点：异构
 - 不同语言
 - 不同类型的数据库

理解分布式、架构的特点、原理 更重要！！！

好架构都是演进而来的，不是设计出来的

4、适合上微服务么？

业务形态不适合的
 - 系统中包含很多很强事务场景的
 - 业务相对稳定，迭代周期长
 - 访问压力不大，可用性要求不高
 - ...
 
康威定律

5、应用间通信

HTTP vs RPC
- Dubbo -- rpc 的代表
- Spring Cloud -- http 的代表

SpringCloud 中服务间两种restful调用方式
- RestTemplate 
- Feign

客户端负载均衡器：Ribbon
- RestTemplate
- Feign
- Zuul

Ribbon 的核心
- 服务发现
- 服务选择规则
- 服务监听

Ribbon 主要组件
- ServerList
- IRule
- ServerListFilter