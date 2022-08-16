package com.user.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.user.entity.User;
import com.user.entity.UserAuthoritiesInfo;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author wu_yr
 * @since 2022-07-08
 */
public interface IUserService extends IService<User> {

    /**
     * 根据用户名、联系方式、邮箱查找权限信息
     * @param index
     */
    UserAuthoritiesInfo getPermissionInfo(String index);


    /**
     * redis操作
     * @param
     * @return
     */
    void register(String key,String value);

    String getRedisValue(String key);
}
