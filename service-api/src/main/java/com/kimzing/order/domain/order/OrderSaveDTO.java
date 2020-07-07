package com.kimzing.order.domain.order;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 订单信息保存
 *
 * @author KimZing
 * @since 2020-07-06
 */
@Data
@Accessors(chain = true)
@ApiModel(value="订单信息保存", description="订单信息")
public class OrderSaveDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    @NotNull(message = "ORDER_1001")
    @ApiModelProperty(value = "用户ID")
    private Integer userId;

    @NotNull(message = "")
    @ApiModelProperty(value = "ORDER_1002")
    private BigDecimal totalPrice;

    @NotNull(message = "ORDER_1003")
    @ApiModelProperty(value = "状态")
    private OrderStatusEnum status;

}
