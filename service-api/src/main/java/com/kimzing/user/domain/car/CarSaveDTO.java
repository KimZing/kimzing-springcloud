package com.kimzing.user.domain.car;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 车辆信息保存对象.
 *
 * @author KimZing - kimzing@163.com
 * @since 2020/7/4 14:51
 */
@Data
public class CarSaveDTO implements Serializable {

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
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime buyTime;

}
