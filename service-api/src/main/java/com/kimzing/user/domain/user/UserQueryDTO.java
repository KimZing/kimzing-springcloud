package com.kimzing.user.domain.user;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 用户信息查询
 *
 * @author KimZing
 * @since 2020-07-05
 */
@Data
@Accessors(chain = true)
@ApiModel(value="用户信息查询", description="用户信息")
public class UserQueryDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "最小年龄", example = "1")
    private Integer ageFrom;

    @ApiModelProperty(value = "最大年龄", example = "30")
    private Integer ageTo;

    @ApiModelProperty(value = "性别", example = "MALE")
    private GenderEnum gender;

    @ApiModelProperty(value = "查询车辆数量大于条件", example = "0")
    private Integer carNumGreaterThan;

}
