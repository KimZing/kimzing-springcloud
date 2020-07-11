package com.kimzing.notice.service;

import com.kimzing.order.domain.order.OrderCreateEvent;
import com.kimzing.user.domain.user.UserCreateEvent;

/**
 * 用户提醒服务.
 *
 * @author KimZing - kimzing@163.com
 * @since 2020/7/11 19:26
 */
public interface UserNoticeService {

    void registerSuccess(UserCreateEvent userCreateEvent);

    void orderSucess(OrderCreateEvent orderCreateEvent);
}
