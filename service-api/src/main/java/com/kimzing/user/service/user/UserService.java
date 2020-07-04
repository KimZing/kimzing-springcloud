package com.kimzing.user.service.user;

import com.kimzing.user.domain.user.UserBO;
import com.kimzing.user.domain.user.UserQueryDTO;
import com.kimzing.user.domain.user.UserSaveDTO;
import com.kimzing.user.domain.user.UserUpdateDTO;
import com.kimzing.utils.page.PageParam;
import com.kimzing.utils.page.PageResult;

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
    void save(UserSaveDTO userSaveDTO);

    /**
     * 移除用户
     * @return
     */
    void remove(Integer id);

    /**
     * 更新用户
     * @return
     */
    void update(UserUpdateDTO userUpdateDTO);

    /**
     * 通过用户ID查询单个用户
     * @return
     */
    UserBO get(Integer id);

    /**
     * 分页查询用户
     * @param userQueryDTO
     * @param pageParam
     * @return
     */
    PageResult<UserBO> listPage(UserQueryDTO userQueryDTO, PageParam pageParam);

}
