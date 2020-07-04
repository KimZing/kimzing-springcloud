package com.kimzing.user.domain.car;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 车辆信息更新对象.
 *
 * @author KimZing - kimzing@163.com
 * @since 2020/7/4 14:51
 */
@Data
public class CarUpdateDTO implements Serializable {

    /**
     * 车辆ID
     */
    private Integer id;

    /**
     * 车辆品牌
     */
    private String brand;

    /**
     * 车辆价格
     */
    private BigDecimal price;

    /**
     * 车辆购买时间
     */
    private LocalDateTime buyTime;

}