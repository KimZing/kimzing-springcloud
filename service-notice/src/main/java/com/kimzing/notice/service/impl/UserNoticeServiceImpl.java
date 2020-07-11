package com.kimzing.notice.service.impl;

import com.kimzing.notice.service.UserNoticeService;
import com.kimzing.user.domain.user.UserCreateEvent;
import com.kimzing.utils.json.JsonUtil;
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
@Service
public class UserNoticeServiceImpl implements UserNoticeService {

    @Resource
    JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    private String from;

    @Override
    public void sendEmailToAdmin(UserCreateEvent userCreateEvent) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom(from);
        simpleMailMessage.setTo("kimzing@163.com");
        simpleMailMessage.setSubject("新用户创建提醒");
        simpleMailMessage.setText(JsonUtil.beanToJson(userCreateEvent));
        javaMailSender.send(simpleMailMessage);
    }

}
