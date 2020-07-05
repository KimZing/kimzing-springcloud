package com.kimzing.user.aggregation;

import com.kimzing.order.domain.OrderBO;
import com.kimzing.order.service.OrderService;
import com.kimzing.user.domain.user.UserBO;
import com.kimzing.user.domain.user.UserOrderBO;
import com.kimzing.user.service.user.UserService;
import com.kimzing.utils.page.PageParam;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 用户相关信息聚合.
 *
 * @author KimZing - kimzing@163.com
 * @since 2020/7/5 20:00
 */
@Component
public class UserAggregation {

    @Reference
    OrderService orderService;

    @Reference
    UserService userService;


    /**
     * 查询用户信息及其订单列表(分页)
     * @param id
     * @param pageParam
     * @return
     */
    public UserOrderBO getUserInfoWithOrderList(Integer id, PageParam pageParam) {
        UserBO userBO = userService.get(id);
        List<OrderBO> orderBOList = orderService.listPageByUserId(id, pageParam);
        return new UserOrderBO().setUserInfo(userBO).setOrderList(orderBOList);
    }
}
