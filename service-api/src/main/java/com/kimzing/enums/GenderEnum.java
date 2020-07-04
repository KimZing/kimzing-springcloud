package com.kimzing.enums;

/**
 * 性别.
 *
 * @author KimZing - kimzing@163.com
 * @since 2020/7/1 22:50
 */
public enum GenderEnum {

    /**女*/
    WOMAN(0, "女"),
    /**男*/
    MAN(1, "男"),
    /**保密*/
    SECRET(2, "保密");

    private int code;
    private String name;

    GenderEnum(int code, String name) {
        this.code = code;
        this.name = name;
    }

}