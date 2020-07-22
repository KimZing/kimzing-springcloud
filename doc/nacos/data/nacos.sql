/*
 Navicat Premium Data Transfer

 Source Server         : Aliyun
 Source Server Type    : MySQL
 Source Server Version : 50724
 Source Host           : mysql.kimzing.com:3306
 Source Schema         : nacos

 Target Server Type    : MySQL
 Target Server Version : 50724
 File Encoding         : 65001

 Date: 23/07/2020 01:19:52
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
) ENGINE=InnoDB AUTO_INCREMENT=329 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='config_info';

-- ----------------------------
-- Records of config_info
-- ----------------------------
BEGIN;
INSERT INTO `config_info` VALUES (42, 'server-admin.yaml', 'DEFAULT_GROUP', 'server:\n  port: 7001\n  \nspring:\n  boot:\n    admin:\n      discovery:    \n        ignored-services: seata-server\n      notify:\n        mail:\n          # 配置邮件通知开关\n          enabled: false\n          # 告警发件人\n          from: ${spring.mail.username}\n          # 告警收件人\n          to: kimzing@163.com\n  # 配置发送告警的邮箱\n  mail:\n    host: smtp.163.com\n    username: kimnotice@163.com\n    password: Kim123456\n    default-encoding: utf-8\n    port: 465\n    properties:\n      mail:\n        smtp:\n          auth: true\n          ssl:\n            enable: true', 'c4805ab137065e7110d736c57c6cc716', '2020-06-30 12:53:23', '2020-07-21 16:56:41', NULL, '112.80.234.142', '', 'dev', '', '', '', 'yaml', '');
INSERT INTO `config_info` VALUES (58, 'entry-admin.yaml', 'DEFAULT_GROUP', 'server:\n  port: 9001\n  servlet:\n    context-path: /admin\ndubbo:\n  cloud:\n    # 服务消费方订阅服务提供方的应用名称的列表\n    # 若需订阅多应用，使用 \",\" 分割\n    subscribed-services: service-user,service-order,service-product\n  scan:\n    # dubbo 服务扫描基础包路径\n    base-packages: com.kimzing.admin', '31424614d45c3296f22f21c12e2cfcfa', '2020-07-01 17:06:18', '2020-07-23 01:12:24', NULL, '112.80.234.142', '', 'dev', '', '', '', 'yaml', '');
INSERT INTO `config_info` VALUES (60, 'entry-app.yaml', 'DEFAULT_GROUP', 'server:\n  port: 9002\n  servlet:\n    context-path: /app\n\ndubbo:\n  cloud:\n    # 服务消费方订阅服务提供方的应用名称的列表\n    # 若需订阅多应用，使用 \",\" 分割\n    subscribed-services: service-user,service-order,service-product\n  scan:\n    # dubbo 服务扫描基础包路径\n    base-packages: com.kimzing.app', '10df0b42cdcea563601e21e8d22c0dcd', '2020-07-01 17:09:34', '2020-07-23 01:12:13', NULL, '112.80.234.142', '', 'dev', '', '', '', 'yaml', '');
INSERT INTO `config_info` VALUES (71, 'gateway.yaml', 'DEFAULT_GROUP', 'server:\n  port: 8080\n  \nspring:\n  cloud:\n    gateway:\n      globalcors:\n        corsConfigurations:\n          \'[/**]\':\n            allowedOrigins: \"*\"\n            allowedMethods: \"*\"\n            allowedHeaders: \"*\"\n      discovery:\n          locator:\n            enabled: true\n            lower-case-service-id: true', '1aa64c4867090063b638c480b5fc0b22', '2020-07-01 18:56:37', '2020-07-22 12:52:28', NULL, '112.80.234.142', '', 'dev', '', '', '', 'yaml', '');
INSERT INTO `config_info` VALUES (77, 'service-user.yaml', 'DEFAULT_GROUP', 'server:\n  port: 8083\n    \nspring:\n  # 对应 RedisProperties 类\n  redis:\n    host: redis.kimzing.com\n    port: 6379\n    # Redis 服务器密码，默认为空。生产中，一定要设置 Redis 密码！\n    #password:\n    # Redis 数据库号，默认为 0\n    database: 0\n    # Redis 连接超时时间，单位：毫秒\n    timeout: 1000\n  datasource:\n    driver-class-name: com.mysql.cj.jdbc.Driver\n    # 添加&allowMultiQueries=true使得一个接口可以执行多条语句\n    url: jdbc:mysql://mysql.kimzing.com:3306/springcloud-user?setUnicode=true&characterEncoding=utf8&allowMultiQueries=true&queryInterceptors=brave.mysql8.TracingQueryInterceptor&exceptionInterceptors=brave.mysql8.TracingExceptionInterceptor&zipkinServiceName=mysql-${spring.application.name}\n    username: root\n    password: 123456\n\ndubbo:\n  cloud:\n    # 服务消费方订阅服务提供方的应用名称的列表\n    # 若需订阅多应用，使用 \",\" 分割\n    subscribed-services: service-order\n  scan:\n    # dubbo 服务扫描基础包路径\n    base-packages: com.kimzing.user.service\n    \n# 百度地图配置(模拟)\nbaidu:\n  map:\n    url: https://baidu.com/map', '7367e2ddc19dbcd178f884f4af579887', '2020-07-04 18:09:24', '2020-07-22 22:49:12', NULL, '112.80.234.142', '', 'dev', '', '', '', 'yaml', '');
INSERT INTO `config_info` VALUES (97, 'service-order.yaml', 'DEFAULT_GROUP', 'server:\n  port: 8081\n\nspring:\n  datasource:\n    driver-class-name: com.mysql.cj.jdbc.Driver\n    # 添加&allowMultiQueries=true使得一个接口可以执行多条语句\n    url: jdbc:mysql://mysql.kimzing.com:3306/springcloud-order?setUnicode=true&characterEncoding=utf8&allowMultiQueries=true&queryInterceptors=brave.mysql8.TracingQueryInterceptor&exceptionInterceptors=brave.mysql8.TracingExceptionInterceptor&zipkinServiceName=mysql-${spring.application.name}\n    username: root\n    password: 123456\n\ndubbo:\n  cloud:\n    # 服务消费方订阅服务提供方的应用名称的列表\n    # 若需订阅多应用，使用 \",\" 分割\n    subscribed-services: service-user\n  scan:\n    # dubbo 服务扫描基础包路径\n    base-packages: com.kimzing.order\n\n# 百度地图配置(模拟)\nbaidu:\n  map:\n    url: https://baidu.com/map', '3baf148f88fb181e0d70d83aa4e69e7a', '2020-07-05 23:33:37', '2020-07-22 22:48:39', NULL, '112.80.234.142', '', 'dev', '', '', '', 'yaml', '');
INSERT INTO `config_info` VALUES (100, 'entry-third.yaml', 'DEFAULT_GROUP', 'server:\n  port: 9003\n  servlet:\n    context-path: /third\n\ndubbo:\n  cloud:\n    # 服务消费方订阅服务提供方的应用名称的列表\n    # 若需订阅多应用，使用 \",\" 分割\n    subscribed-services: service-user,service-order,service-product\n  scan:\n    # dubbo 服务扫描基础包路径\n    base-packages: com.kimzing.third', '70e012b39d7134f4965edaeec7021c6c', '2020-07-06 01:52:03', '2020-07-23 01:12:35', NULL, '112.80.234.142', '', 'dev', '', '', '', 'yaml', '');
INSERT INTO `config_info` VALUES (102, 'common.yaml', 'DEFAULT_GROUP', '# ===============Spring配置=================\nspring:\n  servlet:\n    multipart:\n      # 单个上传文件大小\n      max-file-size: 50MB\n      # 请求允许的总大小\n      max-request-size: 50MB\n  cloud:\n    # Sentinel 配置项，对应 SentinelProperties 配置属性类\n    sentinel:\n      # 是否开启。默认为 true 开启\n      enabled: true\n      # 是否饥饿加载。默认为 false 关闭\n      eager: true\n      transport:\n        # Sentinel 控制台地址\n        dashboard: sentinel.kimzing.com:8858\n      filter:\n        # 拦截请求的地址。默认为 /*\n        url-patterns: /**\n      # Sentinel 规则的数据源，是一个 Map 类型。key 为数据源名，可自定义；value 为数据源的具体配置\n      datasource:\n        ds1:\n          # 对应 DataSourcePropertiesConfiguration 类\n          nacos:\n            # Nacos 服务器地址\n            server-addr: ${nacos-server-addr:nacos.kimzing.com:8848}\n            namespace: dev\n            # Nacos 分组\n            group-id: DEFAULT_GROUP\n            # Nacos 配置集编号\n            data-id: ${spring.application.name}-rule.json\n            # 数据格式\n            data-type: json\n            # 规则类型\n            rule-type: FLOW\n  zipkin:\n    # Zipkin 服务的地址\n    base-url: http://zipkin.kimzing.com:9411\n  sleuth:\n    # 针对 Web 组件的配置项\n    web:\n      # 是否开启，默认为 true\n      enabled: true\n    # 针对 Feign 组件的配置项\n    feign:\n      # 是否开启，默认为 true\n      enabled: true\n    # 针对 Slf4j 组件的配置项\n    log:\n      slf4j:\n        # 是否开启，默认为 true\n        enabled: true\n    # 针对抽样收集的配置项，两个配置项都设置的情况下，采用 ProbabilityBasedSampler 采样器\n    sampler:\n      # 采样百分比，默认为空\n      probability: 1\n      # 限流采样，即每秒可收集链路的数量，默认为 10\n      rate: 10\n  # 设置flyway不校验丢失的文件, 因为每个服务都使用独立的数据源，所以可以关闭该选项\n  #flyway:\n    #ignore-missing-migrations: true\n# ===============Actuator管理端口=================\nmanagement:\n  endpoints:\n    web:\n      exposure:\n        include: \'*\'\n  endpoint:\n    health:\n      show-details: always\n# ===============RocketMQ公共配置==============\n# 对应 RocketMQProperties 配置类\nrocketmq:\n  # RocketMQ Namesrv\n  name-server: rocketmq.kimzing.com:9876\n  # Producer 配置项\n  producer:\n    group: ${spring.application.name}-group\n    # 发送消息超时时间，单位：毫秒。默认为 3000 。\n    send-message-timeout: 3000\n    # 消息压缩阀值，当消息体的大小超过该阀值后，进行消息压缩。默认为 4 * 1024B\n    compress-message-body-threshold: 4096\n    # 消息体的最大允许大小。。默认为 4 * 1024 * 1024B\n    max-message-size: 4194304\n    # 同步发送消息时，失败重试次数。默认为 2 次。\n    retry-times-when-send-failed: 2\n    # 异步发送消息时，失败重试次数。默认为 2 次。\n    retry-times-when-send-async-failed: 2\n    # 发送消息给 Broker 时，如果发送失败，是否重试另外一台 Broker 。默认为 false\n    retry-next-server: true\n    # 是否开启消息轨迹功能。默认为 true 开启。\n    enable-msg-trace: true\n    # 自定义消息轨迹的 Topic 。默认为 RMQ_SYS_TRACE_TOPIC 。\n    customized-trace-topic: RMQ_SYS_TRACE_TOPIC\n  # Consumer 配置项\n  consumer:\n    # 配置某个消费分组，是否监听指定 Topic 。结构为 Map<消费者分组, <Topic, Boolean>> 。默认情况下，不配置表示监听。\n    listeners:\n      test-group:\n        # 关闭 test-consumer-group 对 topic1 的监听消费\n        test: false\n# ===============分布式事物Seata公共配置==============\nseata:\n  enabled: true\n  application-id: ${spring.application.name}\n  tx-service-group: ${spring.application.name}-group\n  enable-auto-data-source-proxy: true\n  config:\n    type: nacos\n    nacos:\n      serverAddr: ${nacos-server-addr:nacos.kimzing.com:8848}\n      # 因为配置比较杂乱，统一放在seata命名空间\n      namespace: seata\n      group: SEATA_GROUP\n      username: ${nacos-username:dev}\n      password: ${nacos-password:123456}\n  registry:\n    type: nacos\n    nacos:\n      application: seata-server\n      server-addr: ${nacos-server-addr:nacos.kimzing.com:8848}\n      namespace: ${spring.profiles.active}\n      username: ${nacos-username:dev}\n      password: ${nacos-password:123456}\n# ===============Dubbo公共配置=================\ndubbo:\n  consumer:\n    # 开启消费端参数校验\n    validation: true\n    # 关闭提供者检查\n    check: false\n    # 链路跟踪\n    filter: tracing\n  provider:\n    validation: true\n    filter: -exception,exceptionFilter,-validation,validationFilter,tracing\n    exception:\n      package: com.kimzing.\n  # 挂载到 Spring Cloud 注册中心\n  registry:\n    address: spring-cloud://localhost\n  # Dubbo 服务暴露的协议配置\n  protocol:\n    id: dubbo\n    # 协议名称\n    name: dubbo\n    # 协议端口（ -1 表示自增端口，从 20880 开始）\n    port: -1\n\n# ===============knife4j公共配置=================\n# knife开源的swagger ui配置\nknife4j:\n  # 是否是生产环境，如果是生产环境会默认关闭swagger\n  production: false\n  # 配置自定义markdown文件的位置\n  markdowns: classpath:markdown/*\n  # 配置认证功能\n  basic:\n    # 是否开启认证\n    enable: true\n    # 用户名\n    username: admin\n    # 密码\n    password: 123456\n\n# ===============mybatis公共配置=================\nmybatis-plus:\n  configuration:\n    log-impl: org.apache.ibatis.logging.stdout.StdOutImpl\n    # 下划线转驼峰\n    map-underscore-to-camel-case: true\n# ===============自定义Starter功能配置=================\n# 基本属性配置\nkimzing:\n  sentinel:\n    enabled: true\n    exceptionHandler:\n      # 异常拦截开关\n      enabled: true\n      # 提示码\n      code: SECURITY\n      # 提示信息\n      message: 请求已被安全管控系统拦截，请联系管理员:kimzing@163.com\n  redis:\n    enabled: true\n    prefix: ${spring.application.name}\n    time-pattern: \"yyyy-MM-dd HH:mm:ss\"\n  log:\n    # 方法日志开关(默认false)\n    enabled: true\n    # 日志中的时间戳格式(可选)\n    time-pattern: yyyy-MM-dd HH:mm:ss:SSS\n  web:\n    resolver:\n      # 是否开启Get请求方法解析(默认true)\n      json:\n        enabled: true\n    # 结果统一封装\n    result:\n      enabled: true\n      package: com.kimzing\n    advice:\n      # 是否启用异常拦截(默认false)\n      enabled: true\n    log:\n      # 是否启用请求日志打印(默认true)\n      enabled: true\n    cors:\n      # 是否开启跨域支持(默认true)\n      enabled: true\n      origins:\n        - \"*\"\n    restTemplate:\n      # 是否自动配置RestTemplate(默认true)\n      enabled: true\n    info:\n      # 是否启用/info接口(默认false)\n      enabled: true\n      # 接口路径\n      path: /\n      params:\n        application: ${spring.application.name}\n        port: ${server.port}\n        profile: ${spring.profiles.active}\n        version: ${spring.application.version}\n        description: ${spring.application.description}\n  # swagger配置\n  swagger:\n    # 当存在swagger依赖时，是否开启(默认true)\n    enabled: true\n    title: ${spring.application.name}-聚合服务\n    description: 聚合或代理内部接口对外提供服务\n    #termsOfServiceUrl: 项目服务地址\n    #authorName: 作者\n    #authorEmail: 作者邮箱\n    #authorUrl: 作者主页\n    #version: 版本\n    basePackage: com.kimzing\n  # 分布式调度系统配置\n  xxljob:\n    enabled: true\n    # 调度中心部署跟地址 [选填]：如调度中心集群部署存在多个地址则用逗号分隔。\n    # 执行器将会使用该地址进行\"执行器心跳注册\"和\"任务结果回调\"；为空则关闭自动注册；\n    adminAddresses: http://xxljob.kimzing.com:8092/xxl-job-admin\n    # 执行器通讯TOKEN [选填]：非空时启用；\n    accessToken: \n    executor:\n      # 执行器AppName [选填]：执行器心跳注册分组依据；为空则关闭自动注册\n      appname: ${spring.application.name}\n      # 执行器注册 [选填]：优先使用该配置作为注册地址，为空时使用内嵌服务 ”IP:PORT“ 作为注册地址。\n      address:\n      # 执行器IP [选填]：默认为空表示自动获取IP，多网卡时可手动设置指定IP，该IP不会绑定Host仅作为通讯实用；\n      # 地址信息用于 \"执行器注册\" 和 \"调度中心请求并触发任务\"；\n      ip:\n      # 执行器端口号 [选填]：小于等于0则自动获取；默认端口为9999，单机部署多个执行器时，注意要配置不同执行器端口；\n      port: 0\n      # 执行器运行日志文件存储磁盘路径 [选填] ：需要对该路径拥有读写权限；为空则使用默认路径；\n      logpath: ${user.home}/logs/xxljob/${spring.application.name}\n      # 执行器日志文件保存天数 [选填] ： 过期日志自动清理, 限制值大于等于3时生效; 否则, 如-1, 关闭自动清理功能；\n      logretentiondays: 30\n  # mybatis-plus配置\n  mybatis-plus:\n    page:\n      # 当存在mybatisPlus依赖时，是否开启分页(默认true)\n      enabled: true\n      # 分页join数量查询优化\n      optimizeJoin: true\n    performance:\n      # 当存在mybatisPlus依赖时，是否开启sql分析(默认true)\n      enabled: false\n      # 是否格式化输出SQL\n      formate: false\n      # 排查慢SQL的限制时间\n      maxTime: 1000\n  # 加载指定配置文件到Spring的Environment\n  property:\n    files: [\"classpath:exception.properties\"]', '560c312440d5fa5449b294c5e26e8fd0', '2020-07-06 01:59:16', '2020-07-22 11:03:48', NULL, '112.80.234.142', '', 'dev', '所有服务公用配置，如有个性化配置需在独立服务做配置', '', '', 'yaml', '');
INSERT INTO `config_info` VALUES (165, 'service.vgroupMapping.entry-app-group', 'SEATA_GROUP', 'default', 'c21f969b5f03d33d43e04f8f136e7682', '2020-07-14 21:42:36', '2020-07-14 21:42:36', NULL, '122.96.121.243', '', 'seata', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `config_info` VALUES (166, 'store.mode', 'SEATA_GROUP', 'db', 'd77d5e503ad1439f585ac494268b351b', '2020-07-14 21:42:36', '2020-07-14 21:42:36', NULL, '122.96.121.243', '', 'seata', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `config_info` VALUES (167, 'store.db.datasource', 'SEATA_GROUP', 'druid', '3d650fb8a5df01600281d48c47c9fa60', '2020-07-14 21:42:36', '2020-07-14 21:42:36', NULL, '122.96.121.243', '', 'seata', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `config_info` VALUES (168, 'store.db.dbType', 'SEATA_GROUP', 'mysql', '81c3b080dad537de7e10e0987a4bf52e', '2020-07-14 21:42:36', '2020-07-14 21:42:36', NULL, '122.96.121.243', '', 'seata', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `config_info` VALUES (169, 'store.db.driverClassName', 'SEATA_GROUP', 'com.mysql.jdbc.Driver', '683cf0c3a5a56cec94dfac94ca16d760', '2020-07-14 21:42:36', '2020-07-14 21:42:36', NULL, '122.96.121.243', '', 'seata', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `config_info` VALUES (170, 'store.db.url', 'SEATA_GROUP', 'jdbc:mysql://mysql.kimzing.com:3306/seata?useUnicode=true', '59d6e36c9ddd8e6eeba557f25ed71131', '2020-07-14 21:42:37', '2020-07-14 21:42:37', NULL, '122.96.121.243', '', 'seata', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `config_info` VALUES (171, 'store.db.user', 'SEATA_GROUP', 'root', '63a9f0ea7bb98050796b649e85481845', '2020-07-14 21:42:37', '2020-07-14 21:42:37', NULL, '122.96.121.243', '', 'seata', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `config_info` VALUES (172, 'store.db.password', 'SEATA_GROUP', '123456', 'e10adc3949ba59abbe56e057f20f883e', '2020-07-14 21:42:37', '2020-07-14 21:42:37', NULL, '122.96.121.243', '', 'seata', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `config_info` VALUES (173, 'store.db.minConn', 'SEATA_GROUP', '5', 'e4da3b7fbbce2345d7772b0674a318d5', '2020-07-14 21:42:37', '2020-07-14 21:42:37', NULL, '122.96.121.243', '', 'seata', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `config_info` VALUES (174, 'store.db.maxConn', 'SEATA_GROUP', '30', '34173cb38f07f89ddbebc2ac9128303f', '2020-07-14 21:42:37', '2020-07-14 21:42:37', NULL, '122.96.121.243', '', 'seata', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `config_info` VALUES (175, 'store.db.globalTable', 'SEATA_GROUP', 'global_table', '8b28fb6bb4c4f984df2709381f8eba2b', '2020-07-14 21:42:37', '2020-07-14 21:42:37', NULL, '122.96.121.243', '', 'seata', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `config_info` VALUES (176, 'store.db.branchTable', 'SEATA_GROUP', 'branch_table', '54bcdac38cf62e103fe115bcf46a660c', '2020-07-14 21:42:37', '2020-07-14 21:42:37', NULL, '122.96.121.243', '', 'seata', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `config_info` VALUES (177, 'store.db.queryLimit', 'SEATA_GROUP', '100', 'f899139df5e1059396431415e770c6dd', '2020-07-14 21:42:37', '2020-07-14 21:42:37', NULL, '122.96.121.243', '', 'seata', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `config_info` VALUES (178, 'store.db.lockTable', 'SEATA_GROUP', 'lock_table', '55e0cae3b6dc6696b768db90098b8f2f', '2020-07-14 21:42:37', '2020-07-14 21:42:37', NULL, '122.96.121.243', '', 'seata', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `config_info` VALUES (179, 'store.db.maxWait', 'SEATA_GROUP', '5000', 'a35fe7f7fe8217b4369a0af4244d1fca', '2020-07-14 21:42:37', '2020-07-14 21:42:37', NULL, '122.96.121.243', '', 'seata', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `config_info` VALUES (181, 'service.vgroupMapping.service-user-group', 'SEATA_GROUP', 'default', 'c21f969b5f03d33d43e04f8f136e7682', '2020-07-14 21:57:38', '2020-07-14 21:57:38', NULL, '122.96.121.243', '', 'seata', NULL, NULL, NULL, 'text', NULL);
INSERT INTO `config_info` VALUES (182, 'service.vgroupMapping.service-order-group', 'SEATA_GROUP', 'default', 'c21f969b5f03d33d43e04f8f136e7682', '2020-07-14 21:58:05', '2020-07-14 21:58:05', NULL, '122.96.121.243', '', 'seata', NULL, NULL, NULL, 'text', NULL);
INSERT INTO `config_info` VALUES (196, 'service.vgroupMapping.entry-admin-group', 'SEATA_GROUP', 'default', 'c21f969b5f03d33d43e04f8f136e7682', '2020-07-15 00:31:16', '2020-07-15 00:31:16', NULL, '122.96.121.243', '', 'seata', NULL, NULL, NULL, 'text', NULL);
INSERT INTO `config_info` VALUES (197, 'service.vgroupMapping.entry-third-group', 'SEATA_GROUP', 'default', 'c21f969b5f03d33d43e04f8f136e7682', '2020-07-15 00:31:34', '2020-07-15 00:31:34', NULL, '122.96.121.243', '', 'seata', NULL, NULL, NULL, 'text', NULL);
INSERT INTO `config_info` VALUES (247, 'entry-app-rule.json', 'DEFAULT_GROUP', '[\n    {\n        \"resource\": \"/user/{id}\",\n        \"limitApp\": \"default\",\n        \"grade\": 1,\n        \"count\": 2,\n        \"strategy\": 0,\n        \"controlBehavior\": 0,\n        \"clusterMode\": false\n    }\n]', '5a1c6315df17d537e5c917d856a39e59', '2020-07-19 19:41:59', '2020-07-19 20:08:44', NULL, '112.80.234.142', '', 'dev', 'app入口限流策略', '', '', 'json', '');
INSERT INTO `config_info` VALUES (309, 'infra-notice.yaml', 'DEFAULT_GROUP', 'server:\n  port: 8001\n\nspring: \n  # 配置发送提醒的邮箱\n  mail:\n    host: smtp.163.com\n    username: kimnotice@163.com\n    password: Kim123456\n    default-encoding: utf-8\n    port: 465\n    properties:\n      mail:\n        smtp:\n          auth: true\n          ssl:\n            enable: true', 'b6f2653f93ea8d956792e8f1a48eaa60', '2020-07-22 11:38:54', '2020-07-22 22:47:56', NULL, '112.80.234.142', '', 'dev', '', '', '', 'yaml', '');
INSERT INTO `config_info` VALUES (310, 'infra-storage.yaml', 'DEFAULT_GROUP', 'server:\n  port: 8003\n    \nspring:\n  datasource:\n    driver-class-name: com.mysql.cj.jdbc.Driver\n    # 添加&allowMultiQueries=true使得一个接口可以执行多条语句\n    url: jdbc:mysql://mysql.kimzing.com:3306/springcloud-storage?setUnicode=true&characterEncoding=utf8&allowMultiQueries=true&queryInterceptors=brave.mysql8.TracingQueryInterceptor&exceptionInterceptors=brave.mysql8.TracingExceptionInterceptor&zipkinServiceName=mysql-${spring.application.name}\n    username: root\n    password: 123456\n\nkimzing:\n  web:\n    result:\n      enabled: false\n  minio:\n    # 是否启用minio配置(默认false)\n    enabled: true\n    # minio服务地址\n    url: http://minio.kimzing.com:9000\n    accessKey: admin\n    secretKey: 1234567890\n    # 统一对象前缀\n    prefix: \n    # 前缀类型\n    prefixType: time\n    # 前缀时间的格式\n    timePattern: yyyyMMddHHmmss-', '847b367878c4fbbc8c16f8f33305492d', '2020-07-22 11:39:15', '2020-07-22 22:48:22', NULL, '112.80.234.142', '', 'dev', '', '', '', 'yaml', '');
INSERT INTO `config_info` VALUES (314, 'infra-search.yaml', 'DEFAULT_GROUP', 'server:\n  port: 8002\n    \ndubbo:\n  cloud:\n    # 服务消费方订阅服务提供方的应用名称的列表\n    # 若需订阅多应用，使用 \",\" 分割\n    subscribed-services: infra-search\n  scan:\n    # dubbo 服务扫描基础包路径\n    base-packages: com.kimzing.search.service', 'b3ef27ebf0e2193bd721779fd9db091a', '2020-07-22 20:54:17', '2020-07-22 22:48:09', NULL, '112.80.234.142', '', 'dev', '', '', '', 'yaml', '');
INSERT INTO `config_info` VALUES (317, 'service-product.yaml', 'DEFAULT_GROUP', 'server:\n  port: 8082\n    \nspring:\n  datasource:\n    driver-class-name: com.mysql.cj.jdbc.Driver\n    # 添加&allowMultiQueries=true使得一个接口可以执行多条语句\n    url: jdbc:mysql://mysql.kimzing.com:3306/springcloud-product?setUnicode=true&characterEncoding=utf8&allowMultiQueries=true&queryInterceptors=brave.mysql8.TracingQueryInterceptor&exceptionInterceptors=brave.mysql8.TracingExceptionInterceptor&zipkinServiceName=mysql-${spring.application.name}\n    username: root\n    password: 123456\n\ndubbo:\n  cloud:\n    # 服务消费方订阅服务提供方的应用名称的列表\n    # 若需订阅多应用，使用 \",\" 分割\n    subscribed-services: service-product\n  scan:\n    # dubbo 服务扫描基础包路径\n    base-packages: com.kimzing.product.service', '1f11261649bec5af492db40938ab5d33', '2020-07-22 22:28:46', '2020-07-22 22:48:56', NULL, '112.80.234.142', '', 'dev', '', '', '', 'yaml', '');
INSERT INTO `config_info` VALUES (319, 'service.vgroupMapping.service-product-group', 'SEATA_GROUP', 'default', 'c21f969b5f03d33d43e04f8f136e7682', '2020-07-22 22:30:36', '2020-07-22 22:30:36', NULL, '112.80.234.142', '', 'seata', NULL, NULL, NULL, 'text', NULL);
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
) ENGINE=InnoDB AUTO_INCREMENT=414 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='多租户改造';

-- ----------------------------
-- Table structure for permissions
-- ----------------------------
DROP TABLE IF EXISTS `permissions`;
CREATE TABLE `permissions` (
  `role` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `resource` varchar(512) COLLATE utf8mb4_unicode_ci NOT NULL,
  `action` varchar(8) COLLATE utf8mb4_unicode_ci NOT NULL,
  UNIQUE KEY `uk_role_permission` (`role`,`resource`,`action`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Records of permissions
-- ----------------------------
BEGIN;
INSERT INTO `permissions` VALUES ('dev', 'dev:*:*', 'rw');
INSERT INTO `permissions` VALUES ('sit', 'sit:*:*', 'rw');
COMMIT;

-- ----------------------------
-- Table structure for roles
-- ----------------------------
DROP TABLE IF EXISTS `roles`;
CREATE TABLE `roles` (
  `username` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `role` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  UNIQUE KEY `idx_user_role` (`username`,`role`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Records of roles
-- ----------------------------
BEGIN;
INSERT INTO `roles` VALUES ('dev', 'dev');
INSERT INTO `roles` VALUES ('nacos', 'ROLE_ADMIN');
INSERT INTO `roles` VALUES ('sit', 'sit');
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
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='tenant_info';

-- ----------------------------
-- Records of tenant_info
-- ----------------------------
BEGIN;
INSERT INTO `tenant_info` VALUES (7, '1', 'dev', '开发环境', '开发环境', 'nacos', 1593452671812, 1593452820964);
INSERT INTO `tenant_info` VALUES (8, '1', 'sit', '测试环境', '测试环境', 'nacos', 1593452721010, 1593452829856);
INSERT INTO `tenant_info` VALUES (9, '1', 'uat', '验收环境', '验收环境', 'nacos', 1593452744034, 1593452839074);
INSERT INTO `tenant_info` VALUES (10, '1', 'pro', '生产环境', '生产环境', 'nacos', 1593452760416, 1593452846288);
INSERT INTO `tenant_info` VALUES (11, '1', 'seata', 'seata', '分布式事物', 'nacos', 1594734057002, 1594734057002);
COMMIT;

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `username` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `password` varchar(500) COLLATE utf8mb4_unicode_ci NOT NULL,
  `enabled` tinyint(1) NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Records of users
-- ----------------------------
BEGIN;
INSERT INTO `users` VALUES ('dev', '$2a$10$e9Rui19dP01oqGDpSWqjVOClyxrnpZ9DO22xgNgqpyDNA.BgiuNzW', 1);
INSERT INTO `users` VALUES ('nacos', '$2a$10$0cMyVbD/Eae2O1ES8VAcC.jURDwOTKg0RxeLV2pAMC0tkvKrNg2xW', 1);
INSERT INTO `users` VALUES ('sit', '$2a$10$MehSCmgv3yeTooFxE7paOuaNQvcxZveXceMX7yOoaM4mll78cPAs6', 1);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
