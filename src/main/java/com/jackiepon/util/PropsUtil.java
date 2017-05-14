package com.jackiepon.util;

import org.apache.commons.lang3.StringUtils;

import java.io.*;
import java.util.Properties;

/**
 * 
 * <p>
 * description: 配置文件操作类
 * </p>
 * 
 * @author Pengyk
 * @since 2016年10月10日
 * @see
 */
public class PropsUtil {


    public static final Properties loadApplication(String config_file_name) {
        Properties properties = new Properties();
        try {
            InputStream inStream = new FileInputStream(new File(config_file_name));
            properties.load(inStream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }

    public static String getApplicationValue(Properties properties,String key) {
        return getApplicationValue(properties,key,"");
    }
    
    public static String getApplicationValue(Properties properties,String key,String defaul) {

        if (properties == null) {
            loadApplication("smart.properties");
        }
        Object value = properties.getProperty(key, defaul);
        if (StringUtils.isEmpty((CharSequence) value)) {
            System.err.println("cannot find the property of " + key + " in the file:" + " application.properties");
            return defaul;
        } else {
            return value.toString().trim();
        }
    }
    
}
