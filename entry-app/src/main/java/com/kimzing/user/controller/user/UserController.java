package com.kimzing.user.controller.user;

import com.kimzing.order.domain.OrderBO;
import com.kimzing.order.service.OrderService;
import com.kimzing.user.domain.user.*;
import com.kimzing.user.service.user.UserService;
import com.kimzing.utils.page.PageParam;
import com.kimzing.utils.page.PageResult;
import com.kimzing.web.resolver.json.JsonParam;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 用户信息接口层.
 *
 * @author KimZing - kimzing@163.com
 * @since 2020/7/4 12:53
 */
@RequestMapping("/user")
@RestController
public class UserController {

    @Reference
    UserService userService;

    @Reference
    OrderService orderService;

    /**
     * 保存用户
     * @return
     */
    @PostMapping
    public void save(@RequestBody UserSaveDTO userSaveDTO) {
        userService.save(userSaveDTO);
    }

    /**
     * 移除用户
     * @return
     */
    @DeleteMapping("/{id}")
    public void remove(@PathVariable("id") Integer id) {
        userService.remove(id);
    }

    /**
     * 更新用户
     * @return
     */
    @PutMapping
    public void update(@RequestBody UserUpdateDTO userUpdateDTO) {
        userService.update(userUpdateDTO);
    }

    /**
     * 通过用户ID查询单个用户
     * @return
     */
    @GetMapping("/{id}")
    public UserBO get(@PathVariable("id") Integer id) {
        return userService.get(id);
    }

    /**
     * 分页查询用户
     * @param userQueryDTO
     * @param pageParam
     * @return
     */
    @GetMapping("/list")
    public PageResult<UserBO> listPage(@JsonParam UserQueryDTO userQueryDTO, @ModelAttribute PageParam pageParam) {
        return userService.listPage(userQueryDTO, pageParam);
    }

    /**
     * 查询用户信息及其订单信息(演示聚合的使用)
     * @param id
     * @param pageParam
     * @return
     */
    @GetMapping("/user-order/{id}")
    public UserOrderVO getUserAndOrderList(@PathVariable("id") Integer id, @ModelAttribute PageParam pageParam) {
        UserBO userBO = userService.get(id);
        List<OrderBO> orderBOList = orderService.listPageByUserId(id, pageParam);
        return new UserOrderVO().setUserInfo(userBO).setOrderList(orderBOList);
    }

}
