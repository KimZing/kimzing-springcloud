package com.kimzing.product.repository.product;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.kimzing.product.domain.product.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * 商品信息 Mapper 接口
 *
 * @author KimZing
 * @since 2020-07-23
 */
@Mapper
public interface ProductMapper {

    /**
     * 保存商品信息
     */
    Integer insert(ProductPO productPO);

    /**
     * 批量保存商品信息
     */
    void insertBatch(List<ProductPO> list);

    /**
     * 删除商品信息
     */
    void delete(Integer id);

    /**
     * 根据ID更新商品信息
     */
    void update(ProductPO productPO);

    /**
     * 根据ID查询商品信息
     */
    ProductBO selectById(Integer id);

    /**
     * 条件分页查询商品信息
     */
    IPage<ProductBO> selectPage(Page<ProductBO> page, @Param("query") ProductQueryDTO productQueryDTO);

}
