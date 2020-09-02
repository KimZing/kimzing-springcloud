rocketmq需手动指定自己ip 否则无法获取正确的地址进行连接

```bash
docker run --privileged --rm --name rocketmq-server -p 9876:9876 -e "JAVA_OPT_EXT=-Xms512M -Xmx512M -Xmn128m" -d registry.cn-hangzhou.aliyuncs.com/kimzing/rocketmq:4.7.0 sh mqnamesrv;

docker run --privileged --rm --name rocketmq-broker -p 10911:10911 -p 10912:10912 -p 10909:10909 --link rocketmq-server:rocketmq-server -v /Volumes/KimData/Docker/RocketMQ/Conf:/home/rocketmq/conf -e "NAMESRV_ADDR=rocketmq-server:9876" -e "JAVA_OPT_EXT=-Xms512M -Xmx512M -Xmn128m" -d registry.cn-hangzhou.aliyuncs.com/kimzing/rocketmq:4.7.0 sh mqbroker -c /home/rocketmq/conf/broker.conf;
```
