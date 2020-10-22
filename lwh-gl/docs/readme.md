# 谷粒电商B2C

谷粒商城-微服务架构图

![](./img/谷粒商城-微服务架构图.jpg)

## 一、环境

Sentinel:
    http://192.168.1.15:8858    管理平台帐号密码：sentinel|sentinel

Zipkin服务器：
    在浏览器访问：http://192.168.1.15:9411/zipkin/
    docker run -d --restart always -p 9411:9411 --name zipkin openzipkin/zipkin 

Nacos服务器: 
    http://192.168.1.15:8848/nacos  管理平台帐号密码：nacos|nacos

ElasticSearch: 
    http://192.168.1.15:9200 
    
kibana:
    http://192.168.1.15:5601/
    
Redis:
    192.168.1.15:6379  密码：tarena
    
Mysql:
    192.168.1.15:3306  帐号密码：root|root
    
RabbitMQ：
    http://192.168.1.15:15672/   管理平台帐号密码：guest|guest
    
FastDFS：文件服务器
    http://192.168.1.15:8080/group1/M00/00/00/wKgBD19KOhqAbCclAAFyMqlssRE301.jpg
  
  http.tracker_http_port=8080 //tracker的http通信协议的端口
  tracker_server=192.168.1.15:22122 //22122 trackerserver的tcp 端口
    

## 二、技术搭配分案
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

## 三、技术基础篇
### 1、分布式基础概念
微服务、注册中心、配置中心、远程调用、Feign、网关

### 2、基础开发
SpringBoot2.0、 SpringCloud、Mybatis-Plus、Vue组件化、阿里云对象存储

### 3、环境
Vagrant、Linux、Docker、Mysql、Redis、逆向工程&人人开源

### 4、开发规范
- 数据校验JSR303、全局异常处理、全局统一返回、全局跨域处理
- 枚举状态、业务状态码、VO与TO与PO划分、逻辑删除
- Lombok：@Data、@Slf4j


## 四、解决跨域问题
1、使用nginx部署同一个域（不适合开发期间）

2、配置当次请求允许跨域（开发期间使用）
  添加响应头

## 五、前端vue中使用pubsub进行兄弟之间传值
通过npm（npm install pubsub-js）安装；

**导入**
```js
import PubSub from "pubsub-js"
```

- 全新的 KaTeX数学公式 语法；
- 增加了支持甘特图的mermaid语法1 功能；
- 增加了 多屏幕编辑 Markdown文章功能；
- 增加了 焦点写作模式、预览模式、简洁写作模式、左右区域同步滚轮设置 等功能，功能按钮位于编辑区域与预览区域中间；
- 增加了 检查列表 功能。

### 1、a组件传值给b组件
```js
//a组件
PubSub.publish("search", name);

//b组件
PubSub.subscribe("search", (msg, name) => {
 
  const url = `https://api.github.com/search/users?q=${name}`
  axios.get(url).then(response => {
    const result = response.data;
    const users = result.items.map(item => ({
      url: item.html_url,
      avatar_url: item.avatar_url,
      name: item.login
    }));
  
  });
});
```










