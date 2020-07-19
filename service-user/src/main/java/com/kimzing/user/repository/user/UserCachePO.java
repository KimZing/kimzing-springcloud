package com.kimzing.user.repository.user;

import com.kimzing.user.domain.user.GenderEnum;
import com.kimzing.user.repository.car.CarPO;
import com.kimzing.utils.po.AbstractPO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * 用户信息实体
 *
 * @author KimZing
 * @since 2020-07-05
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class UserCachePO extends AbstractPO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户名
     */
    private String username;

    /**
     * 邮箱
     */
    private String email;

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
     * 车辆信息
     */
    private List<CarPO> carList;

}
