package com.kimzing.user.repository.user;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.kimzing.user.domain.user.UserPO;
import org.apache.ibatis.annotations.Mapper;

/**
 * .
 *
 * @author KimZing - kimzing@163.com
 * @since 2020/7/1 19:58
 */
@Mapper
public interface UserMapper extends BaseMapper<UserPO> {

}
