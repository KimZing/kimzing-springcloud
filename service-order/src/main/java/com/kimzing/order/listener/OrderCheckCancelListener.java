package com.kimzing.order.listener;

import com.kimzing.order.domain.order.OrderBO;
import com.kimzing.order.domain.order.OrderCheckCancelEvent;
import com.kimzing.order.domain.order.OrderStatusEnum;
import com.kimzing.order.domain.order.OrderUpdateDTO;
import com.kimzing.order.service.order.OrderService;
import com.kimzing.utils.log.LogUtil;
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
@RocketMQMessageListener(topic = OrderCheckCancelEvent.TOPIC, consumerGroup = "order-check-cancel-group")
public class OrderCheckCancelListener implements RocketMQListener<OrderCheckCancelEvent> {

    @Reference
    OrderService orderService;

    @Override
    public void onMessage(OrderCheckCancelEvent message) {
        OrderBO orderBO = orderService.get(message.getId());
        LogUtil.info("检查订单[{}]状态,订单信息:[{}]", message.getId(), orderBO);

        if (orderBO == null) {
            LogUtil.warn("订单[{}]不存在", message.getId());
            return;
        }
        if (orderBO.getStatus() == OrderStatusEnum.CREATED) {
            orderService.update(new OrderUpdateDTO().setId(message.getId()).setStatus(OrderStatusEnum.CANCEL));
            LogUtil.info("订单[{}]超时未支付已取消", message.getId());
            return;
        }
        LogUtil.info("订单[{}]已支付或已取消", message.getId());
    }

}
