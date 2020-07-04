package com.kimzing.order.service;

import com.kimzing.order.domain.OrderBO;
import com.kimzing.order.domain.OrderSaveDTO;
import com.kimzing.order.domain.OrderUpdateDTO;
import com.kimzing.utils.page.PageParam;

import java.util.List;

/**
 * 订单服务.
 *
 * @author KimZing - kimzing@163.com
 * @since 2020/7/4 14:17
 */
public interface OrderService {

    /**
     * 保存订单
     * @param orderSaveDTO
     */
    void save(OrderSaveDTO orderSaveDTO);

    /**
     * 移除订单
     * @param id
     */
    void remove(Integer id);

    /**
     * 更新订单
     * @param orderUpdateDTO
     */
    void update(OrderUpdateDTO orderUpdateDTO);

    /**
     * 根据订单ID查询订单
     * @param id
     * @return
     */
    OrderBO get(Integer id);

    /**
     * 分页查询订单
     * @param userId
     * @return
     */
    List<OrderBO> listPageByUserId(Integer userId, PageParam pageParam);

}
