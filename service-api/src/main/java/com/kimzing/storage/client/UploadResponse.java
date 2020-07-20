package com.kimzing.storage.client;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 文件上传响应信息.
 *
 * @author KimZing - kimzing@163.com
 * @since 2020/7/20 13:22
 */
@Data
@Accessors(chain = true)
public class UploadResponse {

    /**
     * 存储桶名称
     */
    private String bucket;

    /**
     * 存储路径
     */
    private String path;

    /**
     * 保存的文件名
     */
    private String name;

    /**
     * 数据类型
     */
    private String contentType;

    /**
     * 下载浏览url
     */
    private String url;

}
