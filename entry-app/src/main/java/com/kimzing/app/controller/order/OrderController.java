package com.kimzing.app.controller.order;


import com.kimzing.app.aggregation.OrderAggregation;
import com.kimzing.order.domain.order.OrderBO;
import com.kimzing.order.domain.order.OrderQueryDTO;
import com.kimzing.order.domain.order.OrderSaveDTO;
import com.kimzing.order.domain.order.OrderUpdateDTO;
import com.kimzing.order.service.order.OrderService;
import com.kimzing.utils.page.PageParam;
import com.kimzing.utils.page.PageResult;
import com.kimzing.web.resolver.json.JsonParam;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 订单信息接口层.
 *
 * @author KimZing
 * @since 2020-07-06
 */
@Api(tags = "订单信息")
@RestController
@RequestMapping("/order")
public class OrderController {

    @Reference
    OrderService orderService;

    @Resource
    OrderAggregation orderAggregation;

    @ApiOperation(value = "保存订单信息")
    @PostMapping
    public void save(@RequestBody OrderSaveDTO orderSaveDTO) {
        orderAggregation.createOrderAndPay(orderSaveDTO);
    }

    @ApiOperation(value = "移除订单信息")
    @DeleteMapping("/{id}")
    public void remove(@PathVariable("id") Integer id) {
        orderService.remove(id);
    }

    @ApiOperation(value = "更新订单信息")
    @PutMapping
    public void update(@RequestBody OrderUpdateDTO orderUpdateDTO) {
        orderService.update(orderUpdateDTO);
    }

    @ApiOperation(value = "查询单个订单信息")
    @GetMapping("/{id}")
    public OrderBO get(@PathVariable("id") Integer id) {
        return orderService.get(id);
    }

    @ApiOperation(value = "分页条件查询订单信息")
    @GetMapping("/list")
    public PageResult<OrderBO> listPage(@JsonParam OrderQueryDTO orderQueryDTO, @ModelAttribute PageParam pageParam) {
        return orderService.listPage(orderQueryDTO, pageParam);
    }

}
