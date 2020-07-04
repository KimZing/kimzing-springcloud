package com.kimzing.user.domain.user;

import lombok.Data;

import java.io.Serializable;

/**
 * 用户信息查询对象.
 *
 * @author KimZing - kimzing@163.com
 * @since 2020/7/4 14:30
 */
@Data
public class UserQueryDTO implements Serializable {

    /**
     * 最小年龄
     */
    private Integer ageFrom;

    /**
     * 最大年龄
     */
    private Integer ageTo;

    /**
     * 性别
     */
    private GenderEnum gender;

    /**
     * 查询车辆数量大于条件
     */
    private Integer carNumGreaterThan;

}
