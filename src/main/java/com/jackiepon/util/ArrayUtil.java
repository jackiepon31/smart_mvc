package com.jackiepon.util;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.*;
import java.util.Properties;

/**
 * 
 * <p>
 * description: 数组工具类
 * </p>
 * 
 * @author Pengyk
 * @since 2016年10月10日
 * @see
 */
public class ArrayUtil {

    /*
    * 判断数组是否非空
    * */
    public static boolean isNotEmpty(Object[] array){
        return !ArrayUtils.isEmpty(array);
    }

    /*
    * 判断数组是否空
    * */
    public static boolean isEmpty(Object[] array){
        return ArrayUtils.isEmpty(array);
    }
}
