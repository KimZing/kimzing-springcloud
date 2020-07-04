package com.kimzing.order.domain;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 订单业务对象.
 *
 * @author KimZing - kimzing@163.com
 * @since 2020/7/4 14:30
 */
@Data
public class OrderBO implements Serializable {

    /**
     * 订单ID
     */
    private Integer id;

    /**
     * 用户ID
     */
    private Integer userId;

    /**
     * 订单总价
     */
    private BigDecimal totalPrice;

    /**
     * 订单状态
     */
    private OrderStatusEnum status;

}
