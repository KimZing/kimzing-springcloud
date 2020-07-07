package com.kimzing.user.domain.car;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 用户车辆信息更新
 *
 * @author KimZing
 * @since 2020-07-05
 */
@Data
@Accessors(chain = true)
@ApiModel(value="用户车辆信息更新", description="用户车辆信息")
public class CarUpdateDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "用户车辆信息ID", example = "1")
    private Integer id;

    @ApiModelProperty(value = "所属用户ID", example = "1")
    private Integer userId;

    @ApiModelProperty(value = "车辆品牌", example = "奥迪A8")
    private String brand;

    @ApiModelProperty(value = "车辆价格", example = "800000")
    private BigDecimal price;

    @ApiModelProperty(value = "购买时间", example = "2019-07-07 12:12:12")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime buyTime;

}
