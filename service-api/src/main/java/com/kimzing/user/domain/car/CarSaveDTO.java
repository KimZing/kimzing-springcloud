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
 * 用户车辆信息保存
 *
 * @author KimZing
 * @since 2020-07-05
 */
@Data
@Accessors(chain = true)
@ApiModel(value="用户车辆信息保存", description="用户车辆信息")
public class CarSaveDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "所属用户ID")
    private Integer userId;

    @ApiModelProperty(value = "车辆品牌", example = "奥迪")
    private String brand;

    @ApiModelProperty(value = "车辆价格", example = "600000")
    private BigDecimal price;

    @ApiModelProperty(value = "购买时间", example = "2020-07-07 12:12:12")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime buyTime;

}
