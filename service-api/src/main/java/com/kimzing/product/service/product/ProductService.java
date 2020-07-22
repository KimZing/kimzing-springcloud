package com.kimzing.product.service.product;

import com.kimzing.product.domain.product.*;
import com.kimzing.utils.page.PageParam;
import com.kimzing.utils.page.PageResult;
import javax.validation.constraints.NotNull;

/**
 * 产品信息 服务接口
 *
 * @author KimZing
 * @since 2020-07-23
 */
public interface ProductService {

    /**
     * 保存产品信息
     */
    ProductBO save(ProductSaveDTO productSaveDTO);

    /**
     * 移除产品信息
     */
    void remove(@NotNull(message = "PRODUCT_1001") Integer id);

    /**
     * 更新产品信息
     */
    void update(ProductUpdateDTO productUpdateDTO);

    /**
     * 查询单个产品信息
     */
    ProductBO get(@NotNull(message = "PRODUCT_1001") Integer id);

    /**
     * 分页条件查询产品信息
     */
    PageResult<ProductBO> listPage(ProductQueryDTO productQueryDTO, PageParam pageParam);
}
