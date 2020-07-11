package com.kimzing.user.domain.user;

import lombok.Data;
import lombok.experimental.Accessors;

import java.math.BigDecimal;

/**
 * 用户创建消息.
 *
 * @author KimZing - kimzing@163.com
 * @since 2020/7/11 17:24
 */
@Data
@Accessors(chain = true)
public class UserCreateEvent {

    /**
     * 主题
     */
    public static final String TOPIC = "user-create";

    private Integer id;

    private String username;

    private String email;

    private Integer age;

    private BigDecimal amount;

    private GenderEnum gender;

}
