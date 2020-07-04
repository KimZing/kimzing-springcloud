package com.kimzing.order.domain.user;

import com.kimzing.user.domain.user.GenderEnum;
import com.kimzing.utils.po.AbstractPO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * <p>
 * 
 * </p>
 *
 * @author MybatisPlus Generator
 * @since 2020-07-02
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class UserPO extends AbstractPO implements Serializable {

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
