/*
 Navicat Premium Data Transfer

 Source Server         : 腾讯云
 Source Server Type    : MySQL
 Source Server Version : 50732
 Source Host           : mysql.kimzing.com:3306
 Source Schema         : springcloud-nacos

 Target Server Type    : MySQL
 Target Server Version : 50732
 File Encoding         : 65001

 Date: 07/11/2020 16:50:13
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for config_info
-- ----------------------------
DROP TABLE IF EXISTS `config_info`;
CREATE TABLE `config_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `data_id` varchar(255) COLLATE utf8_bin NOT NULL COMMENT 'data_id',
  `group_id` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `content` longtext COLLATE utf8_bin NOT NULL COMMENT 'content',
  `md5` varchar(32) COLLATE utf8_bin DEFAULT NULL COMMENT 'md5',
  `gmt_create` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
  `src_user` text COLLATE utf8_bin COMMENT 'source user',
  `src_ip` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT 'source ip',
  `app_name` varchar(128) COLLATE utf8_bin DEFAULT NULL,
  `tenant_id` varchar(128) COLLATE utf8_bin DEFAULT '' COMMENT '租户字段',
  `c_desc` varchar(256) COLLATE utf8_bin DEFAULT NULL,
  `c_use` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `effect` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `type` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `c_schema` text COLLATE utf8_bin,
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_configinfo_datagrouptenant` (`data_id`,`group_id`,`tenant_id`)
) ENGINE=InnoDB AUTO_INCREMENT=49 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='config_info';

-- ----------------------------
-- Records of config_info
-- ----------------------------
BEGIN;
INSERT INTO `config_info` VALUES (1, 'server-admin.yaml', 'DEFAULT_GROUP', 'server:\n  port: 7001\n  \nspring:\n  boot:\n    admin:\n      discovery:    \n        ignored-services: seata-server\n      notify:\n        mail:\n          # 配置邮件通知开关\n          enabled: false\n          # 告警发件人\n          from: ${spring.mail.username}\n          # 告警收件人\n          to: kimzing@163.com\n  # 配置发送告警的邮箱\n  mail:\n    host: smtp.163.com\n    username: kimnotice@163.com\n    password: Kim123456\n    default-encoding: utf-8\n    port: 465\n    properties:\n      mail:\n        smtp:\n          auth: true\n          ssl:\n            enable: true', 'c4805ab137065e7110d736c57c6cc716', '2020-11-04 11:36:00', '2020-11-04 11:36:00', NULL, '173.242.120.158', '', 'dev', NULL, NULL, NULL, 'yaml', NULL);
INSERT INTO `config_info` VALUES (2, 'entry-admin.yaml', 'DEFAULT_GROUP', 'server:\n  port: 9091\n  servlet:\n    context-path: /admin\n\ndubbo:\n  cloud:\n    # 服务消费方订阅服务提供方的应用名称的列表\n    # 若需订阅多应用，使用 \",\" 分割\n    subscribed-services: service-user,service-order,service-product\n  scan:\n    # dubbo 服务扫描基础包路径\n    base-packages: com.kimzing.admin\n\nseata:\n  service:\n    vgroup-mapping:\n      entry-admin-group: default', '896a551ffa6efdd7d198bd81a4fef2b9', '2020-11-04 11:36:00', '2020-11-04 11:36:00', NULL, '173.242.120.158', '', 'dev', NULL, NULL, NULL, 'yaml', NULL);
INSERT INTO `config_info` VALUES (3, 'entry-app.yaml', 'DEFAULT_GROUP', 'server:\n  port: 9092\n  servlet:\n    context-path: /app\n\ndubbo:\n  cloud:\n    # 服务消费方订阅服务提供方的应用名称的列表\n    # 若需订阅多应用，使用 \",\" 分割\n    subscribed-services: service-user,service-order,service-product\n  scan:\n    # dubbo 服务扫描基础包路径\n    base-packages: com.kimzing.app\n\nseata:\n  service:\n    vgroup-mapping:\n      entry-app-group: default', '888d9d99fd67d34f815972a4a08e6614', '2020-11-04 11:36:00', '2020-11-04 11:36:00', NULL, '173.242.120.158', '', 'dev', NULL, NULL, NULL, 'yaml', NULL);
INSERT INTO `config_info` VALUES (4, 'gateway.yaml', 'DEFAULT_GROUP', 'server:\n  port: 8080\n  \nspring:\n  cloud:\n    gateway:\n      globalcors:\n        corsConfigurations:\n          \'[/**]\':\n            allowedOrigins: \"*\"\n            allowedMethods: \"*\"\n            allowedHeaders: \"*\"\n      discovery:\n          locator:\n            enabled: true\n            lower-case-service-id: true', '1aa64c4867090063b638c480b5fc0b22', '2020-11-04 11:36:00', '2020-11-04 11:36:00', NULL, '173.242.120.158', '', 'dev', NULL, NULL, NULL, 'yaml', NULL);
INSERT INTO `config_info` VALUES (5, 'service-user.yaml', 'DEFAULT_GROUP', 'server:\n  port: 8083\n    \nspring:\n  # 对应 RedisProperties 类\n  redis:\n    host: redis.kimzing.com\n    port: 6379\n    # Redis 服务器密码，默认为空。生产中，一定要设置 Redis 密码！\n    password: 123456\n    # Redis 数据库号，默认为 0\n    database: 0\n    # Redis 连接超时时间，单位：毫秒\n    timeout: 1000\n  datasource:\n    # 添加&allowMultiQueries=true使得一个接口可以执行多条语句\n    url: jdbc:mysql://mysql.kimzing.com:3306/springcloud-user?characterEncoding=utf8&connectTimeout=1000&socketTimeout=3000&autoReconnect=true&useUnicode=true&useSSL=false&serverTimezone=UTC&allowMultiQueries=true&queryInterceptors=brave.mysql8.TracingQueryInterceptor&exceptionInterceptors=brave.mysql8.TracingExceptionInterceptor&zipkinServiceName=mysql-${spring.application.name}\n    username: root\n    password: 123456\n\ndubbo:\n  cloud:\n    # 服务消费方订阅服务提供方的应用名称的列表\n    # 若需订阅多应用，使用 \",\" 分割\n    subscribed-services: \"\"\n  scan:\n    # dubbo 服务扫描基础包路径\n    base-packages: com.kimzing.user.service\n\nseata:\n  service:\n    vgroup-mapping:\n      service-user-group: default\n    \n# 百度地图配置(模拟)\nbaidu:\n  map:\n    url: https://baidu.com/map', 'ffbb6fccbafbd6ac0864c141083a2e21', '2020-11-04 11:36:00', '2020-11-07 08:24:08', NULL, '80.251.209.156', '', 'dev', '', '', '', 'yaml', '');
INSERT INTO `config_info` VALUES (6, 'service-order.yaml', 'DEFAULT_GROUP', 'server:\n  port: 8081\n\nspring:\n  datasource:\n    # 添加&allowMultiQueries=true使得一个接口可以执行多条语句\n    url: jdbc:mysql://mysql.kimzing.com:3306/springcloud-order?characterEncoding=utf8&connectTimeout=1000&socketTimeout=3000&autoReconnect=true&useUnicode=true&useSSL=false&serverTimezone=UTC&allowMultiQueries=true&queryInterceptors=brave.mysql8.TracingQueryInterceptor&exceptionInterceptors=brave.mysql8.TracingExceptionInterceptor&zipkinServiceName=mysql-${spring.application.name}\n    username: root\n    password: 123456\n\ndubbo:\n  cloud:\n    # 服务消费方订阅服务提供方的应用名称的列表\n    # 若需订阅多应用，使用 \",\" 分割\n    subscribed-services: \"\"\n  scan:\n    # dubbo 服务扫描基础包路径\n    base-packages: com.kimzing.order\n\nseata:\n  service:\n    vgroup-mapping:\n      service-order-group: default\n\n# 百度地图配置(模拟)\nbaidu:\n  map:\n    url: https://baidu.com/map', 'f6fa2e48f16ff2f1d78666eb4bab6726', '2020-11-04 11:36:00', '2020-11-07 08:12:08', NULL, '80.251.209.156', '', 'dev', '', '', '', 'yaml', '');
INSERT INTO `config_info` VALUES (7, 'entry-third.yaml', 'DEFAULT_GROUP', 'server:\n  port: 9093\n  servlet:\n    context-path: /third\n\ndubbo:\n  cloud:\n    # 服务消费方订阅服务提供方的应用名称的列表\n    # 若需订阅多应用，使用 \",\" 分割\n    subscribed-services: service-user,service-order,service-product\n  scan:\n    # dubbo 服务扫描基础包路径\n    base-packages: com.kimzing.third\n\nseata:\n  service:\n    vgroup-mapping:\n      entry-third-group: default', 'e86567e62fd375f4cafbe72cf23f095b', '2020-11-04 11:36:00', '2020-11-04 11:36:00', NULL, '173.242.120.158', '', 'dev', NULL, NULL, NULL, 'yaml', NULL);
INSERT INTO `config_info` VALUES (8, 'common.yaml', 'DEFAULT_GROUP', '# ===============Spring配置=================\nspring:\n  datasource:\n    driver-class-name: com.mysql.cj.jdbc.Driver\n    hikari:\n      max-lifetime: 60000\n  servlet:\n    multipart:\n      # 单个上传文件大小\n      max-file-size: 50MB\n      # 请求允许的总大小\n      max-request-size: 50MB\n  cloud:\n    # Sentinel 配置项，对应 SentinelProperties 配置属性类\n    sentinel:\n      # 是否开启。默认为 true 开启\n      enabled: true\n      # 是否饥饿加载。默认为 false 关闭\n      eager: true\n      transport:\n        # Sentinel 控制台地址\n        dashboard: localhost:8858\n      filter:\n        # 拦截请求的地址。默认为 /*\n        url-patterns: /**\n      # Sentinel 规则的数据源，是一个 Map 类型。key 为数据源名，可自定义；value 为数据源的具体配置\n      datasource:\n        ds1:\n          # 对应 DataSourcePropertiesConfiguration 类\n          nacos:\n            # Nacos 服务器地址\n            server-addr: ${nacos-server-addr:nacos.kimzing.com:8848}\n            username: dev\n            password: 123456\n            namespace: ${spring.profiles.active}\n            # Nacos 分组\n            group-id: DEFAULT_GROUP\n            # Nacos 配置集编号\n            data-id: ${spring.application.name}-rule\n            # 数据格式\n            data-type: json\n            # 规则类型\n            rule-type: FLOW\n  zipkin:\n    # Zipkin 服务的地址\n    base-url: http://zipkin.kimzing.com:9411\n  sleuth:\n    # 针对 Web 组件的配置项\n    web:\n      # 是否开启，默认为 true\n      enabled: true\n    # 针对 Feign 组件的配置项\n    feign:\n      # 是否开启，默认为 true\n      enabled: true\n    # 针对 Slf4j 组件的配置项\n    log:\n      slf4j:\n        # 是否开启，默认为 true\n        enabled: true\n    # 针对抽样收集的配置项，两个配置项都设置的情况下，采用 ProbabilityBasedSampler 采样器\n    sampler:\n      # 采样百分比，默认为空\n      probability: 1\n      # 限流采样，即每秒可收集链路的数量，默认为 10\n      rate: 10\n  # 设置flyway不校验丢失的文件, 因为每个服务都使用独立的数据源，所以可以关闭该选项\n  #flyway:\n    #ignore-missing-migrations: true\n# ===============Actuator管理端口=================\nmanagement:\n  endpoints:\n    web:\n      exposure:\n        include: \'*\'\n  endpoint:\n    health:\n      show-details: always\n# ===============RocketMQ公共配置==============\n# 对应 RocketMQProperties 配置类\nrocketmq:\n  # RocketMQ Namesrv\n  name-server: localhost:9876\n  # Producer 配置项\n  producer:\n    group: ${spring.application.name}-group\n    # 发送消息超时时间，单位：毫秒。默认为 3000 。\n    send-message-timeout: 3000\n    # 消息压缩阀值，当消息体的大小超过该阀值后，进行消息压缩。默认为 4 * 1024B\n    compress-message-body-threshold: 4096\n    # 消息体的最大允许大小。。默认为 4 * 1024 * 1024B\n    max-message-size: 4194304\n    # 同步发送消息时，失败重试次数。默认为 2 次。\n    retry-times-when-send-failed: 2\n    # 异步发送消息时，失败重试次数。默认为 2 次。\n    retry-times-when-send-async-failed: 2\n    # 发送消息给 Broker 时，如果发送失败，是否重试另外一台 Broker 。默认为 false\n    retry-next-server: true\n    # 是否开启消息轨迹功能。默认为 true 开启。\n    enable-msg-trace: true\n    # 自定义消息轨迹的 Topic 。默认为 RMQ_SYS_TRACE_TOPIC 。\n    customized-trace-topic: RMQ_SYS_TRACE_TOPIC\n  # Consumer 配置项\n  consumer:\n    # 配置某个消费分组，是否监听指定 Topic 。结构为 Map<消费者分组, <Topic, Boolean>> 。默认情况下，不配置表示监听。\n    listeners:\n      test-group:\n        # 关闭 test-consumer-group 对 topic1 的监听消费\n        test: false\n# ===============分布式事物Seata公共配置==============\nseata:\n  enabled: true\n  application-id: ${spring.application.name}\n  tx-service-group: ${spring.application.name}-group\n  enable-auto-data-source-proxy: true\n  registry:\n    type: nacos\n    nacos:\n      application: seata-server\n      namespace: ${spring.profiles.active}\n      server-addr: ${nacos-server-addr:nacos.kimzing.com:8848}\n      username: ${nacos-username:dev}\n      password: ${nacos-password:123456}\n# ===============Dubbo公共配置=================\ndubbo:\n  consumer:\n    # 默认超时时间\n    timeout: 3000\n    # 开启消费端参数校验\n    validation: true\n    # 关闭提供者检查\n    check: false\n    # 链路跟踪\n    filter: tracing\n  provider:\n    validation: true\n    filter: -exception,exceptionFilter,-validation,validationFilter,tracing\n    exception:\n      package: com.kimzing.\n  # 挂载到 Nacos 注册中心\n  registry:\n    # address: nacos://localhost:8848?namespace=dubbo&username=nacos&password=nacos\n    # address: nacos://nacos.kimzing.com:8848\n    address: spring-cloud://localhost\n  # Dubbo 服务暴露的协议配置\n  protocol:\n    id: dubbo\n    # 协议名称\n    name: dubbo\n    # 协议端口（ -1 表示自增端口，从 20880 开始）\n    port: -1\n\n# ===============knife4j公共配置=================\n# knife开源的swagger ui配置\nknife4j:\n  # 是否是生产环境，如果是生产环境会默认关闭swagger\n  production: false\n  # 配置自定义markdown文件的位置\n  markdowns: classpath:markdown/*\n  # 配置认证功能\n  basic:\n    # 是否开启认证\n    enable: true\n    # 用户名\n    username: admin\n    # 密码\n    password: 123456\n\n# ===============mybatis公共配置=================\nmybatis-plus:\n  configuration:\n    log-impl: org.apache.ibatis.logging.stdout.StdOutImpl\n    # 下划线转驼峰\n    map-underscore-to-camel-case: true\n# ===============自定义Starter功能配置=================\n# 基本属性配置\nkimzing:\n  sentinel:\n    enabled: true\n    exceptionHandler:\n      # 异常拦截开关\n      enabled: true\n      # 提示码\n      code: SECURITY\n      # 提示信息\n      message: 请求已被安全管控系统拦截，请联系管理员:kimzing@163.com\n  redis:\n    enabled: true\n    prefix: ${spring.application.name}\n    time-pattern: \"yyyy-MM-dd HH:mm:ss\"\n  log:\n    # 方法日志开关(默认false)\n    enabled: true\n    # 日志中的时间戳格式(可选)\n    time-pattern: yyyy-MM-dd HH:mm:ss:SSS\n  web:\n    escape:\n      # 是否开启URL和Cookie转义字符(默认true)\n      enabled: true\n    resolver:\n      # 是否开启Get请求方法解析(默认true)\n      json:\n        enabled: true\n    # 结果统一封装\n    result:\n      enabled: true\n      package: com.kimzing\n    advice:\n      # 是否启用异常拦截(默认false)\n      enabled: true\n    log:\n      # 是否启用请求日志打印(默认true)\n      enabled: true\n    cors:\n      # 是否开启跨域支持(默认true)\n      enabled: true\n      origins:\n        - \"*\"\n    restTemplate:\n      # 是否自动配置RestTemplate(默认true)\n      enabled: true\n    info:\n      # 是否启用/info接口(默认false)\n      enabled: true\n      # 接口路径\n      path: /\n      params:\n        application: ${spring.application.name}\n        port: ${server.port}\n        profile: ${spring.profiles.active}\n        version: ${spring.application.version}\n        description: ${spring.application.description}\n  # swagger配置\n  swagger:\n    # 当存在swagger依赖时，是否开启(默认true)\n    enabled: true\n    title: ${spring.application.name}-聚合服务\n    description: 聚合或代理内部接口对外提供服务\n    #termsOfServiceUrl: 项目服务地址\n    #authorName: 作者\n    #authorEmail: 作者邮箱\n    #authorUrl: 作者主页\n    #version: 版本\n    basePackage: com.kimzing\n  # 分布式调度系统配置\n  xxljob:\n    enabled: true\n    # 调度中心部署跟地址 [选填]：如调度中心集群部署存在多个地址则用逗号分隔。\n    # 执行器将会使用该地址进行\"执行器心跳注册\"和\"任务结果回调\"；为空则关闭自动注册；\n    adminAddresses: http://localhost:8092/xxljob\n    # 执行器通讯TOKEN [选填]：非空时启用；\n    accessToken: \n    executor:\n      # 执行器AppName [选填]：执行器心跳注册分组依据；为空则关闭自动注册\n      appname: ${spring.application.name}\n      # 执行器注册 [选填]：优先使用该配置作为注册地址，为空时使用内嵌服务 ”IP:PORT“ 作为注册地址。\n      address:\n      # 执行器IP [选填]：默认为空表示自动获取IP，多网卡时可手动设置指定IP，该IP不会绑定Host仅作为通讯实用；\n      # 地址信息用于 \"执行器注册\" 和 \"调度中心请求并触发任务\"；\n      ip:\n      # 执行器端口号 [选填]：小于等于0则自动获取；默认端口为9999，单机部署多个执行器时，注意要配置不同执行器端口；\n      port: 0\n      # 执行器运行日志文件存储磁盘路径 [选填] ：需要对该路径拥有读写权限；为空则使用默认路径；\n      logpath: ${user.home}/logs/xxljob/${spring.application.name}\n      # 执行器日志文件保存天数 [选填] ： 过期日志自动清理, 限制值大于等于3时生效; 否则, 如-1, 关闭自动清理功能；\n      logretentiondays: 30\n  # mybatis-plus配置\n  mybatis-plus:\n    page:\n      # 当存在mybatisPlus依赖时，是否开启分页(默认true)\n      enabled: true\n      # 分页join数量查询优化\n      optimizeJoin: true\n    performance:\n      # 当存在mybatisPlus依赖时，是否开启sql分析(默认true)\n      enabled: false\n      # 是否格式化输出SQL\n      formate: false\n      # 排查慢SQL的限制时间\n      maxTime: 1000\n  # 加载指定配置文件到Spring的Environment\n  property:\n    files: [\"classpath:exception.properties\"]', '6ca0c4cc4e1975439d791b9d4af2895d', '2020-11-04 11:36:00', '2020-11-07 08:29:21', NULL, '80.251.209.156', '', 'dev', '', '', '', 'yaml', '');
INSERT INTO `config_info` VALUES (10, 'infra-notice.yaml', 'DEFAULT_GROUP', 'server:\n  port: 8001\n\nspring: \n  # 配置发送提醒的邮箱\n  mail:\n    host: smtp.163.com\n    username: kimnotice@163.com\n    password: Kim123456\n    default-encoding: utf-8\n    port: 465\n    properties:\n      mail:\n        smtp:\n          auth: true\n          ssl:\n            enable: true', 'b6f2653f93ea8d956792e8f1a48eaa60', '2020-11-04 11:36:00', '2020-11-04 11:36:00', NULL, '173.242.120.158', '', 'dev', NULL, NULL, NULL, 'yaml', NULL);
INSERT INTO `config_info` VALUES (11, 'infra-storage.yaml', 'DEFAULT_GROUP', 'server:\n  port: 8003\n    \nspring:\n  datasource:\n    url: jdbc:mysql://mysql.kimzing.com:3306/springcloud-storage?characterEncoding=utf8&connectTimeout=1000&socketTimeout=3000&autoReconnect=true&useUnicode=true&useSSL=false&serverTimezone=UTC&allowMultiQueries=true&queryInterceptors=brave.mysql8.TracingQueryInterceptor&exceptionInterceptors=brave.mysql8.TracingExceptionInterceptor&zipkinServiceName=mysql-${spring.application.name}\n    username: root\n    password: 123456\n\nkimzing:\n  web:\n    result:\n      enabled: false\n  minio:\n    # 是否启用minio配置(默认false)\n    enabled: true\n    # minio服务地址\n    url: http://oss.kimzing.com:9000\n    accessKey: admin\n    secretKey: 1234567890\n    # 统一对象前缀\n    prefix: \n    # 前缀类型\n    prefixType: time\n    # 前缀时间的格式\n    timePattern: yyyyMMddHHmmss-', 'e80b39ece1c063c0fa2c43a820ded765', '2020-11-04 11:36:00', '2020-11-07 07:59:56', NULL, '80.251.209.156', '', 'dev', '', '', '', 'yaml', '');
INSERT INTO `config_info` VALUES (12, 'infra-search.yaml', 'DEFAULT_GROUP', 'server:\n  port: 8002\n    \ndubbo:\n  cloud:\n    # 服务消费方订阅服务提供方的应用名称的列表\n    # 若需订阅多应用，使用 \",\" 分割\n    subscribed-services: infra-search\n  scan:\n    # dubbo 服务扫描基础包路径\n    base-packages: com.kimzing.search.service', 'b3ef27ebf0e2193bd721779fd9db091a', '2020-11-04 11:36:00', '2020-11-04 11:36:00', NULL, '173.242.120.158', '', 'dev', NULL, NULL, NULL, 'yaml', NULL);
INSERT INTO `config_info` VALUES (13, 'service-product.yaml', 'DEFAULT_GROUP', 'server:\n  port: 8082\n    \nspring:\n  datasource:\n    # 添加&allowMultiQueries=true使得一个接口可以执行多条语句\n    url: jdbc:mysql://mysql.kimzing.com:3306/springcloud-product?characterEncoding=utf8&connectTimeout=1000&socketTimeout=3000&autoReconnect=true&useUnicode=true&useSSL=false&serverTimezone=UTC&allowMultiQueries=true&queryInterceptors=brave.mysql8.TracingQueryInterceptor&exceptionInterceptors=brave.mysql8.TracingExceptionInterceptor&zipkinServiceName=mysql-${spring.application.name}\n    username: root\n    password: 123456\n\ndubbo:\n  cloud:\n    # 服务消费方订阅服务提供方的应用名称的列表\n    # 若需订阅多应用，使用 \",\" 分割\n    subscribed-services: \"\"\n  scan:\n    # dubbo 服务扫描基础包路径\n    base-packages: com.kimzing.product.service\n\nseata:\n  service:\n    vgroup-mapping:\n      service-product-group: default', '460eb0f446f2dcd348d005ae51984203', '2020-11-04 11:36:00', '2020-11-07 08:26:42', NULL, '80.251.209.156', '', 'dev', '', '', '', 'yaml', '');
INSERT INTO `config_info` VALUES (39, 'entry-admin-rule', 'DEFAULT_GROUP', '[\n    {\n        \"resource\": \"/user\",\n        \"limitApp\": \"default\",\n        \"grade\": 1,\n        \"count\": 2,\n        \"strategy\": 0,\n        \"controlBehavior\": 0,\n        \"clusterMode\": false\n    }\n]', '799b4b33efcd51c88ea3a64222b8661a', '2020-11-07 06:44:03', '2020-11-07 06:44:03', NULL, '64.64.251.52', '', 'dev', NULL, NULL, NULL, 'json', NULL);
INSERT INTO `config_info` VALUES (46, 'entry-app-rule', 'DEFAULT_GROUP', '[\n    {\n        \"resource\": \"/user/{id}\",\n        \"limitApp\": \"default\",\n        \"grade\": 1,\n        \"count\": 4,\n        \"strategy\": 0,\n        \"controlBehavior\": 0,\n        \"clusterMode\": false\n    }\n]', '9cd93ea1054d45520059789448adacf8', '2020-11-07 08:25:37', '2020-11-07 08:25:37', NULL, '80.251.209.156', '', 'dev', NULL, NULL, NULL, 'json', NULL);
COMMIT;

-- ----------------------------
-- Table structure for config_info_aggr
-- ----------------------------
DROP TABLE IF EXISTS `config_info_aggr`;
CREATE TABLE `config_info_aggr` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `data_id` varchar(255) COLLATE utf8_bin NOT NULL COMMENT 'data_id',
  `group_id` varchar(255) COLLATE utf8_bin NOT NULL COMMENT 'group_id',
  `datum_id` varchar(255) COLLATE utf8_bin NOT NULL COMMENT 'datum_id',
  `content` longtext COLLATE utf8_bin NOT NULL COMMENT '内容',
  `gmt_modified` datetime NOT NULL COMMENT '修改时间',
  `app_name` varchar(128) COLLATE utf8_bin DEFAULT NULL,
  `tenant_id` varchar(128) COLLATE utf8_bin DEFAULT '' COMMENT '租户字段',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_configinfoaggr_datagrouptenantdatum` (`data_id`,`group_id`,`tenant_id`,`datum_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='增加租户字段';

-- ----------------------------
-- Records of config_info_aggr
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for config_info_beta
-- ----------------------------
DROP TABLE IF EXISTS `config_info_beta`;
CREATE TABLE `config_info_beta` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `data_id` varchar(255) COLLATE utf8_bin NOT NULL COMMENT 'data_id',
  `group_id` varchar(128) COLLATE utf8_bin NOT NULL COMMENT 'group_id',
  `app_name` varchar(128) COLLATE utf8_bin DEFAULT NULL COMMENT 'app_name',
  `content` longtext COLLATE utf8_bin NOT NULL COMMENT 'content',
  `beta_ips` varchar(1024) COLLATE utf8_bin DEFAULT NULL COMMENT 'betaIps',
  `md5` varchar(32) COLLATE utf8_bin DEFAULT NULL COMMENT 'md5',
  `gmt_create` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
  `src_user` text COLLATE utf8_bin COMMENT 'source user',
  `src_ip` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT 'source ip',
  `tenant_id` varchar(128) COLLATE utf8_bin DEFAULT '' COMMENT '租户字段',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_configinfobeta_datagrouptenant` (`data_id`,`group_id`,`tenant_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='config_info_beta';

-- ----------------------------
-- Records of config_info_beta
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for config_info_tag
-- ----------------------------
DROP TABLE IF EXISTS `config_info_tag`;
CREATE TABLE `config_info_tag` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `data_id` varchar(255) COLLATE utf8_bin NOT NULL COMMENT 'data_id',
  `group_id` varchar(128) COLLATE utf8_bin NOT NULL COMMENT 'group_id',
  `tenant_id` varchar(128) COLLATE utf8_bin DEFAULT '' COMMENT 'tenant_id',
  `tag_id` varchar(128) COLLATE utf8_bin NOT NULL COMMENT 'tag_id',
  `app_name` varchar(128) COLLATE utf8_bin DEFAULT NULL COMMENT 'app_name',
  `content` longtext COLLATE utf8_bin NOT NULL COMMENT 'content',
  `md5` varchar(32) COLLATE utf8_bin DEFAULT NULL COMMENT 'md5',
  `gmt_create` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
  `src_user` text COLLATE utf8_bin COMMENT 'source user',
  `src_ip` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT 'source ip',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_configinfotag_datagrouptenanttag` (`data_id`,`group_id`,`tenant_id`,`tag_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='config_info_tag';

-- ----------------------------
-- Records of config_info_tag
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for config_tags_relation
-- ----------------------------
DROP TABLE IF EXISTS `config_tags_relation`;
CREATE TABLE `config_tags_relation` (
  `id` bigint(20) NOT NULL COMMENT 'id',
  `tag_name` varchar(128) COLLATE utf8_bin NOT NULL COMMENT 'tag_name',
  `tag_type` varchar(64) COLLATE utf8_bin DEFAULT NULL COMMENT 'tag_type',
  `data_id` varchar(255) COLLATE utf8_bin NOT NULL COMMENT 'data_id',
  `group_id` varchar(128) COLLATE utf8_bin NOT NULL COMMENT 'group_id',
  `tenant_id` varchar(128) COLLATE utf8_bin DEFAULT '' COMMENT 'tenant_id',
  `nid` bigint(20) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`nid`),
  UNIQUE KEY `uk_configtagrelation_configidtag` (`id`,`tag_name`,`tag_type`),
  KEY `idx_tenant_id` (`tenant_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='config_tag_relation';

-- ----------------------------
-- Records of config_tags_relation
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for group_capacity
-- ----------------------------
DROP TABLE IF EXISTS `group_capacity`;
CREATE TABLE `group_capacity` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `group_id` varchar(128) COLLATE utf8_bin NOT NULL DEFAULT '' COMMENT 'Group ID，空字符表示整个集群',
  `quota` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '配额，0表示使用默认值',
  `usage` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '使用量',
  `max_size` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '单个配置大小上限，单位为字节，0表示使用默认值',
  `max_aggr_count` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '聚合子配置最大个数，，0表示使用默认值',
  `max_aggr_size` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '单个聚合数据的子配置大小上限，单位为字节，0表示使用默认值',
  `max_history_count` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '最大变更历史数量',
  `gmt_create` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_group_id` (`group_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='集群、各Group容量信息表';

-- ----------------------------
-- Records of group_capacity
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for his_config_info
-- ----------------------------
DROP TABLE IF EXISTS `his_config_info`;
CREATE TABLE `his_config_info` (
  `id` bigint(64) unsigned NOT NULL,
  `nid` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `data_id` varchar(255) COLLATE utf8_bin NOT NULL,
  `group_id` varchar(128) COLLATE utf8_bin NOT NULL,
  `app_name` varchar(128) COLLATE utf8_bin DEFAULT NULL COMMENT 'app_name',
  `content` longtext COLLATE utf8_bin NOT NULL,
  `md5` varchar(32) COLLATE utf8_bin DEFAULT NULL,
  `gmt_create` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `gmt_modified` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `src_user` text COLLATE utf8_bin,
  `src_ip` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `op_type` char(10) COLLATE utf8_bin DEFAULT NULL,
  `tenant_id` varchar(128) COLLATE utf8_bin DEFAULT '' COMMENT '租户字段',
  PRIMARY KEY (`nid`),
  KEY `idx_gmt_create` (`gmt_create`),
  KEY `idx_gmt_modified` (`gmt_modified`),
  KEY `idx_did` (`data_id`)
) ENGINE=InnoDB AUTO_INCREMENT=59 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='多租户改造';

-- ----------------------------
-- Records of his_config_info
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for permissions
-- ----------------------------
DROP TABLE IF EXISTS `permissions`;
CREATE TABLE `permissions` (
  `role` varchar(50) NOT NULL,
  `resource` varchar(255) NOT NULL,
  `action` varchar(8) NOT NULL,
  UNIQUE KEY `uk_role_permission` (`role`,`resource`,`action`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of permissions
-- ----------------------------
BEGIN;
INSERT INTO `permissions` VALUES ('ROLE_DEV', 'dev:*:*', 'rw');
COMMIT;

-- ----------------------------
-- Table structure for roles
-- ----------------------------
DROP TABLE IF EXISTS `roles`;
CREATE TABLE `roles` (
  `username` varchar(50) NOT NULL,
  `role` varchar(50) NOT NULL,
  UNIQUE KEY `idx_user_role` (`username`,`role`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of roles
-- ----------------------------
BEGIN;
INSERT INTO `roles` VALUES ('dev', 'ROLE_DEV');
INSERT INTO `roles` VALUES ('nacos', 'ROLE_ADMIN');
COMMIT;

-- ----------------------------
-- Table structure for tenant_capacity
-- ----------------------------
DROP TABLE IF EXISTS `tenant_capacity`;
CREATE TABLE `tenant_capacity` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `tenant_id` varchar(128) COLLATE utf8_bin NOT NULL DEFAULT '' COMMENT 'Tenant ID',
  `quota` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '配额，0表示使用默认值',
  `usage` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '使用量',
  `max_size` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '单个配置大小上限，单位为字节，0表示使用默认值',
  `max_aggr_count` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '聚合子配置最大个数',
  `max_aggr_size` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '单个聚合数据的子配置大小上限，单位为字节，0表示使用默认值',
  `max_history_count` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '最大变更历史数量',
  `gmt_create` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_tenant_id` (`tenant_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='租户容量信息表';

-- ----------------------------
-- Records of tenant_capacity
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for tenant_info
-- ----------------------------
DROP TABLE IF EXISTS `tenant_info`;
CREATE TABLE `tenant_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `kp` varchar(128) COLLATE utf8_bin NOT NULL COMMENT 'kp',
  `tenant_id` varchar(128) COLLATE utf8_bin DEFAULT '' COMMENT 'tenant_id',
  `tenant_name` varchar(128) COLLATE utf8_bin DEFAULT '' COMMENT 'tenant_name',
  `tenant_desc` varchar(256) COLLATE utf8_bin DEFAULT NULL COMMENT 'tenant_desc',
  `create_source` varchar(32) COLLATE utf8_bin DEFAULT NULL COMMENT 'create_source',
  `gmt_create` bigint(20) NOT NULL COMMENT '创建时间',
  `gmt_modified` bigint(20) NOT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_tenant_info_kptenantid` (`kp`,`tenant_id`),
  KEY `idx_tenant_id` (`tenant_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='tenant_info';

-- ----------------------------
-- Records of tenant_info
-- ----------------------------
BEGIN;
INSERT INTO `tenant_info` VALUES (1, '1', 'dev', '开发', '开发环境', 'nacos', 1604473125676, 1604489695811);
INSERT INTO `tenant_info` VALUES (2, '1', 'sit', '测试', '测试环境', 'nacos', 1604489714017, 1604489714017);
INSERT INTO `tenant_info` VALUES (3, '1', 'uat', '验收', '验收环境', 'nacos', 1604489729712, 1604489729712);
INSERT INTO `tenant_info` VALUES (4, '1', 'pro', '生产', '生产环境', 'nacos', 1604489745100, 1604489745100);
COMMIT;

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `username` varchar(50) NOT NULL,
  `password` varchar(500) NOT NULL,
  `enabled` tinyint(1) NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of users
-- ----------------------------
BEGIN;
INSERT INTO `users` VALUES ('dev', '$2a$10$6ZOU67sA9OyZEWscn2HmL.e3BNr635AeGFYpINDIo.sjQHw8TV.8e', 1);
INSERT INTO `users` VALUES ('nacos', '$2a$10$EuWPZHzz32dJN7jexM34MOeYirDdFAZm2kuWj7VEOJhhZkDrxfvUu', 1);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
