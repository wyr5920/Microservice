package com.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.common.utils.ExchangeUtils;
import com.user.entity.Authorities;
import com.user.entity.User;
import com.user.entity.UserAuthorities;
import com.user.entity.UserAuthoritiesInfo;
import com.user.mapper.AuthoritiesMapper;
import com.user.mapper.UserAuthoritiesMapper;
import com.user.mapper.UserMapper;
import com.user.service.IUserService;
import com.user.utils.RedisUtil;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Resource
    private UserMapper userMapper;

    @Resource
    private UserAuthoritiesMapper userAuthoritiesMapper;

    @Resource
    private AuthoritiesMapper authoritiesMapper;

    @Resource
    private RedisUtil redisUtil;

    @SneakyThrows
    @Override
    public UserAuthoritiesInfo getPermissionInfo(String index) {
        UserAuthoritiesInfo info = null;
        LambdaQueryWrapper<User> userQueryWrapper = new LambdaQueryWrapper<User>();
        userQueryWrapper.eq(User::getUserName,index).or().eq(User::getPhone,index).or().eq(User::getEMail,index);
        User user = userMapper.selectOne(userQueryWrapper);
        if (user != null) {
            try {
                info = ExchangeUtils.qoToEntity(user, UserAuthoritiesInfo.class);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            assert info != null;
            info.setPermissionList(findByPermissionId(user));
        }
        return info;
    }

    @Override
    public void register(String key,String value) {
        redisUtil.setValue(key,value);
    }

    @Override
    public String getRedisValue(String key) {
        return (String) redisUtil.getValue(key);
    }

    public List<Authorities> findByPermissionId(User user){
        List<UserAuthorities> list =
                userAuthoritiesMapper.selectList(
                        new LambdaQueryWrapper<UserAuthorities>()
                                .eq(UserAuthorities::getUserId, user.getId()));
        if(list.size() > 0){
            List<Long> permissionIds = new ArrayList<>();
            for(UserAuthorities userAuthorities : list){
                permissionIds.add(userAuthorities.getAuthoritiesId());
            }
            return authoritiesMapper.selectList(new LambdaQueryWrapper<Authorities>().in(Authorities::getId,permissionIds));
        }
        return null;
    }
}
