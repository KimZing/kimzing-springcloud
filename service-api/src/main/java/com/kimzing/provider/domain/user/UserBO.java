package com.kimzing.provider.domain.user;

import com.kimzing.enums.GenderEnum;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 *
 * @author generator
 * @since 2020-07-01
 */
@Data
public class UserBO implements Serializable {

    /**
     * 用户ID
     */
    private Integer id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 性别
     */
    private GenderEnum gender;

    /**
     * 金额
     */
    private BigDecimal amount;

}
