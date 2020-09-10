package com.kimzing.order.publisher;

import com.kimzing.order.domain.order.OrderCheckCancelEvent;
import com.kimzing.utils.log.LogUtil;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 订单相关事件发布.
 *
 * @author KimZing - kimzing@163.com
 * @since 2020/7/11 23:03
 */
@Component
public class OrderPublisher {

    /**
     * 检查订单，如果超时30min未支付则更改为取消状态
     * @param orderCheckCancelEvent
     */
    public void publishOrderCheckCancelEvent(OrderCheckCancelEvent orderCheckCancelEvent) {
    }
}
