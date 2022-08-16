package com.common.utils;

import org.springframework.beans.BeanUtils;

public class ExchangeUtils {
    /**
     *
     * @param e 要复制的对象信息
     * @param clazz 要赋值的实体类对象
     * @param <T>
     * @param <E>
     * @return
     * @throws IllegalAccessException
     * @throws InstantiationException
     */
    public static <T,E> T qoToEntity(E e, Class<T> clazz) throws IllegalAccessException, InstantiationException {
        T instance = clazz.newInstance();
        BeanUtils.copyProperties(e, instance);
        return instance;
    }
}
