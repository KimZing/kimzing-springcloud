package com.kimzing.order.listener;

import com.kimzing.order.domain.order.OrderBO;
import com.kimzing.order.domain.order.OrderCheckEvent;
import com.kimzing.order.domain.order.OrderStatusEnum;
import com.kimzing.order.domain.order.OrderUpdateDTO;
import com.kimzing.order.service.order.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Reference;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

/**
 * .
 *
 * @author KimZing - kimzing@163.com
 * @since 2020/7/11 23:26
 */
@Slf4j
@Component
@RocketMQMessageListener(topic = OrderCheckEvent.TOPIC, consumerGroup = "order-order-check-group")
public class OrderListener implements RocketMQListener<OrderCheckEvent> {

    @Reference
    OrderService orderService;

    @Override
    public void onMessage(OrderCheckEvent message) {
        OrderBO orderBO = orderService.get(message.getId());
        if (orderBO.getStatus() == OrderStatusEnum.CREATED) {
            orderService.update(new OrderUpdateDTO().setId(message.getId()).setStatus(OrderStatusEnum.CANCEL));
            log.info("订单[{}]超时未支付已取消", message.getId());
        }
    }

}
