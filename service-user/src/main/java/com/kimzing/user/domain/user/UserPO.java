package com.kimzing.user.domain.user;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.kimzing.utils.po.AbstractPO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 用户信息实体
 *
 * @author KimZing
 * @since 2020-07-05
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("user")
public class UserPO extends AbstractPO implements Serializable{

    private static final long serialVersionUID = 1L;

    /**
     * 用户名
     */
    @TableField("username")
    private String username;

    /**
     * 年龄
     */
    @TableField("age")
    private Integer age;

    /**
     * 金额
     */
    @TableField("amount")
    private BigDecimal amount;

    /**
     * 性别
     */
    @TableField("gender")
    private GenderEnum gender;

}
