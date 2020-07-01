package com.kimzing.provider.user;

import com.kimzing.provider.user.vo.PageParam;
import com.kimzing.provider.user.dto.UserDTO;
import com.kimzing.provider.user.dto.UserQueryDTO;

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
    Integer save(UserDTO userDTO);

    /**
     * 移除用户
     * @return
     */
    Integer remove(Integer id);

    /**
     * 更新用户
     * @return
     */
    Integer update(UserDTO userDTO);

    /**
     * 通过ID查询单个用户
     * @return
     */
    UserDTO get(Integer id);

    /**
     * 分页查询用户
     * @param userQueryDTO
     * @param pageParam
     * @return
     */
    List<UserDTO> list(UserQueryDTO userQueryDTO, PageParam pageParam);

}
