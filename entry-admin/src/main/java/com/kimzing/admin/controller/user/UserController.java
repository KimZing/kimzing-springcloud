package com.kimzing.admin.controller.user;


import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.kimzing.admin.aggregation.user.UserAggregation;
import com.kimzing.admin.domain.user.UserOrderBO;
import com.kimzing.user.domain.user.*;
import com.kimzing.user.service.user.UserService;
import com.kimzing.utils.page.PageParam;
import com.kimzing.utils.page.PageResult;
import com.kimzing.web.resolver.json.JsonParam;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.math.BigDecimal;

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

    @DubboReference
    UserService userService;

    @Resource
    UserAggregation userAggregation;

    @ApiOperation(value = "保存用户信息")
    @PostMapping
    public UserBO save(@RequestBody UserSaveDTO userSaveDTO) {
        return userService.save(userSaveDTO);
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
    @SentinelResource(value = "获取用户信息", fallback = "getFallbacktUser")
    public UserBO get(@PathVariable("id") Integer id) {
        return userService.get(id);
    }

    /**
     * 模拟：请求失败时，返回默认用户信息
     * @param id
     * @return
     */
    public UserBO getFallbacktUser(Integer id) {
        UserBO userBO = new UserBO().setAge(0).setUsername("default")
                .setAmount(new BigDecimal("0"))
                .setGender(GenderEnum.SECRET);
        userBO.setId(-1);
        return userBO;
    }

    @ApiOperation(value = "分页条件查询用户信息")
    @GetMapping("/list")
    public PageResult<UserBO> listPage(@JsonParam(required = false) UserQueryDTO userQueryDTO, @ModelAttribute PageParam pageParam) {
        return userService.listPage(userQueryDTO, pageParam);
    }

    @ApiOperation(value = "聚合用户+订单(演示聚合的使用)")
    @GetMapping("/user-order/{id}")
    public UserOrderBO getUserAndOrderList(@PathVariable("id") Integer id, @ModelAttribute PageParam pageParam) {
        return userAggregation.getUserInfoWithOrderList(id, pageParam);
    }

}
