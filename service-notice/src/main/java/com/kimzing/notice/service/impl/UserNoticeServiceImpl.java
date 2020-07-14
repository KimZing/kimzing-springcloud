package com.kimzing.notice.service.impl;

import com.kimzing.notice.service.UserNoticeService;
import com.kimzing.order.domain.order.OrderCreateEvent;
import com.kimzing.user.domain.user.UserCreateEvent;
import com.kimzing.utils.json.JsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 用户提醒服务.
 *
 * @author KimZing - kimzing@163.com
 * @since 2020/7/11 19:27
 */
@Slf4j
@Service
public class UserNoticeServiceImpl implements UserNoticeService {

    @Resource
    JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    private String from;

    @Override
    public void registerSuccess(UserCreateEvent userCreateEvent) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom(from);
        simpleMailMessage.setTo(userCreateEvent.getEmail());
        simpleMailMessage.setSubject("注册成功!");
        simpleMailMessage.setText(JsonUtil.beanToJson(userCreateEvent));
        javaMailSender.send(simpleMailMessage);
    }

}
