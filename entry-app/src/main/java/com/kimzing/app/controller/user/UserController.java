package com.kimzing.app.controller.user;


import com.kimzing.app.aggregation.UserAggregation;
import com.kimzing.app.domain.UserOrderBO;
import com.kimzing.user.domain.user.UserBO;
import com.kimzing.user.domain.user.UserQueryDTO;
import com.kimzing.user.domain.user.UserSaveDTO;
import com.kimzing.user.domain.user.UserUpdateDTO;
import com.kimzing.user.service.user.UserService;
import com.kimzing.utils.page.PageParam;
import com.kimzing.utils.page.PageResult;
import com.kimzing.web.resolver.json.JsonParam;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 用户信息接口层.
 *
 * @author KimZing
 * @since 2020-07-05
 */
@Api(tags = "用户信息")
@RestController
@RequestMapping("/user")
public class UserController {

    @Reference
    UserService userService;

    @Resource
    UserAggregation userAggregation;

    @ApiOperation(value = "保存用户信息")
    @PostMapping
    public void save(@RequestBody UserSaveDTO userSaveDTO) {
        userService.save(userSaveDTO);
    }

    @ApiOperation(value = "移除用户信息")
    @DeleteMapping("/{id}")
    public void remove(@PathVariable("id") Integer id) {
        userService.remove(id);
    }

    @ApiOperation(value = "更新用户信息")
    @PutMapping
    public void update(@RequestBody UserUpdateDTO userUpdateDTO) {
        userService.update(userUpdateDTO);
    }

    @ApiOperation(value = "查询单个用户信息")
    @GetMapping("/{id}")
    public UserBO get(@PathVariable("id") Integer id) {
        return userService.get(id);
    }

    @ApiOperation(value = "分页条件查询用户信息")
    @GetMapping("/list")
    public PageResult<UserBO> listPage(@JsonParam UserQueryDTO userQueryDTO, @ModelAttribute PageParam pageParam) {
        return userService.listPage(userQueryDTO, pageParam);
    }

    @ApiOperation(value = "聚合用户+订单(演示聚合的使用)")
    @GetMapping("/user-order/{id}")
    public UserOrderBO getUserAndOrderList(@PathVariable("id") Integer id, @ModelAttribute PageParam pageParam) {
        return userAggregation.getUserInfoWithOrderList(id, pageParam);
    }

}
