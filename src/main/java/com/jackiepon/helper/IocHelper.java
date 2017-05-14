package com.jackiepon.helper;

import com.jackiepon.annotation.Inject;
import com.jackiepon.util.ArrayUtil;
import com.jackiepon.util.ReflectionUtil;
import org.apache.commons.collections4.CollectionUtils;
import java.lang.reflect.Field;
import java.util.Collection;
import java.util.Map;

/**
 * 依赖注入助手类
 *
 * @author pengyk
 * @since  1.0.0
 *
 *
 * */
public final class IocHelper {


    static {
        //获取所有Bean类和Bean实例之间的映射关系（BeanMap for short）
        Map<Class<?>,Object> beanMap = BeanHelper.getBeanMap();
        if(CollectionUtils.isNotEmpty((Collection<?>) beanMap)){
            //遍历BeanMap
            for (Map.Entry<Class<?>, Object> beanEntity:beanMap.entrySet()) {
                //从BeanMap中获取Bean类与Bean实例
                Class<?> beanClass = beanEntity.getKey();
                Object beanInstance = beanEntity.getValue();
                //获取Bean类定义的所有成员变量
                Field[] beanFields = beanClass.getDeclaredFields();
                if(ArrayUtil.isNotEmpty(beanFields)){
                    //遍历成员
                    for (Field field: beanFields) {
                        //判断当前Field是否带有Inject注解
                        if(field.isAnnotationPresent(Inject.class)){
                            //在BeanMap中获取Field对应的实例
                            Class<?> beanFieldClass = field.getType();
                            Object beanFieldInstance = beanMap.get(beanFieldClass);
                            if(beanFieldInstance != null){
                                //通过反射初始化BeanField的值
                                ReflectionUtil.setField(beanInstance,field,beanFieldInstance);
                            }
                        }

                    }
                }
            }
        }
    }

}
