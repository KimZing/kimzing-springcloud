package com.kimzing.product.service.product.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.kimzing.product.domain.product.ProductBO;
import com.kimzing.product.domain.product.ProductQueryDTO;
import com.kimzing.product.domain.product.ProductSaveDTO;
import com.kimzing.product.domain.product.ProductUpdateDTO;
import com.kimzing.product.repository.product.ProductMapper;
import com.kimzing.product.repository.product.ProductPO;
import com.kimzing.product.service.product.ProductService;
import com.kimzing.utils.bean.BeanUtil;
import com.kimzing.utils.page.PageParam;
import com.kimzing.utils.page.PageResult;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

import static com.kimzing.utils.page.MPPageUtil.convertPage;
import static com.kimzing.utils.page.MPPageUtil.convertPageResult;

/**
 * 产品信息 服务实现类
 *
 * @author KimZing
 * @since 2020-07-23
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Resource
    ProductMapper productMapper;

    /**
     * 保存产品信息
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public ProductBO save(ProductSaveDTO productSaveDTO) {
        ProductPO productPO = BeanUtil.mapperBean(productSaveDTO, ProductPO.class);
        productMapper.insert(productPO);
        return BeanUtil.mapperBean(productPO, ProductBO.class);
    }

    /**
     * 移除产品信息
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void remove(Integer id) {
        productMapper.delete(id);
    }

    /**
     * 更新产品信息
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(ProductUpdateDTO productUpdateDTO) {
        ProductPO productPO = BeanUtil.mapperBean(productUpdateDTO, ProductPO.class);
        productMapper.update(productPO);
    }

    /**
     * 查询单个产品信息
     */
    @Override
    @Transactional(readOnly = true)
    public ProductBO get(Integer id) {
        return productMapper.selectById(id);
    }

    /**
     * 分页条件查询产品信息
     */
    @Override
    @Transactional(readOnly = true)
    public PageResult<ProductBO> listPage(ProductQueryDTO productQueryDTO, PageParam pageParam) {
        IPage<ProductBO> productBOPage = productMapper.selectPage(convertPage(pageParam), productQueryDTO);
        return convertPageResult(productBOPage);
    }

}
