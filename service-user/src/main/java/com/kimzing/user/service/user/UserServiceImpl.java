package com.kimzing.user.service.user;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.kimzing.user.domain.car.CarPO;
import com.kimzing.user.domain.user.*;
import com.kimzing.user.repository.car.CarMapper;
import com.kimzing.user.repository.user.UserMapper;
import com.kimzing.utils.bean.BeanUtil;
import com.kimzing.utils.page.PageParam;
import com.kimzing.utils.page.PageResult;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * 用户服务实现.
 *
 * @author KimZing - kimzing@163.com
 * @since 2020/7/2 00:59
 */
@Service(protocol = "dubbo", version = "1.0.0", timeout = 2000)
public class UserServiceImpl implements UserService {

    @Resource
    UserMapper userMapper;

    @Resource
    CarMapper carMapper;

    /**
     * 保存用户信息
     * @param userSaveDTO
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(UserSaveDTO userSaveDTO) {
        UserPO userPO = BeanUtil.mapperBean(userSaveDTO, UserPO.class);
        Integer userId = userMapper.insert(userPO);
        List<CarPO> carPOList = BeanUtil.mapperList(userSaveDTO.getCars(), CarPO.class);
        carMapper.insertCarList(userId, carPOList);
    }

    /**
     * 移除用户信息
     * @param id
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void remove(Integer id) {
        userMapper.delete(id);
        carMapper.deleteByUserId(id);
    }

    /**
     * 更新用户信息
     * @param userUpdateDTO
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(UserUpdateDTO userUpdateDTO) {
        Integer userId = userUpdateDTO.getId();
        UserPO userPO = BeanUtil.mapperBean(userUpdateDTO, UserPO.class);
        userMapper.updateById(userPO);
        List<CarPO> carPOList = BeanUtil.mapperList(userUpdateDTO.getCars(), CarPO.class);
        if ( carPOList != null && !carPOList.isEmpty()) {
            carMapper.updateCarListByUserId(userId, carPOList);
        }
    }

    /**
     * 根据ID获取用户信息
     * @param id
     * @return
     */
    @Override
    @Transactional(readOnly = true)
    public UserBO get(Integer id) {
        return userMapper.select(id);
    }

    /**
     * 分页并根据条件获取用户信息
     * @param userQueryDTO
     * @param pageParam
     * @return
     */
    @Override
    @Transactional(readOnly = true)
    public PageResult<UserBO> listPage(UserQueryDTO userQueryDTO, PageParam pageParam) {
        IPage<UserBO> userBOPage =
                userMapper.selectPage(pageParam, userQueryDTO);
        return new PageResult<>(userBOPage.getTotal(), pageParam.getPageNum(),
                pageParam.getPageSize(), userBOPage.getRecords());
    }

}
