package com.kimzing.provider.entity.user;

import com.kimzing.provider.user.vo.GenderEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * <p>
 * 
 * </p>
 *
 * @author MybatisPlus Generator
 * @since 2020-07-02
 */
// TODO 抽象出BaseEntity
@Data
@EqualsAndHashCode(callSuper = false)
public class UserEntity implements Serializable {

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
     * 金额
     */
    private BigDecimal amount;

    /**
     * 性别
     */
    private GenderEnum gender;

    /**
     * 创建人
     */
    private String creater;

    /**
     * 更新人
     */
    private String modifier;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 修改时间
     */
    private LocalDateTime modifyTime;


}
