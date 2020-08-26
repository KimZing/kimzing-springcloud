# Seata安装文档

## 一、下载

首先[下载](https://github.com/seata/seata/releases)最新的Seata版本，`tar.gz`和`zip`格式的都可以。
截止当前最新版本为`1.3.0`，下载`seata-server-1.3.0.zip`

## 二、解压

将下载的压缩包进行解压`unzip seata-server-1.3.0.zip`，bin目录是linux和windows下的启动脚本，本文将其解压到了桌面

## 三、配置使用Nacos作为注册中心

修改`conf`目录下的`registry.conf`文件，将registry节点下的type修改为nacos，同时修改对应的nacos配置，示例如下：

```
registry {
  type = "nacos"
  nacos {
    application = "seata-server"
    serverAddr = "127.0.0.1:8848"
    group = "SEATA_GROUP"
    namespace = "dev"
    cluster = "default"
    username = "dev"
    password = "123456"
  }
}
```

## 四、使用Nacos作为配置中心

修改`conf`目录下的`registry.conf`文件，将config节点下的type修改为nacos，同时修改对应的nacos配置，示例如下：

> 这里指定了namespace,所以需要预先在nacos中建立seata命名空间

```
config {
  type = "nacos"
  nacos {
    serverAddr = "localhost:8848"
    namespace = "seata"
    group = "SEATA_GROUP"
    username = "dev"
    password = "123456"
  }
}
```

## 五、配置使用MySQL存储事物信息

### 1. 建立mysql表结构

首先需要建立对应的数据库实例`springcloud-seata`(名字自己起)，当然用已有的也是可以的。然后在对应库中建立对应的服务端表结构。

[服务端脚本](https://github.com/seata/seata/tree/develop/script/server/db)

> 客户端使用时也需要建立对应的客户端表结构:[客户端脚本查看](https://github.com/seata/seata/blob/develop/script/client/at/db/mysql.sql)

### 在nacos中导入对应的配置

> 使用Nacos作为配置中心后，seata会从nacos中获取对应的配置，所以我们需要在nacos中进行导入配置

首先修改cmd/config.txt文件，将其中的数据库相关配置进行修改，之后修改`cmd/nacos-import.sh`脚本内容，进入脚本目录运行脚本进行导入。参数说明如下

```
-h: host, the default value is localhost.
-p: port, the default value is 8848.
-g: Configure grouping, the default value is 'SEATA_GROUP'.
-t: Tenant information, corresponding to the namespace ID field of Nacos, the default value is ''.
-u: username, nacos 1.2.0+ on permission control, the default value is ''.
-w: password, nacos 1.2.0+ on permission control, the default value is ''.
```

## 五、启动服务

执行以下命令启动服务

```bash
# -p 端口   -n 节点标识，在多个 TC Server 时，需区分各自节点，用于生成不同区间的 transactionId 事务编号，以免冲突。
sh bin/seata-server.sh -p 8091 -n 1
```

启动成功时，输出如下:

```bash
2020-08-26 01:34:58.197  INFO --- [           main] io.seata.config.FileConfiguration        : The configuration file used is registry.conf
2020-08-26 01:34:58.265  INFO --- [           main] io.seata.config.FileConfiguration        : The configuration file used is file.conf
2020-08-26 01:34:58.895  INFO --- [           main] com.alibaba.druid.pool.DruidDataSource   : {dataSource-1} inited
2020-08-26 01:34:59.097  INFO --- [           main] i.s.core.rpc.netty.NettyServerBootstrap  : Server started, listen port: 8091
```

打开nacos控制台，在服务管理的服务列表中可看到该服务已经注册到了nacos


Seata的安装基本就到这里了，使用愉快！

参考资料:[高可用部署](http://seata.io/zh-cn/docs/ops/deploy-ha.html)