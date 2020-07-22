package com.kimzing.product.repository.product;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.kimzing.product.domain.product.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * 产品信息 Mapper 接口
 *
 * @author KimZing
 * @since 2020-07-23
 */
@Mapper
public interface ProductMapper {

    /**
     * 保存产品信息
     */
    Integer insert(ProductPO productPO);

    /**
     * 批量保存产品信息
     */
    void insertBatch(List<ProductPO> list);

    /**
     * 删除产品信息
     */
    void delete(Integer id);

    /**
     * 根据ID更新产品信息
     */
    void update(ProductPO productPO);

    /**
     * 根据ID查询产品信息
     */
    ProductBO selectById(Integer id);

    /**
     * 条件分页查询产品信息
     */
    IPage<ProductBO> selectPage(Page<ProductBO> page, @Param("query") ProductQueryDTO productQueryDTO);

}
