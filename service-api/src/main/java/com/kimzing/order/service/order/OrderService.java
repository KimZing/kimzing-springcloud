package com.kimzing.order.service.order;

import com.kimzing.order.domain.order.OrderBO;
import com.kimzing.order.domain.order.OrderQueryDTO;
import com.kimzing.order.domain.order.OrderSaveDTO;
import com.kimzing.order.domain.order.OrderUpdateDTO;
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
    void save(OrderSaveDTO orderSaveDTO);

    /**
     * 移除订单信息
     */
    public void remove(Integer id);

    /**
     * 更新订单信息
     */
    public void update(OrderUpdateDTO orderUpdateDTO);

    /**
     * 查询单个订单信息
     */
    public OrderBO get(Integer id);

    /**
     * 分页条件查询订单信息
     */
    public PageResult<OrderBO> listPage(OrderQueryDTO orderQueryDTO, PageParam pageParam);

}
