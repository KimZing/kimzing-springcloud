package com.kimzing.storage.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

/**
 * 文件上传客户端.
 *
 * @author KimZing - kimzing@163.com
 * @since 2020/7/20 13:19
 */
@FeignClient("service-storage")
public interface UploadFeignClient {

    @PostMapping(value = "/storage/upload",consumes = MediaType.MULTIPART_FORM_DATA_VALUE )
    UploadResponse upload(@RequestPart("file") MultipartFile file);

}
