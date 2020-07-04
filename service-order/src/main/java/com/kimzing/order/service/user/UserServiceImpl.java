package com.kimzing.order.service.user;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.kimzing.order.repository.user.UserMapper;
import com.kimzing.provider.domain.user.UserSaveDTO;
import com.kimzing.order.domain.user.UserPO;
import com.kimzing.provider.domain.user.UserQueryDTO;
import com.kimzing.provider.service.user.UserService;
import com.kimzing.utils.bean.BeanUtil;
import com.kimzing.utils.page.PageParam;
import org.apache.dubbo.config.annotation.Service;

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

    @Override
    public Integer save(UserSaveDTO userSaveDTO) {
        return userMapper.insert(BeanUtil.mapperBean(userSaveDTO, UserPO.class));
    }

    @Override
    public Integer remove(Integer id) {
        return userMapper.deleteById(id);
    }

    @Override
    public Integer update(UserSaveDTO userSaveDTO) {
        return userMapper.updateById(BeanUtil.mapperBean(userSaveDTO, UserPO.class));
    }

    @Override
    public UserSaveDTO get(Integer id) {
        UserPO userPO = userMapper.selectById(id);
        return BeanUtil.mapperBean(userPO, UserSaveDTO.class);
    }

    //TODO 替换为公共包
    @Override
    public List<UserSaveDTO> list(UserQueryDTO userQueryDTO, PageParam pageParam) {
        IPage<UserPO> userEntityIPage =
                userMapper.selectPage(new Page<>(pageParam.getPageNum(), pageParam.getPageSize()), null);
        return BeanUtil.mapperList(userEntityIPage.getRecords(), UserSaveDTO.class);
    }

}
