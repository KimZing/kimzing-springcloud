package com.kimzing.user.repository.user;

import com.kimzing.redis.KFCRedisTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * 用户缓存操作.
 *
 * @author KimZing - kimzing@163.com
 * @since 2020/7/18 16:24
 */
@Repository
public class UserCacheRepository {

    public static final String PREFIX = "user:";

    @Resource
    KFCRedisTemplate kfcRedisTemplate;

    public void insert(UserCachePO userCachePO) {
        kfcRedisTemplate.opsForValue().set(PREFIX + userCachePO.getId(), userCachePO);
    }

    public void delete(Integer id) {
        kfcRedisTemplate.delete(PREFIX + id);
    }

    public UserCachePO get(Integer id) {
        UserCachePO userCachePO = kfcRedisTemplate.get(PREFIX + id, UserCachePO.class);
        return userCachePO;
    }

}
