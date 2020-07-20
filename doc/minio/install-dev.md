用docker安装minio

docker pull minio/minio
docker run -p 9000:9000 --name minio \
-d --restart=always \
-e "MINIO_ACCESS_KEY=xxxx" \
-e "MINIO_SECRET_KEY=xxxx" \
-v /home/data:/data \
-v /home/config:/root/.minio \
minio/minio server /data


安装minio client

稳定版
docker pull minio/mc
docker run minio/mc ls play
1
2
注意: 上述示例默认使用MinIO演示环境做演示，如果想用mc操作其它S3兼容的服务，采用下面的方式来启动容器：

docker run -it --entrypoint=/bin/sh minio/mc


mc config host add minio http://192.168.1.51 admin 1234567890 --api s3v4

mc policy set public minio/photoes
mc policy set download minio/photoes