package com.kimzing.order.domain;

import java.math.BigDecimal;

/**
 * 订单保存对象.
 *
 * @author KimZing - kimzing@163.com
 * @since 2020/7/4 14:18
 */
public class OrderSaveDTO {

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
