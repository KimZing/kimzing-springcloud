package com.kimzing.order.domain;

/**
 * 订单状态.
 *
 * @author KimZing - kimzing@163.com
 * @since 2020/7/4 14:32
 */
public enum OrderStatusEnum {
    CREATED("已创建"),
    PAYED("已支付"),
    DENDED("已发货"),
    RECEIVED("已收货"),
    FINISHED("已完成");


    private String name;

    OrderStatusEnum(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
