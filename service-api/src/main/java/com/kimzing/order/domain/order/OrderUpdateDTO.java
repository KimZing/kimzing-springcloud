package com.kimzing.order.domain.order;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 订单信息更新
 *
 * @author KimZing
 * @since 2020-07-06
 */
@Data
@Accessors(chain = true)
@ApiModel(value="订单信息更新", description="订单信息")
public class OrderUpdateDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "订单信息ID")
    private Integer id;

    @ApiModelProperty(value = "状态")
    private OrderStatusEnum status;

}
