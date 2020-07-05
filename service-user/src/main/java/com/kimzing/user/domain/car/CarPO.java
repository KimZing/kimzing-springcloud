package com.kimzing.user.domain.car.car;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.kimzing.utils.po.AbstractPO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 用户车辆信息实体
 *
 * @author KimZing
 * @since 2020-07-05
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("car")
public class CarPO extends AbstractPO implements Serializable{

    private static final long serialVersionUID = 1L;

    /**
     * 所属用户ID
     */
    @TableField("user_id")
    private Integer userId;

    /**
     * 车辆品牌
     */
    @TableField("brand")
    private String brand;

    /**
     * 车辆价格
     */
    @TableField("price")
    private BigDecimal price;

    /**
     * 购买时间
     */
    @TableField("buy_time")
    private LocalDateTime buyTime;

}
