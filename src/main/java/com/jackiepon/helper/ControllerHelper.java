package com.jackiepon.helper;

import com.jackiepon.annotation.Action;
import com.jackiepon.bean.Handler;
import com.jackiepon.bean.Request;
import com.jackiepon.util.ArrayUtil;
import org.apache.commons.collections4.CollectionUtils;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 控制器助手类
 *
 * @author pengyk
 * @since  1.0.0
 *
 *
 * */
public final class ControllerHelper {

    /**
     * 用于存放请求与处理器的映射关系（ActionMap For Short）
     * */
    private static final Map<Request,Handler>  ACTION_MAP = new HashMap<Request,Handler>();

    static
    {
        //获取所有的Controller类
        Set<Class<?>> controllerClassSet = ClassHelper.getControllerClassSet();
        if(CollectionUtils.isNotEmpty(controllerClassSet)){
            //遍历这些controller类
            for (Class<?> controllerClass: controllerClassSet) {
                //获取controller类中定义的方法
                Method[] methods = controllerClass.getDeclaredMethods();
                for (Method method: methods) {
                    //遍历这些方法，判断是否有Action注解
                    if(method.isAnnotationPresent(Action.class)){
                        //从Action注解中获取URL映射规则
                        Action action = method.getAnnotation(Action.class);
                        String mapping = action.value();
                        //验证URL映射规则
                        if(mapping.matches("\\w+:/\\w*")){
                            String[] array = mapping.split(":");
                            if(ArrayUtil.isNotEmpty(array) && array.length ==2){
                                //获取请求方法与请求路径
                                String requestMethod = array[0];
                                String requestPath = array[1];
                                Request request = new Request(requestMethod,requestPath);
                                Handler handler = new Handler(controllerClass,method);
                                //初始化Action Map
                                ACTION_MAP.put(request,handler);
                            }
                        }

                    }
                }
            }
        }
    }

    /**
     * 获取Handler
     * */
    public static Handler getHandler(String requestMethod,String requestPath){
        Request request = new Request(requestMethod,requestPath);
        return ACTION_MAP.get(request);
    }
}
