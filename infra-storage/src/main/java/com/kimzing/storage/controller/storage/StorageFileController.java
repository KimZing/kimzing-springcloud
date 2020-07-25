package com.kimzing.storage.controller.storage;


import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import com.kimzing.web.resolver.json.JsonParam;
import com.kimzing.utils.page.PageParam;
import com.kimzing.utils.page.PageResult;
import com.kimzing.storage.service.storage.StorageFileService;
import com.kimzing.storage.domain.storage.*;

import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 文件存储信息接口层.
 *
 * @author KimZing
 * @since 2020-07-20
 */
@Api(tags = "文件存储信息")
@RestController
@RequestMapping("/storage")
public class StorageFileController {

    @Resource
    StorageFileService storageFileService;

    @ApiOperation(value = "保存文件存储信息")
    @PostMapping
    public StorageFileBO save(@RequestBody StorageFileSaveDTO storageFileSaveDTO) {
        return storageFileService.save(storageFileSaveDTO);
    }

    @ApiOperation(value = "移除文件存储信息")
    @DeleteMapping("/{id}")
    public void remove(@PathVariable("id") Integer id) {
        storageFileService.remove(id);
    }

    @ApiOperation(value = "更新文件存储信息")
    @PutMapping
    public void update(@RequestBody StorageFileUpdateDTO storageFileUpdateDTO) {
        storageFileService.update(storageFileUpdateDTO);
    }

    @ApiOperation(value = "查询单个文件存储信息")
    @GetMapping("/{id}")
    public StorageFileBO get(@PathVariable("id") Integer id) {
        return storageFileService.get(id);
    }

    @ApiOperation(value = "分页条件查询文件存储信息")
    @GetMapping("/list")
    public PageResult<StorageFileBO> listPage(@JsonParam(required = false) StorageFileQueryDTO storageFileQueryDTO, @ModelAttribute PageParam pageParam) {
        return storageFileService.listPage(storageFileQueryDTO, pageParam);
    }

}
