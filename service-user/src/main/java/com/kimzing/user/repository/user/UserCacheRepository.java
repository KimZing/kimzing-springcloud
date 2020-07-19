package com.kimzing.user.repository.user;

import com.kimzing.redis.KFCRedisTemplate;
import com.kimzing.user.domain.car.CarBO;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * 用户缓存操作.
 *
 * @author KimZing - kimzing@163.com
 * @since 2020/7/18 16:24
 */
@Repository
public class UserCacheRepository {

    @Resource
    KFCRedisTemplate kfcRedisTemplate;

    public void insert(UserCachePO userCachePO) {
        kfcRedisTemplate.opsForHash().put("test", "id", userCachePO.getId());
        kfcRedisTemplate.opsForHash().put("test", "cars", userCachePO.getCarList());
        kfcRedisTemplate.opsForValue().set(userCachePO.getId(), userCachePO);
    }

    public void delete(Integer id) {
        kfcRedisTemplate.delete(id);
    }

    public UserCachePO get(Integer id) {
        UserCachePO userCachePO = kfcRedisTemplate.get(id, UserCachePO.class);
        Integer hash = kfcRedisTemplate.getHashToBean("test", "id", Integer.class);
        List<CarBO> hash1 = kfcRedisTemplate.getHashToList("test", "cars", CarBO.class);
        return userCachePO;
    }

}
