package com.jackiepon.helper;

import com.jackiepon.annotation.Controller;
import com.jackiepon.annotation.Service;
import com.jackiepon.constant.ConfigConstant;
import com.jackiepon.util.ClassUtil;
import com.jackiepon.util.PropsUtil;

import java.util.HashSet;
import java.util.Properties;
import java.util.Set;

/**
 * 类操作助手类
 *
 * @author pengyk
 * @since  1.0.0
 *
 *
 * */
public final class ClassHelper {
    /*
    * 定义类集合（用于存放所加载的类）
    * */
    private static final Set<Class<?>> CLASS_SET;

    static {
        String basePackage = ConfigHelper.getAppBasePackage();
        CLASS_SET = ClassUtil.getClassSet(basePackage);
    }

    /*
    * 获取应用包名下所有类
    * */
    public static  Set<Class<?>> getClassSet(){
        return CLASS_SET;
    }

    /*
    * 获取应用包名下所有Service类
    * */
    public static  Set<Class<?>> getServiceClassSet(){
        Set<Class<?>> classSet = new HashSet<Class<?>>();
        for (Class<?> cls: CLASS_SET) {
            if(cls.isAnnotationPresent(Service.class)){
                classSet.add(cls);
            }
        }
        return classSet;
    }

    /*
    * 获取应用包名下所有Controller类
    * */
    public static  Set<Class<?>> getControllerClassSet(){
        Set<Class<?>> classSet = new HashSet<Class<?>>();
        for (Class<?> cls: CLASS_SET) {
            if(cls.isAnnotationPresent(Controller.class)){
                classSet.add(cls);
            }
        }
        return classSet;
    }

    /*
    * 获取应用包名下所有Bean类(包括Service、Controller等)
    * */
    public static  Set<Class<?>> getBeanClassSet(){
        Set<Class<?>> beanClassSet = new HashSet<Class<?>>();
        beanClassSet.addAll(getControllerClassSet());
        beanClassSet.addAll(getServiceClassSet());
        return classSet;
    }

}
