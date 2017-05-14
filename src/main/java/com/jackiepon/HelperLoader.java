package com.jackiepon;

import com.jackiepon.helper.BeanHelper;
import com.jackiepon.helper.ClassHelper;
import com.jackiepon.helper.ControllerHelper;
import com.jackiepon.helper.IocHelper;
import com.jackiepon.util.ClassUtil;

/**
 * 框架初始化，加载相应的Helper类
 *
 * @author pengyk
 * @since  1.0.0
 *
 *
 * */
public final class HelperLoader {
    public static void init(){
        Class<?>[] classList = {ClassHelper.class, BeanHelper.class, IocHelper.class, ControllerHelper.class};
        for (Class<?> cls:classList) {
            ClassUtil.loadClass(cls.getName(),false);
        }
    }
}
