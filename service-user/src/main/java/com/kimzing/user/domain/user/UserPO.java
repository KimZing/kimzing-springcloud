package com.kimzing.user.domain.user;

import com.kimzing.utils.po.AbstractPO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

/**
 * 用户信息持久化对象.
 *
 * @author KimZing - kimzing@163.com
 * @since 2020/7/4 15:25
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class UserPO extends AbstractPO {

    /**
     * 用户名
     */
    private String username;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 金额
     */
    private BigDecimal amount;

    /**
     * 性别
     */
    private GenderEnum gender;

}
