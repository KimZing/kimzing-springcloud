```bash
docker run --privileged --rm --name minio -p 9000:9000 -e "MINIO_ACCESS_KEY=admin" -e "MINIO_SECRET_KEY=1234567890"  -v /Volumes/KimData/Docker/Minio/Data:/data -d registry.cn-hangzhou.aliyuncs.com/kimzing/minio:0719 server /data;
```