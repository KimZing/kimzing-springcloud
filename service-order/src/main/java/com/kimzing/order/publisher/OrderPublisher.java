package com.kimzing.order.publisher;

import com.kimzing.order.domain.order.OrderCheckCancelEvent;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
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

    @Resource
    RocketMQTemplate rocketMQTemplate;

    /**
     * 检查订单，如果超时30min未支付则更改为取消状态
     * @param orderCheckCancelEvent
     */
    public void publishOrderCheckCancelEvent(OrderCheckCancelEvent orderCheckCancelEvent) {
        // rocketMQTemplate.asyncSend(OrderCheckCancelEvent.TOPIC, MessageBuilder.withPayload(orderCheckCancelEvent).build(),
        //         new SendCallback() {
        //             @Override
        //             public void onSuccess(SendResult sendResult) {
        //                 LogUtil.info("消息[{}]发送成功: [{}]", orderCheckCancelEvent, sendResult);
        //             }
        //
        //             @Override
        //             public void onException(Throwable e) {
        //                 LogUtil.error("消息[{}]发送失败: [{}]", orderCheckCancelEvent, e);
        //             }
        //         }, 3000, 15);
    }
}
