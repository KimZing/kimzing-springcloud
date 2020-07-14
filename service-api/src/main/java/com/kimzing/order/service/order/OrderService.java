package com.kimzing.order.service.order;

import com.kimzing.order.domain.order.*;
import com.kimzing.utils.page.PageParam;
import com.kimzing.utils.page.PageResult;

/**
 * 订单信息 服务接口
 *
 * @author KimZing
 * @since 2020-07-06
 */
public interface OrderService {

    /**
     * 保存订单信息
     */
    OrderBO save(OrderSaveDTO orderSaveDTO);

    /**
     * 移除订单信息
     */
    void remove(Integer id);

    /**
     * 更新订单信息
     */
    void update(OrderUpdateDTO orderUpdateDTO);

    /**
     * 查询单个订单信息
     */
    OrderBO get(Integer id);

    /**
     * 分页条件查询订单信息
     */
    PageResult<OrderBO> listPage(OrderQueryDTO orderQueryDTO, PageParam pageParam);

}
