package com.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.user.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;


public interface UserMapper extends BaseMapper<User> {
}
