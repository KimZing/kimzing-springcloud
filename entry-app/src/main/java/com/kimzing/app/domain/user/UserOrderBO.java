package com.kimzing.app.domain.user;

import com.kimzing.order.domain.order.OrderBO;
import com.kimzing.user.domain.user.UserBO;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * 用户及其订单的视图对象.
 *
 * @author KimZing - kimzing@163.com
 * @since 2020/7/4 12:57
 */
@Data
@Accessors(chain = true)
@ApiModel(value="用户信息及订单聚合对象", description="包含用户及订单列表的信息")
public class UserOrderBO {

    /**
     * 用户信息
     */
    private UserBO userInfo;

    /**
     * 订单列表
     */
    private List<OrderBO> orderList;

}
