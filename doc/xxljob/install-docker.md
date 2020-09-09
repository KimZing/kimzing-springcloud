# xxljob安装

```bash
docker run -d --rm --name xxljob -p 8092:8080  --link mysql:mysql -v //d/Docker/XXLJob/Conf/application.properties:/application.properties -e TZ="Asia/Shanghai" xuxueli/xxl-job-admin:2.2.0;
```