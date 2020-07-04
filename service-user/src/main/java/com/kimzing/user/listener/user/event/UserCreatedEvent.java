package com.kimzing.user.listener.user.event;

import lombok.Data;

/**
 * 创建用户事件.
 *
 * @author KimZing - kimzing@163.com
 * @since 2020/7/2 01:08
 */
@Data
public class UserCreatedEvent {

    /**
     * 用户ID
     */
    private Integer id;

    /**
     * 用户名
     */
    private String username;

}
