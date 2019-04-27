package com.mj.mybatis.plus.demo01.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mj.mybatis.plus.demo01.user.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper extends BaseMapper<User> {
}
