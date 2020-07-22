package com.kimzing.storage.service.storage.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.kimzing.storage.domain.storage.StorageFileBO;
import com.kimzing.storage.domain.storage.StorageFileQueryDTO;
import com.kimzing.storage.domain.storage.StorageFileSaveDTO;
import com.kimzing.storage.domain.storage.StorageFileUpdateDTO;
import com.kimzing.storage.repository.storage.StorageFileMapper;
import com.kimzing.storage.repository.storage.StorageFilePO;
import com.kimzing.storage.service.storage.StorageFileService;
import com.kimzing.utils.bean.BeanUtil;
import com.kimzing.utils.page.PageParam;
import com.kimzing.utils.page.PageResult;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

import static com.kimzing.utils.page.MPPageUtil.convertPage;
import static com.kimzing.utils.page.MPPageUtil.convertPageResult;

/**
 * 文件存储信息 服务实现类
 *
 * @author KimZing
 * @since 2020-07-20
 */
@Service
public class StorageFileServiceImpl implements StorageFileService {

    @Resource
    StorageFileMapper storageFileMapper;

    /**
     * 保存文件存储信息
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public StorageFileBO save(StorageFileSaveDTO storageFileSaveDTO) {
        StorageFilePO storageFilePO = BeanUtil.mapperBean(storageFileSaveDTO, StorageFilePO.class);
        storageFileMapper.insert(storageFilePO);
        return BeanUtil.mapperBean(storageFilePO, StorageFileBO.class);
    }

    /**
     * 移除文件存储信息
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void remove(Integer id) {
        storageFileMapper.delete(id);
    }

    /**
     * 更新文件存储信息
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(StorageFileUpdateDTO storageFileUpdateDTO) {
        StorageFilePO storageFilePO = BeanUtil.mapperBean(storageFileUpdateDTO, StorageFilePO.class);
        storageFileMapper.update(storageFilePO);
    }

    /**
     * 查询单个文件存储信息
     */
    @Override
    @Transactional(readOnly = true)
    public StorageFileBO get(Integer id) {
        return storageFileMapper.selectById(id);
    }

    /**
     * 分页条件查询文件存储信息
     */
    @Override
    @Transactional(readOnly = true)
    public PageResult<StorageFileBO> listPage(StorageFileQueryDTO storageFileQueryDTO, PageParam pageParam) {
        IPage<StorageFileBO> storageFileBOPage = storageFileMapper.selectPage(convertPage(pageParam), storageFileQueryDTO);
        return convertPageResult(storageFileBOPage);
    }

}
