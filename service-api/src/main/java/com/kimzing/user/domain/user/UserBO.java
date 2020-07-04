package com.kimzing.user.domain.user;

import com.kimzing.user.domain.car.CarBO;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * 用户信息业务对象
 *
 * @author KimZing - kimzing@163.com
 * @since 2020/7/4 14:30
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

    /**
     * 车辆信息
     */
    private List<CarBO> cars;

}
