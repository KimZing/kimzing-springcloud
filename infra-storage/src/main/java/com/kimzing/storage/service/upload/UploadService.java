package com.kimzing.storage.service.upload;

import com.kimzing.storage.client.UploadResponse;

import java.io.InputStream;

/**
 * 文件上传.
 *
 * @author KimZing - kimzing@163.com
 * @since 2020/7/20 22:50
 */
public interface UploadService {

    UploadResponse upload(String bucket, String path, String filename, String contentType, InputStream inputStream);

}
