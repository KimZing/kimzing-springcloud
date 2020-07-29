package com.kimzing.app.controller.user;


import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.kimzing.user.domain.user.GenderEnum;
import com.kimzing.user.domain.user.UserBO;
import com.kimzing.user.domain.user.UserSaveDTO;
import com.kimzing.user.domain.user.UserUpdateDTO;
import com.kimzing.user.service.user.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.*;

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

    @ApiOperation(value = "保存用户信息")
    @PostMapping
    public UserBO save(@RequestBody UserSaveDTO userSaveDTO) {
        return userService.save(userSaveDTO);
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

}
