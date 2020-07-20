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

    private String name;

    private String contentType;

    private String url;

    private String bucket;

}
