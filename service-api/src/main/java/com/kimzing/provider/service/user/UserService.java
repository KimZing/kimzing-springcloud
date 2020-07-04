package com.kimzing.provider.service.user;

import com.kimzing.provider.domain.user.UserSaveDTO;
import com.kimzing.provider.domain.user.UserQueryDTO;
import com.kimzing.utils.page.PageParam;

import java.util.List;

/**
 * 用户服务.
 *
 * @author KimZing - kimzing@163.com
 * @since 2020/7/2 00:19
 */
public interface UserService {

    /**
     * 保存用户
     * @return
     */
    Integer save(UserSaveDTO userSaveDTO);

    /**
     * 移除用户
     * @return
     */
    Integer remove(Integer id);

    /**
     * 更新用户
     * @return
     */
    Integer update(UserSaveDTO userSaveDTO);

    /**
     * 通过ID查询单个用户
     * @return
     */
    UserSaveDTO get(Integer id);

    /**
     * 分页查询用户
     * @param userQueryDTO
     * @param pageParam
     * @return
     */
    List<UserSaveDTO> list(UserQueryDTO userQueryDTO, PageParam pageParam);

}
