package com.kimzing.notice.listener;

import com.kimzing.notice.service.UserNoticeService;
import com.kimzing.order.domain.order.OrderCreateEvent;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 监听用户创建.
 *
 * @author KimZing - kimzing@163.com
 * @since 2020/7/11 17:43
 */
@Slf4j
@Component
@RocketMQMessageListener(topic = OrderCreateEvent.TOPIC, consumerGroup = "notice-order-create-group")
public class OrderCreateListener implements RocketMQListener<OrderCreateEvent> {

    @Resource
    UserNoticeService userNoticeService;

    @Override
    public void onMessage(OrderCreateEvent orderCreateEvent) {
        log.info("向用户发送下单成功邮件: [{}]", orderCreateEvent);
        userNoticeService.orderSucess(orderCreateEvent);
    }

}
