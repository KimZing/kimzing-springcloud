package com.kimzing.storage.controller;

import com.kimzing.log.LogIgnore;
import com.kimzing.storage.client.UploadResponse;
import com.kimzing.storage.service.upload.UploadService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.ByteArrayInputStream;
import java.io.IOException;

/**
 * 上传文件.
 *
 * @author KimZing - kimzing@163.com
 * @since 2020/7/20 13:17
 */
@Api(tags = "上传文件")
@RestController
@RequestMapping("/storage")
public class UploadController {

    @Resource(name = "minioUploadServiceImpl")
    UploadService uploadService;


    @ApiOperation(value = "通过multipartFile上传文件，使用内置的文件名和类型",
            notes = "生成规则为 ${bucket}/${path}/${prefix}filename, "
                    + "bucket不能为空，通常使用功能指定bucket名称，例如使用user-header存储所有头像。"
                    + "path可以为空，通常用以区分不同的类别，如使用vip标识vip用户头像，normal标识普通用户头像，注意前后不要加斜杠/。"
                    + "prefix为存储服务默认规则，默认使用'yyyyMMddHHmmss-'作为前缀。"
                    + "文件名使用MultipartFile中的文件名，例如zhangsan.jpg。"
                    + "contentType使用MultipartFile中的文件类型。"
                    + "最终生成的文件路径为user-header/vip/20200721121023-zhangsan.jpg")
    @PostMapping(value = "/upload/default")
    public UploadResponse upload(@RequestParam("bucket") String bucket, @RequestParam(value = "path", required = false) String path,
                                 @LogIgnore @RequestParam("file") MultipartFile file) throws IOException {
        return uploadService.upload(bucket, path, file.getOriginalFilename(), file.getContentType(), file.getInputStream());
    }

    @ApiOperation(value = "通过multipartFile上传文件，提供自定义的文件名和类型",
            notes = "生成规则为 ${bucket}/${path}/${prefix}filename, "
                    + "bucket不能为空，通常使用功能指定bucket名称，例如使用user-header存储所有头像。"
                    + "path可以为空，通常用以区分不同的类别，如使用vip标识vip用户头像，normal标识普通用户头像，注意前后不要加斜杠/。"
                    + "prefix为存储服务默认规则，默认使用'yyyyMMddHHmmss-'作为前缀。"
                    + "filename不能为空，作为文件名，例如zhangsan.jpg。"
                    + "contentType不能为空，文件类型，可以借助spring的MediaType进行确认。"
                    + "最终生成的文件路径为user-header/vip/20200721121023-zhangsan.jpg")
    @PostMapping(value = "/upload/diy")
    public UploadResponse upload(@RequestParam("bucket") String bucket, @RequestParam(value = "path", required = false) String path,
                                 @RequestParam("filename") String filename, @RequestParam("contentType") String contentType,
                                 @LogIgnore @RequestParam("file") MultipartFile file) throws IOException {
        return uploadService.upload(bucket, path, filename, contentType, file.getInputStream());
    }

    @ApiOperation(value = "通过原始字节数组上传文件，提供自定义的文件名和类型",
            notes = "生成规则为 ${bucket}/${path}/${prefix}filename, "
                    + "bucket不能为空，通常使用功能指定bucket名称，例如使用user-header存储所有头像。"
                    + "path可以为空，通常用以区分不同的类别，如使用vip标识vip用户头像，normal标识普通用户头像，注意前后不要加斜杠/。"
                    + "prefix为存储服务默认规则，默认使用'yyyyMMddHHmmss-'作为前缀。"
                    + "filename不能为空，作为文件名，例如zhangsan.jpg。"
                    + "contentType不能为空，文件类型，可以借助spring的MediaType进行确认。"
                    + "最终生成的文件路径为user-header/vip/20200721121023-zhangsan.jpg")
    @PostMapping(value = "/upload/byte")
    public UploadResponse upload(@RequestParam("bucket") String bucket, @RequestParam(value = "path", required = false) String path,
                                 @RequestParam("filename") String filename, @RequestParam("contentType") String contentType,
                                 @LogIgnore @RequestBody byte[] bytes) {
        return uploadService.upload(bucket, path, filename, contentType, new ByteArrayInputStream(bytes));
    }

}
