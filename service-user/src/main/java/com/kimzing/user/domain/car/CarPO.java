package com.kimzing.user.domain.car;

import com.kimzing.utils.po.AbstractPO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 车辆信息持久化对象.
 *
 * @author KimZing - kimzing@163.com
 * @since 2020/7/4 15:25
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class CarPO extends AbstractPO {

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
