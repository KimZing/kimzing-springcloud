```bash
# bladex/sentinel-dashboard
docker run --privileged --rm --name sentinel -p 8858:8858 -v /Volumes/KimData/Docker/Sentinel/Conf/application.properties:/bladex/sentinel/application.properties -d registry.cn-hangzhou.aliyuncs.com/kimzing/sentinel:1.7.2
```