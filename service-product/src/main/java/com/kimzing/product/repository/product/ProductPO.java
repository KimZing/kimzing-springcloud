package com.kimzing.product.repository.product;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.kimzing.utils.po.AbstractPO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 商品信息实体
 *
 * @author KimZing
 * @since 2020-07-23
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("product")
public class ProductPO extends AbstractPO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 商品标题
     */
    @TableField("title")
    private String title;

    /**
     * 商品副标题
     */
    @TableField("sub_title")
    private String subTitle;

    /**
     * 价格
     */
    @TableField("price")
    private BigDecimal price;

    /**
     * 商品主图
     */
    @TableField("image")
    private String image;

    /**
     * 专辑图片，以逗号分割
     */
    @TableField("album_images")
    private String albumImages;

    /**
     * 销量
     */
    @TableField("sales")
    private Integer sales;

    /**
     * 库存
     */
    @TableField("stock")
    private Integer stock;

    /**
     * 库存预警值
     */
    @TableField("low_stock")
    private Integer lowStock;

    /**
     * 关键字
     */
    @TableField("keywords")
    private String keywords;

    /**
     * PC端网页详情
     */
    @TableField("detail_pc")
    private String detailPc;

    /**
     * 移动端网页详情
     */
    @TableField("detail_mobile")
    private String detailMobile;

    /**
     * 上架状态：UNPUBLISHED->下架；PUBLISHED->上架
     */
    @TableField("publish_status")
    private String publishStatus;

}
