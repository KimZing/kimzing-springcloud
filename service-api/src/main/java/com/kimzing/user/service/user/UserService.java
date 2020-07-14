package com.kimzing.user.service.user;

import com.kimzing.user.domain.user.*;
import com.kimzing.utils.page.PageParam;
import com.kimzing.utils.page.PageResult;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

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
    UserBO save(UserSaveDTO userSaveDTO);

    /**
     * 移除用户信息
     */
    void remove(@NotNull(message = "USER_1005") Integer id);

    /**
     * 更新用户信息
     */
    void update(UserUpdateDTO userUpdateDTO);

    /**
     * 查询单个用户信息
     */
    UserBO get(@NotNull(message = "USER_1005") Integer id);

    /**
     * 分页条件查询用户信息
     */
    PageResult<UserBO> listPage(UserQueryDTO userQueryDTO, PageParam pageParam);

    /**
     * 扣除用户约
     * @param userId
     * @param totalPrice
     * @return
     */
    Boolean reduceAmount(Integer userId, BigDecimal totalPrice);
}
