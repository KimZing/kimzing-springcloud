package com.kimzing.user.repository.car;

import com.kimzing.user.domain.car.CarPO;
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
     * @param carPOList
     */
    void insertCarList(Integer userId, List<CarPO> carPOList);

    /**
     * 根据用户ID删除所有车辆信息
     * @param id
     */
    void deleteByUserId(Integer id);

    /**
     * 根据用户ID批量跟新车辆信息
     * @param userId
     * @param carPOList
     */
    void updateCarListByUserId(Integer userId, List<CarPO> carPOList);
}
