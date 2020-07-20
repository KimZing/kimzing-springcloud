package com.kimzing.storage.service.upload.impl;

import com.kimzing.minio.MinioObjectInfo;
import com.kimzing.minio.MinioService;
import com.kimzing.storage.client.UploadResponse;
import com.kimzing.storage.domain.storage.StorageFileCreateEvent;
import com.kimzing.storage.publisher.StoragePublisher;
import com.kimzing.storage.service.upload.UploadService;
import com.kimzing.utils.bean.BeanUtil;
import com.kimzing.utils.exception.CustomException;
import com.kimzing.utils.log.LogUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.InputStream;

/**
 * 文件上传实现.
 *
 * @author KimZing - kimzing@163.com
 * @since 2020/7/20 22:51
 */
@Service
public class MinioUploadServiceImpl implements UploadService {

    @Resource
    MinioService minioService;

    @Resource
    StoragePublisher storagePublisher;

    @Override
    public UploadResponse upload(String bucket, String path, String filename, String contentType, InputStream inputStream) {
        createBucketIfNotExistAndSetPolicy(bucket);
        if ("null".equals(path)) {
            path = null;
        }

        MinioObjectInfo minioObjectInfo = minioService.upload(bucket, path, filename, contentType, inputStream);
        UploadResponse uploadResponse = BeanUtil.mapperBean(minioObjectInfo, UploadResponse.class);

        // 发布文件上传事件，以供异步保存上传的文件信息
        storagePublisher.publishStorageFileCreateEvent(BeanUtil.mapperBean(uploadResponse, StorageFileCreateEvent.class));

        return uploadResponse;
    }

    /**
     * 如果bucket不存在则创建，并设置规则为公共读
     * @param bucket
     */
    private void createBucketIfNotExistAndSetPolicy(String bucket) {
        // 每次都去判断会浪费性能，可以通过本地缓存和文件监听来做优化
        minioService.makeBucket(bucket);
        try {
            minioService.setBucketPolicyToReadOnly(bucket);
        } catch (CustomException e) {
            LogUtil.error(e.getMessage());
        }
    }

}
