package com.kimzing.user.domain.user;

import com.kimzing.user.domain.car.CarUpdateDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * 用户信息更新
 *
 * @author KimZing
 * @since 2020-07-05
 */
@Data
@Accessors(chain = true)
@ApiModel(value="用户信息更新", description="用户信息")
public class UserUpdateDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    @NotNull(message = "USER_1005")
    @ApiModelProperty(value = "用户信息ID")
    private Integer id;

    @NotBlank(message = "USER_1001")
    @Size(min = 3, max = 8, message = "USER_1002")
    @ApiModelProperty(value = "用户名")
    private String username;

    @Range(min = 1, max = 200, message = "USER_1003")
    @ApiModelProperty(value = "年龄")
    private Integer age;

    @ApiModelProperty(value = "金额")
    private BigDecimal amount;

    @NotNull(message = "USER_1004")
    @ApiModelProperty(value = "性别")
    private GenderEnum gender;

    @ApiModelProperty(value = "车辆信息")
    private List<CarUpdateDTO> carList;

}
