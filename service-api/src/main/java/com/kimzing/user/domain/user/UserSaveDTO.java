package com.kimzing.user.domain.user;

import com.kimzing.user.domain.car.CarSaveDTO;
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

    @NotBlank(message = "用户名不能为空")
    @Size(min = 3, max = 8, message = "用户名长度3-8")
    @ApiModelProperty(value = "用户名")
    private String username;

    @Range(min = 1, max = 200, message = "年龄信息错误")
    @ApiModelProperty(value = "年龄")
    private Integer age;

    @ApiModelProperty(value = "金额")
    private BigDecimal amount;

    @NotNull(message = "用户性别不能为空")
    @ApiModelProperty(value = "性别")
    private GenderEnum gender;

    @ApiModelProperty(value = "车辆信息")
    private List<CarSaveDTO> carList;

}
