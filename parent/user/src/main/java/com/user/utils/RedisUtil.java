package com.user.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class RedisUtil {

    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 读取缓存
     */
    public  Object getValue(final String key){
        return redisTemplate.opsForValue().get(key);
    }

    /**
     * 写入缓存
     */
    public boolean setValue(String key,Object value){
        boolean result = false;
        try {
            redisTemplate.opsForValue().set(key,value,1, TimeUnit.DAYS);
            result = true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 修改内存
     * @param key
     * @param value
     * @return
     */
    public boolean getAndSet(String key, Object value){
        boolean result = false;
        try {
            redisTemplate.opsForValue().getAndSet(key,value);
            result = true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 删除缓存 */
    public boolean delete(final String key) {
        boolean result = false;
        try {
            redisTemplate.delete(key);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

}
