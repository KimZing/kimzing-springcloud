package com.kimzing.storage.domain.storage;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 文件存储信息更新
 *
 * @author KimZing
 * @since 2020-07-20
 */
@Data
@Accessors(chain = true)
@ApiModel(value="文件存储信息更新", description="文件存储信息")
public class StorageFileUpdateDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "文件存储信息ID")
    private Integer id;

    @ApiModelProperty(value = "文件名")
    private String name;

    @ApiModelProperty(value = "文件类型")
    private String contentType;

    @ApiModelProperty(value = "文件url")
    private String url;

    @ApiModelProperty(value = "存储桶")
    private String bucket;

}
