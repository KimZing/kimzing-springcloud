package com.kimzing.order.repository.order;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.kimzing.order.domain.order.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 订单信息 Mapper 接口
 *
 * @author KimZing
 * @since 2020-07-06
 */
@Mapper
public interface OrderMapper {

    /**
     * 保存订单信息
     */
    Integer insert(OrderPO orderPO);

    /**
     * 删除订单信息
     */
    void delete(Integer id);

    /**
     * 根据ID更新订单信息
     */
    void update(OrderPO orderPO);

    /**
     * 根据ID查询订单信息
     */
    OrderBO select(Integer id);

    /**
     * 条件分页查询订单信息
     */
    IPage<OrderBO> selectPage(Page<OrderBO> page, @Param("query") OrderQueryDTO orderQueryDTO);

}
