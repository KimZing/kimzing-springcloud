package com.kimzing.storage.repository.storage;

import com.baomidou.mybatisplus.annotation.TableName;
import com.kimzing.utils.po.AbstractPO;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import java.io.Serializable;

/**
 * 文件存储信息实体
 *
 * @author KimZing
 * @since 2020-07-20
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("storage_file")
public class StorageFilePO extends AbstractPO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 存储桶
     */
    @TableField("bucket")
    private String bucket;

    /**
     * 存储路径
     */
    @TableField("path")
    private String path;

    /**
     * 文件名
     */
    @TableField("name")
    private String name;

    /**
     * 文件类型
     */
    @TableField("content_type")
    private String contentType;

    /**
     * 文件url
     */
    @TableField("url")
    private String url;

}
