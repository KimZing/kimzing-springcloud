package com.kimzing.storage.domain.storage;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 用户创建消息.
 *
 * @author KimZing - kimzing@163.com
 * @since 2020/7/11 17:24
 */
@Data
@Accessors(chain = true)
public class StorageFileCreateEvent {

    /**
     * 主题
     */
    public static final String TOPIC = "storage-file-create";

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
