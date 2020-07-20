package com.kimzing.storage.domain.storage;

import com.kimzing.utils.po.AbstractBO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 文件存储信息业务对象
 *
 * @author KimZing
 * @since 2020-07-20
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
@ApiModel(value="文件存储信息业务对象", description="文件存储信息")
public class StorageFileBO extends AbstractBO implements Serializable {

    private static final long serialVersionUID = 1L;


    @ApiModelProperty(value = "文件名")
    private String name;

    @ApiModelProperty(value = "文件类型")
    private String contentType;

    @ApiModelProperty(value = "文件url")
    private String url;

    @ApiModelProperty(value = "存储桶")
    private String bucket;

}
