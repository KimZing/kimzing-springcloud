package com.kimzing.provider.domain.user;

import com.kimzing.enums.GenderEnum;
import lombok.Data;

import java.io.Serializable;

/**
 * 用户查询.
 *
 * @author KimZing - kimzing@163.com
 * @since 2020/7/2 00:32
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

}
