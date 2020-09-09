# Minio安装

```bash
docker run -d --rm --name minio -p 9000:9000 -v //d/Docker/Minio/Data:/data  -e TZ="Asia/Shanghai" -e "MINIO_ACCESS_KEY=admin" -e "MINIO_SECRET_KEY=1234567890"  minio/minio:RELEASE.2020-09-08T23-05-18Z server /data;
```