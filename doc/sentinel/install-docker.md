# Sentinel安装

```bash
docker run -d --rm --name sentinel -p 8858:8858 -v //d/Docker/Sentinel/Conf/application.properties:/bladex/sentinel/application.properties -e TZ="Asia/Shanghai" bladex/sentinel-dashboard:1.8.0;
```