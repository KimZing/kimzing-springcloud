package com.kimzing.user.service.user;

import com.kimzing.user.domain.user.*;
import com.kimzing.utils.page.PageParam;
import com.kimzing.utils.page.PageResult;

import javax.validation.constraints.NotNull;

/**
 * 用户信息 服务接口
 *
 * @author KimZing
 * @since 2020-07-05
 */
public interface UserService {

    /**
     * 保存用户信息
     */
    void save(UserSaveDTO userSaveDTO);

    /**
     * 移除用户信息
     */
    void remove(@NotNull(message = "用户信息ID不能为空") Integer id);

    /**
     * 更新用户信息
     */
    void update(UserUpdateDTO userUpdateDTO);

    /**
     * 查询单个用户信息
     */
    UserBO get(@NotNull(message = "用户信息ID不能为空") Integer id);

    /**
     * 分页条件查询用户信息
     */
    PageResult<UserBO> listPage(UserQueryDTO userQueryDTO, PageParam pageParam);
}
