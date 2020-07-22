# tool-template

模板项目

## 项目用途

以此项目为模板快速创建其他项目

## 演示功能

## 创建步骤

1. 复制该项目并重新命名项目，例如service-*, infra-*
2. 在setting.gradle中添加新建的项目模块并刷新gradle
3. 修改build.gradle,根据项目功能需求去除不需要的配置项，并填写description项目描述
4. 重命名包名称，使用shift+f6, 选择rename diractory，输入对应名称即可。注意测试包名同样步骤修改
  - 如果是dubbo项目，删除controller与domain包
5. 重命名启动类，将启动类和测试类命名为需要的名称
6. 如果不需要mysql存储，需删除resources/db与resources/mapper目录
  - 需要mysql存储，需要将`V1593952348__create_user.sql`进行重命名，`V${时间戳/秒}__${动作}_${表名}.sql`, 并修改sql，修改说明已经在sql文件内以注释形式说明
7. 修改bootstrap.yaml文件中的服务名称
8. 在nacos中添加对应的配置文件,在对应环境分组下新建dataId为${spring.application.name}.yaml的配置，
   参考resources/nacos.yaml文件进行修改删除不需要的配置，`添加完成后删除resources/nacos.yaml文件`
9. 最后修改本文件的标题和描述，并删除`创建步骤`小节。
10. 接下来就可以使用代码生成器生成对应的功能代码，copy进对应目录即可


> 如果需要支持分布式事物，需要在nacos的seata分组中进行添加配置