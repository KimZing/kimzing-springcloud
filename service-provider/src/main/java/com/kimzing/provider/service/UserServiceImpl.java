package com.kimzing.provider.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.kimzing.provider.entity.user.UserEntity;
import com.kimzing.provider.mapper.user.UserMapper;
import com.kimzing.provider.user.UserService;
import com.kimzing.provider.user.dto.UserDTO;
import com.kimzing.provider.user.dto.UserQueryDTO;
import com.kimzing.provider.user.vo.PageParam;
import com.kimzing.utils.bean.BeanUtil;
import org.apache.dubbo.config.annotation.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 用户服务实现.
 *
 * @author KimZing - kimzing@163.com
 * @since 2020/7/2 00:59
 */
@Service(protocol = "dubbo", version = "1.0.0", timeout = 1000)
public class UserServiceImpl implements UserService {

    @Resource
    UserMapper userMapper;

    @Override
    public Integer save(UserDTO userDTO) {
        return userMapper.insert(BeanUtil.mapperBean(userDTO, UserEntity.class));
    }

    @Override
    public Integer remove(Integer id) {
        return userMapper.deleteById(id);
    }

    @Override
    public Integer update(UserDTO userDTO) {
        return userMapper.updateById(BeanUtil.mapperBean(userDTO, UserEntity.class));
    }

    @Override
    public UserDTO get(Integer id) {
        UserEntity userEntity = userMapper.selectById(id);
        return BeanUtil.mapperBean(userEntity, UserDTO.class);
    }

    //TODO 替换为公共包
    @Override
    public List<UserDTO> list(UserQueryDTO userQueryDTO, PageParam pageParam) {
        IPage<UserEntity> userEntityIPage =
                userMapper.selectPage(new Page<>(pageParam.getPageNum(), pageParam.getPageSize()), null);
        return BeanUtil.mapperList(userEntityIPage.getRecords(), UserDTO.class);
    }

}
