package com.jackiepon.bean;

import java.util.Map;

/**
 * 请求参数对象
 *
 * @author pengyk
 * @since  1.0.0
 *
 *
 * */
public class Param {

    private Map<String,Object> paramMap;

    public Param(Map<String,Object> paramMap){
        this.paramMap = paramMap;
    }

    /**
     *
     * 根据参数名获取long型参数值
     * */
    public long getLong(String name){
        return Long.parseLong(name);
    }

    /**
     * 获取所有字段信息
     * */
    public  Map<String,Object> getMap(){
        return paramMap;
    }
}
