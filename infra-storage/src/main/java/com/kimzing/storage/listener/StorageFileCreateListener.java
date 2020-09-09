package com.kimzing.storage.listener;

import com.kimzing.storage.domain.storage.StorageFileCreateEvent;
import com.kimzing.storage.domain.storage.StorageFileSaveDTO;
import com.kimzing.storage.service.storage.StorageFileService;
import com.kimzing.utils.bean.BeanUtil;
import com.kimzing.utils.log.LogUtil;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * .
 *
 * @author KimZing - kimzing@163.com
 * @since 2020/7/11 23:26
 */
@Component
public class StorageFileCreateListener {

    @Resource
    StorageFileService storageFileService;

    @EventListener
    public void onMessage(StorageFileCreateEvent message) {
        LogUtil.info("保存上传文件信息:[{}]", message);

        StorageFileSaveDTO storageFileSaveDTO = BeanUtil.mapperBean(message, StorageFileSaveDTO.class);
        storageFileService.save(storageFileSaveDTO);
    }

}
