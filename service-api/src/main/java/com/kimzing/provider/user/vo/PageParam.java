package com.kimzing.provider.user.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * .
 *
 * @author KimZing - kimzing@163.com
 * @since 2020/7/2 00:44
 */
@Data
public class PageParam implements Serializable {

    private Integer pageNum;

    private Integer pageSize;

}
