package com.kimzing.user.domain.user;

/**
 * 性别.
 *
 * @author KimZing - kimzing@163.com
 * @since 2020/7/1 22:50
 */
public enum GenderEnum {

    FEMALE("女"),
    MALE("男"),
    SECRET("保密");

    private String name;

    GenderEnum(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}