package com.kimzing.order.listener;

import com.kimzing.order.listener.event.OrderCreatedEvent;
import com.kimzing.utils.log.LogUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * 支付监听.
 *
 * @author KimZing - kimzing@163.com
 * @since 2020/7/1 14:35
 */
@Slf4j
@Component
public class PayListener {

    @Async
    @EventListener
    public void createCart(OrderCreatedEvent orderCreatedEvent) {
        LogUtil.info("订单[{}]需支付[{}]元", orderCreatedEvent.getId(), orderCreatedEvent.getTotalPrice());
    }

}
