package com.kimzing.app.controller.upload;

import com.kimzing.log.LogIgnore;
import com.kimzing.minio.MinioObjectInfo;
import com.kimzing.minio.MinioService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

/**
 * .
 *
 * @author KimZing - kimzing@163.com
 * @since 2020/7/19 22:05
 */
@Slf4j
@Api(tags = "文件上传")
@RestController
@RequestMapping("/upload")
public class UploadController {

    @Resource
    MinioService minioService;

    @ApiOperation(value = "上传任意类型文件")
    @PostMapping(value = "/file")
    public MinioObjectInfo uplaod(@LogIgnore @RequestParam("file") MultipartFile file) throws Exception {
        return minioService.upload(file);
    }

}
