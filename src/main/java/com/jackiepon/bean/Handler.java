package com.jackiepon.bean;


import java.lang.reflect.Method;

/**
 * 封装Action信息
 *
 * @author pengyk
 * @since  1.0.0
 *
 *
 * */
public class Handler {

    /**
    * Controller 类
    * */
    private Class<?> controllerClass;

    /**
     * Action方法
     * */
    private Method actionMethod;

    public Handler(Class<?> controllerClass, Method actionMethod){
        this.controllerClass = controllerClass;
        this.actionMethod = actionMethod;
    }

    public Class<?> getControllerClass() {
        return controllerClass;
    }

    public Method getActionMethod() {
        return actionMethod;
    }
}
