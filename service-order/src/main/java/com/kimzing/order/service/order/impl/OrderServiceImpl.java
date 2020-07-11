package com.kimzing.order.service.order.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.kimzing.order.domain.order.*;
import com.kimzing.order.publisher.OrderPublisher;
import com.kimzing.order.repository.order.OrderMapper;
import com.kimzing.order.service.order.OrderService;
import com.kimzing.user.service.user.UserService;
import com.kimzing.utils.bean.BeanUtil;
import com.kimzing.utils.page.PageParam;
import com.kimzing.utils.page.PageResult;
import org.apache.dubbo.config.annotation.Reference;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

import static com.kimzing.utils.page.MPPageUtil.convertPage;
import static com.kimzing.utils.page.MPPageUtil.convertPageResult;

/**
 * 订单信息 服务实现类
 *
 * @author KimZing
 * @since 2020-07-06
 */
@Service(protocol = "dubbo", timeout = 2000)
public class OrderServiceImpl implements OrderService {

    @Reference
    UserService userService;

    @Resource
    OrderMapper orderMapper;

    @Resource
    OrderPublisher orderPublisher;

    /**
     * 保存订单信息
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(OrderSaveDTO orderSaveDTO) {
        OrderPO orderPO = BeanUtil.mapperBean(orderSaveDTO, OrderPO.class);
        orderMapper.insert(orderPO);

        // 发布订单创建事件, 其他相关消费组进行业务处理
        OrderCreateEvent orderCreateEvent = new OrderCreateEvent().setId(orderPO.getId()).setUserId(orderPO.getUserId());
        orderPublisher.publishOrderCreateEvent(orderCreateEvent);
        // 发布延时事件，将超时的订单进行取消
        OrderCheckEvent orderCheckEvent = new OrderCheckEvent().setId(orderPO.getId());
        orderPublisher.publishOrderCheckEvent(orderCheckEvent);
    }

    /**
     * 移除订单信息
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void remove(Integer id) {
        orderMapper.delete(id);
    }

    /**
     * 更新订单信息
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(OrderUpdateDTO orderUpdateDTO) {
        OrderPO orderPO = BeanUtil.mapperBean(orderUpdateDTO, OrderPO.class);
        orderMapper.update(orderPO);
    }

    /**
     * 查询单个订单信息
     */
    @Override
    @Transactional(readOnly = true)
    public OrderBO get(Integer id) {
        return orderMapper.selectById(id);
    }

    /**
     * 分页条件查询订单信息
     */
    @Override
    @Transactional(readOnly = true)
    public PageResult<OrderBO> listPage(OrderQueryDTO orderQueryDTO, PageParam pageParam) {
        IPage<OrderBO> orderBOPage = orderMapper.selectPage(convertPage(pageParam), orderQueryDTO);
        return convertPageResult(orderBOPage);
    }

    /**
     * 通过User服务抛出自定义异常
     */
    @Override
    public void testException() {
        userService.testException();
    }

}
