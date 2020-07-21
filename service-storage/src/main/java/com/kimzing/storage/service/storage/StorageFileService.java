package com.kimzing.storage.service.storage;

import com.kimzing.storage.domain.storage.StorageFileBO;
import com.kimzing.storage.domain.storage.StorageFileQueryDTO;
import com.kimzing.storage.domain.storage.StorageFileSaveDTO;
import com.kimzing.storage.domain.storage.StorageFileUpdateDTO;
import com.kimzing.utils.page.PageParam;
import com.kimzing.utils.page.PageResult;

import javax.validation.constraints.NotNull;

/**
 * 文件存储信息 服务接口
 *
 * @author KimZing
 * @since 2020-07-20
 */
public interface StorageFileService {

    /**
     * 保存文件存储信息
     */
    StorageFileBO save(StorageFileSaveDTO storageFileSaveDTO);

    /**
     * 移除文件存储信息
     */
    void remove(@NotNull(message = "STORAGE_FILE_1001") Integer id);

    /**
     * 更新文件存储信息
     */
    void update(StorageFileUpdateDTO storageFileUpdateDTO);

    /**
     * 查询单个文件存储信息
     */
    StorageFileBO get(@NotNull(message = "STORAGE_FILE_1001") Integer id);

    /**
     * 分页条件查询文件存储信息
     */
    PageResult<StorageFileBO> listPage(StorageFileQueryDTO storageFileQueryDTO, PageParam pageParam);
}
