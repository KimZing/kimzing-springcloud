package com.kimzing.app.aggregation.order;

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
     * 创建订单并进行支付，如果失败则全部失败，演示分布式事物
     * <p>
     *     1. 用户不存在，全局回滚
     *     2. 用户余额不足，全局回滚
     *     3. 用户状态正常且余额充足，正常支付
     * </p>
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
