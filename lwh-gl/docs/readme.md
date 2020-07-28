# 谷粒电商B2C

谷粒商城-微服务架构图

![](./img/谷粒商城-微服务架构图.jpg)

## 技术搭配分案
```lua

├── SpringCloud Alibaba Nacos 注册中心（服务发现|注册）
│
├── Spring Alibaba Nacos 配置中心（动态配置管理）
│   
├── SpringCloud Ribbon 负载均衡
│
├── SpringCloud OpenFeign 生命式HTTP客户端（调用远程服务）
│
├── SpringCloud Alibaba Sentinal 服务容错（限流、降级、熔断）-- 替代hystrix
│
├── SpringCloud Gateway API网关（webflux编程模式）
│
├── SpringCloud Sleuth 调用链监控
│
├── SpringCloud Alibaba Seata 分布式事务解决方案
│
└── 完
```
