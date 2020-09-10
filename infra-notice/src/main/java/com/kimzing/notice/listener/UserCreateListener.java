package com.kimzing.notice.listener;

import com.kimzing.notice.service.UserNoticeService;
import com.kimzing.user.domain.user.UserCreateEvent;
import com.kimzing.utils.log.LogUtil;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 监听用户创建，演示消息监听.
 *
 * @author KimZing - kimzing@163.com
 * @since 2020/7/11 17:43
 */
@Component
public class UserCreateListener {

    @Resource
    UserNoticeService userNoticeService;

    public void onMessage(UserCreateEvent userCreateEvent) {
        LogUtil.info("向用户发送注册成功邮件: [{}]", userCreateEvent);
        userNoticeService.registerSuccess(userCreateEvent);
    }

}
