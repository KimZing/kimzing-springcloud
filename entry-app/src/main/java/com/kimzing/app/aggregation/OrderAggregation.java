package com.kimzing.app.aggregation;

import com.kimzing.order.domain.order.OrderBO;
import com.kimzing.order.domain.order.OrderSaveDTO;
import com.kimzing.order.domain.order.OrderStatusEnum;
import com.kimzing.order.domain.order.OrderUpdateDTO;
import com.kimzing.order.service.order.OrderService;
import com.kimzing.user.service.user.UserService;
import io.seata.spring.annotation.GlobalTransactional;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Component;

/**
 * 订单聚合服务.
 *
 * @author KimZing - kimzing@163.com
 * @since 2020/7/14 14:05
 */
@Component
public class OrderAggregation {

    @Reference
    UserService userService;

    @Reference
    OrderService orderService;

    /**
     * 创建订单并进行支付，如果失败则全部失败
     * @param orderSaveDTO
     */
    @GlobalTransactional
    public void createOrderAndPay(OrderSaveDTO orderSaveDTO) {
        OrderBO orderBO = orderService.save(orderSaveDTO);
        Boolean success = userService.reduceAmount(orderSaveDTO.getUserId(), orderSaveDTO.getTotalPrice());
        if (success) {
            orderService.update(new OrderUpdateDTO().setId(orderBO.getId()).setStatus(OrderStatusEnum.PAYED));
        }
    }
}
