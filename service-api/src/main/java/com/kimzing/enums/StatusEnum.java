package com.kimzing.enums;

/**
 * 状态.
 *
 * @author KimZing - kimzing@163.com
 * @since 2020/7/3 17:55
 */
public enum StatusEnum {

    /**启用*/
    ENABLE(1, "启用"),
    /**禁用*/
    DISABLE(0, "禁用");

    private int code;
    private String name;

    StatusEnum(int code, String name) {
        this.code = code;
        this.name = name;
    }

}
