# kimzing-springcloud

## TODO

- 编写前端展示页面
- 认证系统
- es  商品搜索，相关搜索
- 业务日志使用mongodb存储,
- 使用定时任务检查订单的库存报警
- 使用Mongo存储浏览历史记录
- 缓存的操作方式
- 各种版本要对应上
- nacos的认证问题
- 查找nacos与dubbo结合时产生的元数据的解决方案

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
- DONE-支持分布式事务
- DONE-实现更规范的缓存模式
- DONE-分布式任务调度系统
- DONE-消息队列功能
- DONE-具备熔断降级动态化配置能力，能够对接口级别进行限流降级
- DONE-分布式文件存储服务
- DONE-具备线上调试功能
- DONE-对调用链路能够进行查看并排错
- TODO-集成JWT与oauth2认证功能
- TODO-具备权限管理系统
- TODO-具备自动化部署能力
- TODO-集成支付模块
- TODO-数据配置中心安全

## 框架选型

- Dubbo + OpenFeign
dubbo用于内部服务间调用，openfeign用于调用外部调用
- Seata
用于处理分布式事务
- Sentinel
用于限流熔断，防止服务压力过大，造成雪崩
- SpringMVC
聚合服务中使用SpringMVC框架，同时更改运行容器为undertow
- Spring
Bean容器管理，粘合其他框架
- MybatisPlus
提供对数据库的操作ORM操作，同时使用其分页和慢SQL监控功能
- Hikari
数据库连接池，简单即高效
- SpringBoot Admin
服务监控，可查看服务运行状态(CPU/内存/线程等)，查看环境变量，修改日志等级
- SpringCloud Gateway
网关
- Snif4j Swagger
用于服务聚合层生成Swagger页面，方便行程实时文档以及方便开发调用
- ELK
收集日志信息并展示，方便不同环境排查及定位问题。同时ElasticSearch也作为搜索组件
- RabbitMQ
消息队列，稳定可靠
- Redis
缓存数据
- Minio
文件存储
- Arthas
线上调试


## 服务信息

|        服务名        |                主页           |  端口 |             描述                  |
|---------------------|-------------------------------|------|-----------------------------------|
|server-admin         | http://localhost:7001/        | 7001 | springboot服务监控                 |
|gateway              | http://localhost:8080/        | 8080 | 网关负载                           |
|infra-notice         | http://localhost:8001/        | 8001 | 提醒服务，包含各种通知、站内信        |
|infra-search         | http://localhost:8002/        | 8002 | 搜索服务                           |
|infra-storage        | http://localhost:8003/        | 8003 | 文件存储服务                        |
|service-order        | http://localhost:8081/        | 8081 | 订单服务                           |
|service-product      | http://localhost:8082/        | 8082 | 订单服务                           |
|service-user         | http://localhost:8083/        | 8083 | 用户服务                           |
|entry-admin          | http://localhost:9001/admin   | 9091 | 后台管理入口                        |
|entry-app            | http://localhost:9002/app     | 9092 | app端入口                          |
|entry-third          | http://localhost:9003/third   | 9093 | 第三方接口                          |

## 三方组件服务信息

|        服务名        |                主页           |  端口 |             描述                  |
|---------------------|-------------------------------|------|-----------------------------------|
|nacos                | http://localhost:8848/nacos   | 8848 | nacos配置与服务发现                 |
|seata                | http://localhost:8091         | 8091 | 分布式事物                         |
|zipkin                | http://localhost:9411        | 9411 | 链路追踪                           |

## 数据库

|          服务名          |            描述                  |
|-------------------------|------------------------ ---------|

## 项目结构说明

### 父项目结构规范说明

聚合服务统一以`entry-【面向终端】`命名，独立的业务服务以`service-【业务模块名】`命名，工具以`tool-【工具名】`命名，
微服务生态的组件统一以`server-【组件名】`进行命名，网关即命名为`gateway`

```bash
|-- kimzing-springcloud
  |-- entry-admin             # 后台管理聚合服务，所有后台请求都经过该服务
  |-- entry-app               # APP端聚合服务，所有APP请求都经过该服务
  |-- entry-third             # 第三方聚合服务，提供给第三方的接口，如微信回调，数据暴露接口均从该服务进行暴露
  |-- gateway                 # 网关服务，对聚合服务做负载，同时会提供用户校验和日志记录功能
  |-- infra-storage           # 存储服务
  |-- infra-notice            # 用户提醒服务
  |-- server-admin            # SpringBoot Admin监控服务
  |-- service-api             # 接口及Domain的公共依赖模块
  |-- service-order           # 订单服务
  |-- service-product         # 商品服务
  |-- service-user            # 用户服务
  |-- tool-generator          # 代码生成工具
  |-- tool-template           # 项目模板
```

### 子项目结构规范说明

#### `entry-【终端】`结构规范

```bash
|-- com.kimzing.【终端】
  |-- aggregation            # 聚合业务
    |-- 【模块】              # 对应的模块
      |-- *Aggregation       # 聚合的业务代码，类似于Service，不过为了更清晰的概念使用Aggregation进行命名
  |-- common                 # 配置及工具
    |-- config               # 服务自身独有的配置，仅该项目自身需要。
    |-- utils                # 服务自身独有的工具，仅该项目自身需要。
  |-- controller             # web入口
    |-- 【模块】              # 对应的模块
      |-- *Controller        # web入口，按照业务进行划分不同的controller，内聚的业务可以直接调用下层dubbo接口并直接返回BO对象，\
      |--                    # 聚合的业务使用*Aggregation进行聚合，返回的聚合对象需写在domain包下
  |-- domain                 # 聚合对象
    |-- 【模块】              # 对应的模块
      |-- *BO                # 聚合业务中返回的聚合对象，以BO结尾
|-- resources
  |-- bootstrap.yaml         # 启动配置文件
  |-- exception.properties   # 异常Code码和message对应信息文件
  |-- logback-spring.xml     # logback日志配置文件
```

#### `service-api`结构规范

```bash
|-- com.kimzing
  |-- enums                  # 通用的枚举类
  |-- 【模块】                # 对应的模块名
     |-- domain              # 领域对象
       |-- 【功能】           # 对应的功能名
         |-- *DTO            # 客户端传输到服务端的对象(以DTO进行结尾，保存：*SaveDTO，更新：*UpdateDTO，查询：*QueryDTO)
         |-- *BO             # 服务端返回给客户端的对象
         |-- *Event          # 消息事件的对象，对象中要内置静态不可变的TOPIC字段，以方便发布和监听方进行统一使用
         |-- *Enum           # 对象中用到的枚举对象，可共用
     |-- service             # 公共接口
       |-- 【功能】           # 对应的功能名
         |-- *Service        # 功能接口
```

#### `infra-【模块】`结构规范

#### `service-【模块】`结构规范

```bash
|-- com.kimzing.【模块】
  |-- client                 # 使用其他协议调用第三方或相关服务，以Client结尾
  |-- common                 # 配置及工具
    |-- config               # 服务自身独有的配置，仅该项目自身需要，通用的则放在通用Starter中
    |-- utils                # 服务自身独有的工具，仅该项目自身需要，通用工具则放在通用工具集中
  |-- job                    # 任务调度(定时任务，通过xxljob进行调度)
    |-- 【功能】Job           # 以Job结尾，相关功能的定时任务写在一个类里，以不同方法做区分
  |-- listener               # 消息监听
    |-- *Listener            # 消息监听bean,以Listener结尾，不同事件有不同的Listener，如UserCreateListener，UserUpdateListener
  |-- publisher              # 消息发布
    |-- *Publisher           # 消息发布bean，以Pulisher结尾,每个功能仅有一个发布bean，如UserPublisher，OrderPublisher
  |-- repository             # 数据持久层
    |-- 【功能】              # 对应的功能名
      |-- *CachePO           # 缓存对象实体，同时继承父类`AbstractPO`的公共字段  
      |-- *CacheRepository]  # 缓存接口，添加@Repository注解
      |-- *PO                # 持久化对象实体，完全对应数据库表结构，同时继承父类`AbstractPO`的公共字段  
      |-- *Mapper            # Mybatis的数据仓储接口，添加@Mapper注解，在连表等操作时允许直接返回自定义数据结构的BO对象
  |-- service                # 业务服务代码编写层
    |-- 【功能】              # 对应的功能名
      |-- impl               # 功能接口实现类
|-- resources
  |-- db.migration           # flyway脚本文件
    |-- afterMigrateError.sql # 异常回退脚本
    |-- V1__seata.sql        # seata分布式事物SQL脚本
    |-- V时间戳_*.sql         # 数据库表sql或修补脚本
  |-- mapper                 # Mapper数据库DML文件
    |-- 【功能】Mapper.xml    # 具体功能的DML文件
  |-- bootstrap.yaml         # 启动配置文件
  |-- exception.properties   # 异常Code码和message对应信息文件
  |-- logback-spring.xml     # logback日志配置文件
```

## 项目启动配置

### Idea插件

1. lombok插件
项目中大量使用了Lombok插件自动生成Setter/Getter,以及链式调用代码，需确保安装了Lombok插件，并开启该插件的注解功能

## 框架功能使用(包含对应功能示例)

### 1. 工具集

项目中的各个模块均依赖了`com.kimzing:kimzing-utils:1.0.0-SNAPSHOT`依赖，该依赖封装了常用的工具类，在项目中要避免重复造轮子，统一使用该依赖中的工具，
如没有提供相应工具，则联系管理员进行添加，如果是该项目需要的特定工具类，则可以自己添加在项目的`common/utils`包下。

**工欲善其事必先利其器，务必仔细阅读工具项目的文档，避免重复造轮子[工具类说明](https://github.com/KimZing/kimzing-utils)， 欢迎start**

### 2. 自定义异常的使用方式

### 3. 方法参数及请求体校验

对于请求的领域对象(*DTO)的校验统一使用注解进行校验

### 4. 打印方法日志
Controller层日志，普通方法日志

### 5. Mybatis分页的使用

### 6. 分布式锁使用(Redission)

### 7. 获取当前操作的用户信息

### 8. 项目门户-查看项目提供的可视化功能入口

### 9. Nacos配置管理

### 10. Gradle依赖管理

### 11. 代码生成工具的使用

### 12. SQL脚本的管理方式及如何命名(Flyway)

### 13. 通过Admin查看服务信息及动态更改日志级别

### 14. 日志系统的收集与简单搜索(ELK)

### 15. 消息队列的使用方式
发送方，接收方

### 16. 远程调试功能

### 17. 定时任务的使用方式
1. 临时性任务，使用在线GLUE进行编写
2. 业务性任务，使用内置Bean方式进行编写

### 18. Redis缓存

### 19. 分布式锁

### 20. 布隆过滤器

### 21. 熔断降级Sentinel的使用

### 22. 文件存储服务

### 23. Arthas线上调试

`wget https://alibaba.github.io/arthas/arthas-boot.jar`

```bash
java -jar arthas-boot.jar
```

dashboard 仪表盘
webconsole: http://127.0.0.1:3658/
watch 查看方法调用返回
jad 反编译对应类
stop

### 24. zipkin对gateway/web/feign/mysql的链路追踪

mysql需要配置拦截器，注意版本的使用，这是个大坑

## 项目规约

> 遵守阿里巴巴所有开发规范,请熟读~
> 遵守阿里巴巴所有开发规范,请熟读~

### 日志打印规范

### 命名规范

1. 增删改查方法命名规范
controller/service  
repository
2. controller/Service/Repository/Mapper(XML)命名规范
3. domain命名规范
4. SQL脚本命名规范
数据库文件以时间戳进行命名，单位为妙

### 编码规范

金额统一使用BigDecimal
所有的领域对象统一使用链式调用
使用restful风格

### Redis使用规范

### RocketMQ消息队列使用规范

### 端口范围规范

server从7001开始
service从8001开始
entry从9001开始

端口必须记录在相应文档

### 聚合层聚合业务的界定规范

无需组合的接口  可以直接返回BO对象

### 分支规范

分支以oneflow规范进行提交

分支以 dev   sit  uat  pro
环境   dev   sit  uat pro

### nacos规范

使用nacos的命名空间做环境拆分，方便权限控制
开发环境  dev
测试环境  sit
验收环境  uat
生产环境  pro

创建nacos的不同用户并做权限划分

开发环境的账号密码为 dev:123456  
测试环境的账号密码为 sit:123456  
验收环境的账号密码为 uat:  
生产环境的账号密码为 pro:  

## 项目部署

### 基础组件部署
 
rocketmq部署文档
nacos部署文档
seata部署文档
mysql部署文档
redis部署文档
ELK部署文档
nginx部署文档
minio部署文档
sentinel部署文档
xxljob部署文档


### Jenkins部署

### 项目环境参数

需要传入不同环境的 
nacos-server-addr: localhost:8848
nacos-username: dev
nacos-password: 123456
active: dev
Dockerfile

## QA

### 1. 如何调试本地的Dubbo接口？

编写测试代码对dubbo接口进行测试

### 2. 聚合服务中的聚合业务代码写在哪里？

例如在订单Order中进行下单，同时需要调用支付模块Pay对订单完成支付，之后修改订单状态为PAYED，
那么聚合入口则写在OrderController中，对应的业务代码写在aggregation包下的OrderAggregation类中。

### 3. Mybatis的分页使用的是什么？为什么不生效？

分页使用的是MybatisPlus的内置分页插件，只需要传入第一个参数为`com.baomidou.mybatisplus.extension.plugins.pagination.Page`对象即可。
前端分页参数统一使用`com.kimzing.utils.page.PageParam`进行接收，使用`com.kimzing.utils.page.MPPageUtil.convertPage`方法将PageParam
转换为Page对象，使用`com.kimzing.utils.page.MPPageUtil.convertPageResult`将返回的IPage转换为`com.kimzing.utils.page.PageResult`对象。

```
@Transactional(readOnly = true)
public PageResult<UserBO> listPage(UserQueryDTO userQueryDTO, PageParam pageParam) {
    IPage<UserBO> userBOPage = userMapper.selectPage(convertPage(pageParam), userQueryDTO);
    return convertPageResult(userBOPage);
}
```

> 强调：分页Page对象必须放在第一个，分页Page对象必须放在第一个，分页Page对象必须放在第一个

### 4. 下游服务已经启动了，为什么上游服务还是调用不到？

> 首先实验下重启下游服务，可能是没注册上去，注册信息不同步

第一种情况要检查dubbo接口是否标注了version版本，标注的话要查看上游服务是否填写了版本及版本是否对应。
第二种情况要检查nacos的服务配置中是否对下游服务进行了订阅。
第三种情况是在windows平台下，要将防火墙关闭，否则相应的端口是访问不到的，自然无法进行访问服务了。

### 5. 控制台一直报错`no available service 'default' found, please make sure registry config corre`?

分布式事物框架seata报的错，因为在seata-server中没有对该服务进行配置，可以到nacos的`seata`命名空间中添加如下条目
`vgroupMapping.${你的应用名称}-group = "default"`

### 6. Windows启动main方法时报错`Error running 'XXXApplication': Command line is too long`

这是因为windows默认在运行时添加了过多的启动参数，将其进行调整即可。
打开运行列表(右上角的运行程序选择)-> Edit Configurations -> Templates -> Spring Boot -> Shorten Command Line -> 选择`JAR manifest`->点击ok应用即可
然后删除运行列表中的所有运行项，重新运行main方法即可

### 7. 源代码中文乱码或输出乱码

项目统一使用UTF-8编码，编译阶段对于非资源文件已经在`gradle.properties`指定了jvm参数`-Dfile.encoding=utf-8`
而对于Java文件同样在根项目`build.gradle`文件中指定了`tasks.withType(JavaCompile)`任务进行UTF-8编码

所以这时候乱码需要检查Idea的编码格式设置是否正确
将`File->Settings->Editor->File Encodings`中的编码全部设置为UTF-8编码

### 8. 查询方法为什么没有加事物注解@Transactional？

## 遇到的那些问题

### 全局结果封装返回String类型出错

### 全局结果封装导致内部feign调用返回空问题

### web日志打印引用对象出错

### dubbo异常传递处理