
```bash
docker run --privileged --rm --name mysql -p 3306:3306 -v /Volumes/KimData/Docker/Mysql/Data:/var/lib/mysql -e MYSQL_ROOT_PASSWORD=123456 -d registry.cn-hangzhou.aliyuncs.com/kimzing/mysql:5.7 --character-set-server=utf8mb4 --collation-server=utf8mb4_unicode_ci;
docker exec mysql cp /usr/share/zoneinfo/Asia/Shanghai /etc/localtime
```
