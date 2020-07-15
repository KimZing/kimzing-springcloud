package com.kimzing.user.repository.car;

import com.kimzing.user.domain.car.CarBO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 车辆信息仓储.
 *
 * @author KimZing - kimzing@163.com
 * @since 2020/7/4 15:25
 */
@Mapper
public interface CarMapper {

    /**
     * 批量插入车辆信息
     * @param userId
     * @param list
     */
    void insertBatch(Integer userId, List<CarPO> list);

    /**
     * 根据用户ID删除所有车辆信息
     * @param userId
     */
    void deleteByUserId(Integer userId);

    /**
     * 根据用户ID批量跟新车辆信息
     * @param userId
     * @param carPOList
     */
    void updateListByUserId(Integer userId, List<CarPO> carPOList);

    /**
     * 根据用户ID查询车辆列表
     * @param userId
     * @return
     */
    List<CarBO> selectCarListByUserId(Integer userId);
}
