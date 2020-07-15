package com.kimzing.user.service.user.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.kimzing.user.repository.car.CarPO;
import com.kimzing.user.domain.user.*;
import com.kimzing.user.publisher.UserPublisher;
import com.kimzing.user.repository.car.CarMapper;
import com.kimzing.user.repository.user.UserMapper;
import com.kimzing.user.repository.user.UserPO;
import com.kimzing.user.service.user.UserService;
import com.kimzing.utils.bean.BeanUtil;
import com.kimzing.utils.exception.ExceptionManager;
import com.kimzing.utils.page.PageParam;
import com.kimzing.utils.page.PageResult;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;

import static com.kimzing.utils.page.MPPageUtil.convertPage;
import static com.kimzing.utils.page.MPPageUtil.convertPageResult;

/**
 * 用户信息 服务实现类
 *
 * @author KimZing
 * @since 2020-07-05
 */
@Service(protocol = "dubbo", timeout = 2000)
public class UserServiceImpl implements UserService {

    @Resource
    UserMapper userMapper;

    @Resource
    CarMapper carMapper;

    @Resource
    UserPublisher userPublisher;

    /**
     * 保存用户信息
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public UserBO save(UserSaveDTO userSaveDTO) {
        UserPO userPO = BeanUtil.mapperBean(userSaveDTO, UserPO.class);
        userMapper.insert(userPO);
        List<CarPO> carPOList = BeanUtil.mapperList(userSaveDTO.getCarList(), CarPO.class);
        carMapper.insertBatch(userPO.getId(), carPOList);

        // 发布用户创建消息
        UserCreateEvent userCreateEvent = BeanUtil.mapperBean(userPO, UserCreateEvent.class);
        userPublisher.publishUserCreateEvent(userCreateEvent);

        return BeanUtil.mapperBean(userPO, UserBO.class);
    }

    /**
     * 移除用户信息
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void remove(Integer id) {
        userMapper.delete(id);
        carMapper.deleteByUserId(id);
    }

    /**
     * 更新用户信息
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(UserUpdateDTO userUpdateDTO) {
        Integer userId = userUpdateDTO.getId();
        UserPO userPO = BeanUtil.mapperBean(userUpdateDTO, UserPO.class);
        userMapper.update(userPO);
        List<CarPO> carPOList = BeanUtil.mapperList(userUpdateDTO.getCarList(), CarPO.class);
        if (carPOList != null && !carPOList.isEmpty()) {
            carMapper.updateListByUserId(userId, carPOList);
        }
    }

    /**
     * 查询单个用户信息
     */
    @Override
    @Transactional(readOnly = true)
    public UserBO get(Integer id) {
        return userMapper.selectById(id);
    }

    /**
     * 分页条件查询用户信息
     */
    @Override
    @Transactional(readOnly = true)
    public PageResult<UserBO> listPage(UserQueryDTO userQueryDTO, PageParam pageParam) {
        IPage<UserBO> userBOPage = userMapper.selectPage(convertPage(pageParam), userQueryDTO);
        return convertPageResult(userBOPage);
    }

    /**
     * 扣除用户余额
     * @param userId
     * @param totalPrice
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean reduceAmount(Integer userId, BigDecimal totalPrice) {
        UserBO userBO = get(userId);
        if (userBO == null) {
            throw ExceptionManager.createByCode("USER_1008");
        }
        if (userBO.getAmount().compareTo(totalPrice) < 0) {
            throw ExceptionManager.createByCode("USER_1009");
        }
        Integer rows = userMapper.reduceAmount(userId, totalPrice);
        return rows > 0;
    }

}
