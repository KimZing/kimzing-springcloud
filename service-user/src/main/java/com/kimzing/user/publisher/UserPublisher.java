package com.kimzing.user.publisher;

import com.kimzing.user.domain.user.UserCreateEvent;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 用户相关信息发布.
 *
 * @author KimZing - kimzing@163.com
 * @since 2020/7/11 17:22
 */
@Slf4j
@Component
public class UserPublisher {

    @Resource
    RocketMQTemplate rocketMQTemplate;

    /**
     * 用户创建消息
     */
    public void publishUserCreateEvent(UserCreateEvent userCreateEvent) {
        rocketMQTemplate.asyncSend(UserCreateEvent.TOPIC, userCreateEvent,
                new SendCallback() {
                    @Override
                    public void onSuccess(SendResult sendResult) {
                        log.info("消息[{}]发送成功: [{}]", userCreateEvent, sendResult);
                    }

                    @Override
                    public void onException(Throwable e) {
                        log.error("消息[{}]发送失败: [{}]", userCreateEvent, e);
                    }
                });
    }

}
