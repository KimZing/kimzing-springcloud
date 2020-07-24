package com.kimzing.admin.aggregation.user;

import com.kimzing.admin.domain.user.UserOrderBO;
import com.kimzing.order.domain.order.OrderBO;
import com.kimzing.order.domain.order.OrderQueryDTO;
import com.kimzing.order.service.order.OrderService;
import com.kimzing.user.domain.user.UserBO;
import com.kimzing.user.service.user.UserService;
import com.kimzing.utils.page.PageParam;
import com.kimzing.utils.page.PageResult;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Component;

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
        PageResult<OrderBO> orderBOPageResult = orderService.listPage(new OrderQueryDTO().setUserId(id), pageParam);
        return new UserOrderBO().setUserInfo(userBO).setOrderList(orderBOPageResult.getList());
    }
}
