# Mysql安装


```bash
docker run -d --rm --name mysql -p 3306:3306 -v //d/Docker/Mysql/Data:/var/lib/mysql -e TZ="Asia/Shanghai" -e MYSQL_ROOT_PASSWORD=123456 -d mysql:5.7 --character-set-server=utf8mb4 --collation-server=utf8mb4_unicode_ci;
```
