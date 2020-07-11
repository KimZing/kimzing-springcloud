package com.kimzing.order.publisher;

import com.kimzing.order.domain.order.OrderCheckEvent;
import com.kimzing.order.domain.order.OrderCreateEvent;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 订单相关事件发布.
 *
 * @author KimZing - kimzing@163.com
 * @since 2020/7/11 23:03
 */
@Slf4j
@Component
public class OrderPublisher {

    @Resource
    RocketMQTemplate rocketMQTemplate;


    public void publishOrderCreateEvent(OrderCreateEvent orderCreateEvent) {
        rocketMQTemplate.asyncSend(OrderCreateEvent.TOPIC, orderCreateEvent, new SendCallback() {
            @Override
            public void onSuccess(SendResult sendResult) {
                log.info("消息[{}]发送成功: [{}]", orderCreateEvent, sendResult);
            }

            @Override
            public void onException(Throwable e) {
                log.error("消息[{}]发送失败: [{}]", orderCreateEvent, e);
            }
        });
    }

    public void publishOrderCheckEvent(OrderCheckEvent orderCheckEvent) {
        rocketMQTemplate.asyncSend(OrderCheckEvent.TOPIC, MessageBuilder.withPayload(orderCheckEvent).build(),
                new SendCallback() {
                    @Override
                    public void onSuccess(SendResult sendResult) {
                        log.info("消息[{}]发送成功: [{}]", orderCheckEvent, sendResult);
                    }

                    @Override
                    public void onException(Throwable e) {
                        log.error("消息[{}]发送失败: [{}]", orderCheckEvent, e);
                    }
                }, 3000, 4);
    }
}
