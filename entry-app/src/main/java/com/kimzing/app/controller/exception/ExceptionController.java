package com.kimzing.app.controller.exception;

import com.kimzing.order.service.order.OrderService;
import com.kimzing.user.service.user.UserService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 验证异常体系.
 *
 * @author KimZing - kimzing@163.com
 * @since 2020/7/7 21:28
 */
@RestController
@RequestMapping("/exception")
public class ExceptionController {

    @Reference
    UserService userService;

    @Reference
    OrderService orderService;

    /**
     * 测试User服务抛出自定义异常
     */
    @GetMapping("/user")
    public void testExceptionByUser() {
        userService.testException();
    }

    /**
     * 测试Order服务调用User服务，但User服务抛出异常，能否正常捕获
     */
    @GetMapping("/user/order")
    public void testExceptionByUserThroughOrder() {
        orderService.testException();
    }

}
