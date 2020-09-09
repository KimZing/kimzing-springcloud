# Nacos安装

```bash
docker run -d --rm --name nacos -p 8848:8848 --link mysql:mysql -v //d/Docker/Nacos:/home/nacos/conf -e TZ="Asia/Shanghai" -e MODE=standalone  nacos/nacos-server:1.3.2;
```