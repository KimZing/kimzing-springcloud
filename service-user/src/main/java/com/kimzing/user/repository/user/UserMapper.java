package com.kimzing.user.repository.user;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.kimzing.user.domain.user.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 用户信息 Mapper 接口
 *
 * @author KimZing
 * @since 2020-07-05
 */
@Mapper
public interface UserMapper {

    /**
     * 保存用户信息
     */
    Integer insert(UserPO userPO);

    /**
     * 删除用户信息
     */
    void delete(Integer id);

    /**
     * 根据ID更新用户信息
     */
    void update(UserPO userPO);

    /**
     * 根据ID查询用户信息
     */
    UserBO selectById(Integer id);

    /**
     * 条件分页查询用户信息
     */
    IPage<UserBO> selectPage(Page<UserBO> page, @Param("query") UserQueryDTO userQueryDTO);

}
