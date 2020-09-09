package com.kimzing.storage.publisher;

import com.kimzing.storage.domain.storage.StorageFileCreateEvent;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 文件上传相关信息发布.
 *
 * @author KimZing - kimzing@163.com
 * @since 2020/7/11 17:22
 */
@Component
public class StoragePublisher {

    @Resource
    ApplicationContext applicationContext;

    /**
     * 用户创建消息,演示异步消息发布
     */
    public void publishStorageFileCreateEvent(StorageFileCreateEvent storageFileCreateEvent) {
        applicationContext.publishEvent(storageFileCreateEvent);
    }

}
