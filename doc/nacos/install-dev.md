# Nacos安装文档(Linux/Mac)

## 一、下载

首先[下载](https://github.com/alibaba/nacos/releases)最新的Nacos版本，`tar.gz`和`zip`格式的都可以。
截止当前最新版本为`1.3.2`，下载`nacos-server-1.3.2.zip`

## 二、解压

将下载的压缩包进行解压`unzip nacos-server-1.3.2.zip`，bin目录是linux和windows下的启动脚本，本文将其解压到了桌面

## 三、配置使用外部Mysql数据库进行数据持久化

> 这里就不介绍Mysql的安装启动了

### 1. 创建Nacos数据库并创建表结构

首先创建`springcloud-nacos`库(根据自己需要进行命名)，打开nacos解压目录`conf`文件夹，执行`nacos-mysql.sql`中的sql创建相应的表结构

### 2. 配置Nacos

打开nacos解压目录`conf`文件夹，编辑`application.properties`文件，文件中对mysql的配置进行了注释，我们打开注释并修改如下:

> 其中`db.url.0`根据自己的mysql地址和数据库名进行修改，同时也需要修改用户名和密码

```properties
#*************** Config Module Related Configurations ***************#
### If use MySQL as datasource:
spring.datasource.platform=mysql

### Count of DB:
db.num=1

### Connect URL of DB:
db.url.0=jdbc:mysql://127.0.0.1:3306/springcloud-nacos?characterEncoding=utf8&connectTimeout=1000&socketTimeout=3000&autoReconnect=true&useUnicode=true&useSSL=false&serverTimezone=UTC
db.user=root
db.password=123456
```

### 3. 启动

**首先进入nacos的安装目录**

`sh bin/startup.sh -m standalone`

运行命令成功时，会有如下提示

```bash
nacos is starting with standalone
# nacos的日志输出文件
nacos is starting，you can check the /Users/kimzing/Desktop/nacos/logs/start.out
```

使用`tail -f logs/start.out`查看nacos日志，当输出如下内容时，即为启动成功

```bash
2020-08-25 14:35:46,229 INFO Tomcat started on port(s): 8848 (http) with context path '/nacos'
2020-08-25 14:35:46,234 INFO Nacos Log files: /Users/kimzing/Desktop/nacos/logs
2020-08-25 14:35:46,237 INFO Nacos Log files: /Users/kimzing/Desktop/nacos/conf
2020-08-25 14:35:46,237 INFO Nacos Log files: /Users/kimzing/Desktop/nacos/data
2020-08-25 14:35:46,237 INFO Nacos started successfully in stand alone mode. use embedded storage
```

此时访问`http://localhost:8848/nacos`即可看到nacos的管理界面，账号/密码: nacos/nacos

### 4. 停止

**首先进入nacos的安装目录**

执行以下命令

`sh bin/shutdown.sh`

控制台输出

```bash
The nacosServer(60211) is running...
Send shutdown request to nacosServer(60211) OK
```

### 5. Tips

每次都去执行这些命令进行启动和关闭有些麻烦，可以写个脚本，双击一下即可启动、停止，方便省事，示例脚本如下(放在nacos目录同级)

```bash
# 启动脚本
BASE_DIR=`cd $(dirname $0); pwd`
sh ${BASE_DIR}/nacos/bin/startup.sh -m standalone

# 停止脚本
BASE_DIR=`cd $(dirname $0); pwd`
sh ${BASE_DIR}/nacos/bin/shutdown.sh
```

### 6. 开启安全认证(TODO 等待官方cloud版本更新)

默认情况下，安全认证是关闭的，服务在注册和发现时，是无需提供用户名密码的，而生产环境或其他场景下，需要进行服务验证，可通过在配置文件中做如下配置开启验证

```properties
nacos.core.auth.enabled=true
```

nacos的安装基本就到这里了，使用愉快！