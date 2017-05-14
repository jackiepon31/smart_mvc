package com.jackiepon.util;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.JarURLConnection;
import java.net.URL;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Set;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/**
 * 反射工具类
 *
 * @author pengyk
 * @since  1.0.0
 *
 *
 * */
public final class ReflectionUtil {

    private static final Logger log = LoggerFactory.getLogger(ReflectionUtil.class);

    /**
     *创建实例
     * */
    public static Object newInstance(Class<?> cls){
        Object instance = null;
        try {
            instance = cls.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return instance;
    }

    /**
     *调用方法
     * */
    public static Object invokeMethod(Object obj, Method method, Object...args){
        Object result = null;
        try {
            method.setAccessible(true);
            result = method.invoke(obj,args);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("invoke method failure",e);
        }
        return result;
    }

    /**
     *设置成员变量的值
     * */
    public static void setField(Object obj, Field field, Object value){
        try {
           field.setAccessible(true);
           field.set(obj,value);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("set field failure",e);
        }
    }
}
