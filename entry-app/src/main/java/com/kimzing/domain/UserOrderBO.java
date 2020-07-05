package com.kimzing.domain;

import com.kimzing.order.domain.order.OrderBO;
import com.kimzing.user.domain.user.UserBO;
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
