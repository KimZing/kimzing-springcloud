package com.kimzing.storage.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

/**
 * 文件上传客户端.
 *
 * @author KimZing - kimzing@163.com
 * @since 2020/7/20 13:19
 */
@FeignClient("infra-storage")
public interface UploadFeignClient {

    @PostMapping(value = "/storage/upload/default", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    UploadResponse upload(@RequestParam("bucket") String bucket, @RequestParam(value = "path", required = false) String path,
                                 @RequestPart("file") MultipartFile file);

    @PostMapping(value = "/storage/upload/diy", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    UploadResponse upload(@RequestParam("bucket") String bucket, @RequestParam(value = "path", required = false) String path,
                          @RequestParam("filename") String filename, @RequestParam("contentType") String contentType,
                          @RequestPart("file") MultipartFile file);

    @PostMapping(value = "/storage/upload/byte")
    UploadResponse upload(@RequestParam("bucket") String bucket, @RequestParam(value = "path", required = false) String path,
                          @RequestParam("filename") String filename, @RequestParam("contentType") String contentType,
                          @RequestBody byte[] bytes);

}
