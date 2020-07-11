# kimzing-springcloud

## 项目简介

对SpringCloud官方及SpringCloud Alibab提供的组件进行选择组合，同时集成开源工具及自定义starter，提高开发效率。

## 设计目标及实现方式

- DONE-完善的[工具集](https://github.com/KimZing/kimzing-utils)。
- DONE-内部使用dubbo协议，对外统一提供http协议。
- DONE-服务异常能够向上传递并统一捕获包装。
- DONE-自动生成模板代码，生成即可运行
- DONE-聚合网关负责协议转换及接口信息聚合，同时负责包装统一返回体(timestamp,code,message,data)
- DONE-使用配置系统能够对系统进行及时刷新
- DONE-每个服务自动生成完善的文档展示
- DONE-具备灰度发布的能力
- DONE-所有项目的配置由配置中心统一管理，公共的配置统一抽离
- DONE-日志配置文件可收集
- TODO-分布式任务调度系统
- TODO-具备线上调试功能
- TODO-对调用链路能够进行查看并排错
- TODO-集成JWT与oauth2认证功能
- TODO-具备权限管理系统
- TODO-具备自动化部署能力
- TODO-能够对接口级别进行限流
- TODO-支持分布式事务

## 框架选型

- Dubbo + OpenFeign
dubbo用于内部服务间调用，openfeign用于调用外部调用
- Seata
用于处理分布式事务
- Sential
用于限流熔断，防止服务压力过大，造成雪崩
- SpringMVC
聚合服务中使用SpringMVC框架，同时更改运行容器为undertow
- Spring
Bean容器管理，粘合其他框架
- MybatisPlus
提供对数据库的操作ORM操作，同时使用其分页和慢SQL监控功能
- Druid
数据库连接池，同时提供SQL监控功能
- SpringBoot Admin
服务监控，可查看服务运行状态(CPU/内存/线程等)，查看环境变量，修改日志等级
- SpringCloud Gateway
网关
- Snif4j
用于服务聚合层生成Swagger页面，方便行程实时文档以及方便开发调用
- ELK
收集日志信息并展示，方便不同环境排查及定位问题。同时ElasticSearch也作为搜索组件
- RocketMQ
消息队列，支持事物消息、延时消息
- Redis
缓存数据

## 服务信息

|        服务名        |                主页            |  端口 |             描述                  |
|---------------------|-------------------------------|------|------------------------------------|
|kimzing-user     | http://localhost:8001/   | 8001 |                                    |

## 项目结构说明

### 父项目结构说明

```bash
|-- kimzing-springcloud
  |-- entry-admin             # 后台管理聚合服务，所有后台请求都经过该服务
  |-- entry-app               # APP端聚合服务，所有APP请求都经过该服务
  |-- entry-third             # 第三方聚合服务，提供给第三方的接口，如微信回调，数据暴露接口均从该服务进行暴露
  |-- gateway                 # 网关服务，对聚合服务做负载，同时会提供用户校验和日志记录功能
  |-- server-admin            # SpringBoot Admin监控服务
  |-- service-api             # 接口及Domain的公共依赖模块
  |-- service-order           # 订单服务
  |-- service-user            # 用户服务
  |-- tool-generator          # 代码生成工具
```

### 子项目结构说明

```bash

```

## 框架功能使用

工具集
- 对象映射
- Json转换
- 日期时间操作
- 加解密
- Spring容器操作(属性/Bean获取)
- 全局异常管理
- 分页工具
- 正则工具
- 字符串、集合、Map等校验工具

参数实体校验
添加dubbo的日志记录
加入跨域配置支持
切换druid连接池
集成支付模块
分页和基础库的结合
异常码和基础库的结合
接口访问速率限制注解
分布式锁工具（Redission）
dubbo全部服务的问题
做一个全局的管理用户信息读取
项目门户调度系统
配置的管理方式
gradle依赖管理方式
代码生成工具的使用
flyway的sql使用
枚举的使用
容器内事件的使用方式
springboot admin动态查看日志功能
日志logback收集日志
消息队列的使用

## 项目规约

domain命名规范
Redis使用规范
端口规范文档

无需组合的接口  可以直接返回BO对象
遵守阿里巴巴所有开发规范

数据库文件以时间戳进行命名，单位为妙
使用restful风格

聚合服务的创建原则规范

端口
server从7001开始
service从8001开始
entry从9001开始

端口必须记录在相应文档

分支以oneflow规范进行提交

分支以 dev   sit  uat  pro
环境   dev   sit  uat pro


使用nacos的命名空间做环境拆分，方便权限控制

创建nacos的不同用户并做权限划分

开发环境的账号密码为 dev:123456  
测试环境的账号密码为 sit:123456  
验收环境的账号密码为 uat:  
生产环境的账号密码为 pro:  

开发环境  dev
测试环境  sit
验收环境  uat
生产环境  pro

## 项目部署

需要传入不同环境的 
nacos-server-addr: localhost:8848
nacos-username: dev
nacos-password: 123456
active: dev
rocketmq需手动指定自己ip 否则无法获取正确的地址进行连接

## TODO

需要创建一个模板项目-全量的功能
编写前端展示页面
认证系统
分布式事务
限流熔断
任务调度系统
更改User模块事件通知为邮件
redis+mq+es
添加notify模块

Dockerfile
换underw容器
添加常用枚举类

## QA

如何调试本地的Dubbo接口？

聚合服务写在哪里？（开发常见QA List）
写在主的功能模块中
分页组件参数必须放在第一个   Page对象必须放在第一个
dubbo调用不到？检查version