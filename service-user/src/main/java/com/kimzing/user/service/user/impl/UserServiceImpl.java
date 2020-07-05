package com.kimzing.user.service.user.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.kimzing.user.domain.car.CarPO;
import com.kimzing.user.domain.user.*;
import com.kimzing.user.listener.user.event.UserCreatedEvent;
import com.kimzing.user.repository.car.CarMapper;
import com.kimzing.user.repository.user.UserMapper;
import com.kimzing.user.service.user.UserService;
import com.kimzing.utils.bean.BeanUtil;
import com.kimzing.utils.page.PageParam;
import com.kimzing.utils.page.PageResult;
import com.kimzing.utils.spring.SpringContextUtil;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

import static com.kimzing.utils.page.MPPageUtil.convertPage;
import static com.kimzing.utils.page.MPPageUtil.convertPageResult;

/**
 * 用户信息 服务实现类
 * <p>
 *     如果编写version版本号，调用方同样需要制定版本号
 * </p>
 * @author KimZing
 * @since 2020-07-05
 */
@Service(protocol = "dubbo", timeout = 2000)
public class UserServiceImpl implements UserService {

    @Resource
    UserMapper userMapper;

    @Resource
    CarMapper carMapper;

    /**
     * 保存用户信息
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(UserSaveDTO userSaveDTO) {
        UserPO userPO = BeanUtil.mapperBean(userSaveDTO, UserPO.class);
        Integer userId = userMapper.insert(userPO);
        List<CarPO> carPOList = BeanUtil.mapperList(userSaveDTO.getCarList(), CarPO.class);
        carMapper.insertList(userId, carPOList);

        // 发布创建事件
        SpringContextUtil.getApplicationContext()
                .publishEvent(new UserCreatedEvent()
                        .setId(userId)
                        .setUsername(userPO.getUsername()));
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
        return userMapper.select(id);
    }

    /**
     * 分页条件查询用户信息
     */
    @Override
    @Transactional(readOnly = true)
    public PageResult<UserBO> listPage(UserQueryDTO userQueryDTO, PageParam pageParam) {
        // MARK Page对象必须放在第一个
        IPage<UserBO> userBOPage = userMapper.selectPage(convertPage(pageParam), userQueryDTO);
        return convertPageResult(userBOPage);
    }

}
