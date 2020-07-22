package com.kimzing.product.repository.product;

import com.kimzing.product.domain.product.*;
import org.springframework.stereotype.Repository;
import com.kimzing.redis.KFCRedisTemplate;
import javax.annotation.Resource;

/**
 * 产品信息 缓存操作
 *
 * @author KimZing
 * @since 2020-07-23
 */
@Repository
public class ProductCacheRepository {

    public static final String PREFIX = "product:";

    @Resource
    KFCRedisTemplate kfcRedisTemplate;

    /**
     * 插入产品信息缓存
     */
    public void insert(ProductCachePO productCachePO) {
        kfcRedisTemplate.opsForValue().set(PREFIX + productCachePO.getId(), productCachePO);
    }

    /**
     * 删除产品信息缓存
     */
    public void delete(Integer id) {
        kfcRedisTemplate.delete(PREFIX + id);
    }

    /**
     * 读取产品信息缓存
     */
    public ProductCachePO get(Integer id) {
        return kfcRedisTemplate.get(PREFIX + id, ProductCachePO.class);
    }

}
