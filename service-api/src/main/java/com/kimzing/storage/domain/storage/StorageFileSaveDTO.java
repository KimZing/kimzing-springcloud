package com.kimzing.storage.domain.storage;

import java.time.LocalDateTime;
import java.math.BigDecimal;
import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 文件存储信息保存
 *
 * @author KimZing
 * @since 2020-07-20
 */
@Data
@Accessors(chain = true)
@ApiModel(value="文件存储信息保存", description="文件存储信息")
public class StorageFileSaveDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "文件名")
    private Integer name;

    @ApiModelProperty(value = "文件类型")
    private String contentType;

    @ApiModelProperty(value = "文件url")
    private String url;

    @ApiModelProperty(value = "存储桶")
    private String bucket;

}
