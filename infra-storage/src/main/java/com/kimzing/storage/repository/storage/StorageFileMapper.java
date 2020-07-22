package com.kimzing.storage.repository.storage;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.kimzing.storage.domain.storage.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * 文件存储信息 Mapper 接口
 *
 * @author KimZing
 * @since 2020-07-20
 */
@Mapper
public interface StorageFileMapper {

    /**
     * 保存文件存储信息
     */
    Integer insert(StorageFilePO storageFilePO);

    /**
     * 批量保存文件存储信息
     */
    void insertBatch(List<StorageFilePO> list);

    /**
     * 删除文件存储信息
     */
    void delete(Integer id);

    /**
     * 根据ID更新文件存储信息
     */
    void update(StorageFilePO storageFilePO);

    /**
     * 根据ID查询文件存储信息
     */
    StorageFileBO selectById(Integer id);

    /**
     * 条件分页查询文件存储信息
     */
    IPage<StorageFileBO> selectPage(Page<StorageFileBO> page, @Param("query") StorageFileQueryDTO storageFileQueryDTO);

}
