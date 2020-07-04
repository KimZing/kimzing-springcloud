package com.kimzing.user.listener.user;

import com.kimzing.user.listener.user.event.UserCreatedEvent;
import com.kimzing.utils.log.LogUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * 购物车监听.
 *
 * @author KimZing - kimzing@163.com
 * @since 2020/7/1 14:35
 */
@Slf4j
@Component
public class CartListener {

    @Async
    @EventListener
    public void createCart(UserCreatedEvent userCreatedEvent) {
        LogUtil.info("正在创建[{}]的购物车", userCreatedEvent.getUsername());
    }

}
