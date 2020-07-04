package com.kimzing.order.domain;

/**
 * 订单更新对象.
 *
 * @author KimZing - kimzing@163.com
 * @since 2020/7/4 14:18
 */
public class OrderUpdateDTO {

    /**
     * 订单ID
     */
    private Integer id;

    /**
     * 订单状态
     */
    private OrderStatusEnum status;

}
