package com.kimzing.order.domain.order;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 订单创建事件.
 *
 * @author KimZing - kimzing@163.com
 * @since 2020/7/11 23:00
 */
@Data
@Accessors(chain = true)
public class OrderCheckCancelEvent {

    /**
     * 主题
     */
    public static final String TOPIC = "order-check-cancel";

    private Integer id;

}
