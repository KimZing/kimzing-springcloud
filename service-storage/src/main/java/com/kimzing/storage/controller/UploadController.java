package com.kimzing.storage.controller;

import com.kimzing.log.LogIgnore;
import com.kimzing.minio.MinioObjectInfo;
import com.kimzing.minio.MinioService;
import com.kimzing.storage.client.UploadResponse;
import com.kimzing.utils.bean.BeanUtil;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

/**
 * 上传文件.
 *
 * @author KimZing - kimzing@163.com
 * @since 2020/7/20 13:17
 */
@RestController
@RequestMapping("/storage")
public class UploadController {

    @Resource
    MinioService minioService;

    @PostMapping(value = "/upload")
    public UploadResponse upload(@LogIgnore @RequestParam("file") MultipartFile file) {
        MinioObjectInfo minioObjectInfo = minioService.upload(file);
        UploadResponse uploadResponse = BeanUtil.mapperBean(minioObjectInfo, UploadResponse.class);
        return uploadResponse;
    }
}
