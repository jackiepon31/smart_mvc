package com.jackiepon.helper;

import com.jackiepon.constant.ConfigConstant;
import com.jackiepon.util.PropsUtil;

import java.util.Properties;

/**
 * 属性文件助手类
 *
 * @author pengyk
 * @since  1.0.0
 *
 *
 * */
public final class ConfigHelper {
    private static final Properties CONFIG_PROPS = PropsUtil.loadApplication(ConfigConstant.CONFIG_FILE);

    /**
     * 获取JDBC驱动
     * */
    public static String getJdbcDriver(){
        return PropsUtil.getApplicationValue(CONFIG_PROPS,ConfigConstant.JDBC_DRIVER);
    }

    /**
     * 获取JDBC URL
     * */
    public static String getJdbcUrl(){
        return PropsUtil.getApplicationValue(CONFIG_PROPS,ConfigConstant.JDBC_URL);
    }

    /**
     * 获取JDBC用户名
     * */
    public static String getJdbcUsername(){
        return PropsUtil.getApplicationValue(CONFIG_PROPS,ConfigConstant.JDBC_USERNAME);
    }

    /**
     * 获取JDBC 密码
     * */
    public static String getJdbcPassword(){
        return PropsUtil.getApplicationValue(CONFIG_PROPS,ConfigConstant.JDBC_PASSWORD);
    }

    /**
     * 获取基本包路径
     * */
    public static String getAppBasePackage(){
        return PropsUtil.getApplicationValue(CONFIG_PROPS,ConfigConstant.APP_BASE_PACKAGE);
    }

    /**
     * 获取JSP文件路径
     * */
    public static String getAppJspPath(){
        return PropsUtil.getApplicationValue(CONFIG_PROPS,ConfigConstant.APP_JSP_PATH);
    }

    /**
     * 获取资源文件路径
     * */
    public static String getAppAssertpath(){
        return PropsUtil.getApplicationValue(CONFIG_PROPS,ConfigConstant.APP_ASSET_PATH);
    }
}
