package com.kimzing.product.repository.product;

import com.kimzing.utils.po.AbstractPO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 产品信息缓存实体
 *
 * @author KimZing
 * @since 2020-07-23
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class ProductCachePO extends AbstractPO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 商品标题
     */
    private String title;
    /**
     * 商品副标题
     */
    private String subTitle;
    /**
     * 价格
     */
    private BigDecimal price;
    /**
     * 商品主图
     */
    private String image;
    /**
     * 专辑图片，以逗号分割
     */
    private String albumImages;
    /**
     * 销量
     */
    private Integer sales;
    /**
     * 库存
     */
    private Integer stock;
    /**
     * 库存预警值
     */
    private Integer lowStock;
    /**
     * 关键字
     */
    private String keywords;
    /**
     * PC端网页详情
     */
    private String detailPc;
    /**
     * 移动端网页详情
     */
    private String detailMobile;
    /**
     * 上架状态：UNPUBLISHED->下架；PUBLISHED->上架
     */
    private String publishStatus;

}
