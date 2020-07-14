package com.kimzing.notice.listener;

import com.kimzing.notice.service.UserNoticeService;
import com.kimzing.user.domain.user.UserCreateEvent;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 监听用户创建，演示消息监听.
 *
 * @author KimZing - kimzing@163.com
 * @since 2020/7/11 17:43
 */
@Slf4j
@Component
@RocketMQMessageListener(topic = UserCreateEvent.TOPIC, consumerGroup = "notice-user-create-group")
public class UserCreateListener implements RocketMQListener<UserCreateEvent> {

    @Resource
    UserNoticeService userNoticeService;

    @Override
    public void onMessage(UserCreateEvent userCreateEvent) {
        log.info("向用户发送注册成功邮件: [{}]", userCreateEvent);
        userNoticeService.registerSuccess(userCreateEvent);
    }

}
