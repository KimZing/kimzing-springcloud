package com.kimzing.user.domain.user;

import com.kimzing.user.domain.car.CarSaveDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * 用户信息保存
 *
 * @author KimZing
 * @since 2020-07-05
 */
@Data
@Accessors(chain = true)
@ApiModel(value="用户信息保存", description="用户信息")
public class UserSaveDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "用户名")
    private String username;

    @ApiModelProperty(value = "年龄")
    private Integer age;

    @ApiModelProperty(value = "金额")
    private BigDecimal amount;

    @ApiModelProperty(value = "性别")
    private String gender;

    @ApiModelProperty(value = "车辆信息")
    private List<CarSaveDTO> carList;

}
