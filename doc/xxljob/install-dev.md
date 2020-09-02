```bash
docker run --privileged --rm --name xxljob -p 8092:8080  -v /Volumes/KimData/Docker/XXLJob/Conf/application.properties:/application.properties -d registry.cn-hangzhou.aliyuncs.com/kimzing/xxljob-admin:2.2.0
```