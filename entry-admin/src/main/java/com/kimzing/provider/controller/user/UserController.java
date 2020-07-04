package com.kimzing.provider.controller.user;

import com.kimzing.provider.service.user.UserService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户接口层.
 *
 * @author KimZing - kimzing@163.com
 * @since 2020/7/4 12:53
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Reference
    UserService userService;

    @DeleteMapping("/{id}")
    public void remove(@PathVariable("id") Integer id) {
        userService.remove(id);
    }

}
