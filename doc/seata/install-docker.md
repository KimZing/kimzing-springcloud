# Seata安装

```bash
docker run -d --rm --name seata -p 8091:8091 --link nacos:nacos --link mysql:mysql -v //d/Docker/Seata/Conf:/root/seata-config \
-e TZ="Asia/Shanghai" -e SEATA_IP=192.168.1.106 -e SEATA_PORT=8091 -e SEATA_CONFIG_NAME=file:/root/seata-config/registry seataio/seata-server:1.3.0;
```