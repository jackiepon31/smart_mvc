package com.jackiepon.helper;

import com.jackiepon.annotation.Controller;
import com.jackiepon.annotation.Service;
import com.jackiepon.util.ClassUtil;
import com.jackiepon.util.ReflectionUtil;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Bean助手类
 *
 * @author pengyk
 * @since  1.0.0
 *
 *
 * */
public final class BeanHelper {
    /*
    * 定义Bean映射（用于存放Bean类与Bean实例的映射关系）
    * */
    private static final Map<Class<?>,Object> BEAN_MAP = new HashMap<Class<?>,Object>();

    static {
       Set<Class<?>> beanClassSet = ClassHelper.getBeanClassSet();
        for (Class<?> beanClass: beanClassSet ) {
            Object obj = ReflectionUtil.newInstance(beanClass);
            BEAN_MAP.put(beanClass,obj);
        }
    }

    /*
    * 获取Bean映射
    * */
    public static Map<Class<?>,Object> getBeanMap(){
        return BEAN_MAP;
    }

    /*
    * 获取Bean实例
    * */
    public static  <T>T getBean(Class<T> cls){
        if (!BEAN_MAP.containsKey(cls)){
            throw new RuntimeException("cannot get bean by class");
        }
        return (T)BEAN_MAP.get(cls);
    }

}
