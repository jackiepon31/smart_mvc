package com.jackiepon.util;

import org.slf4j.Logger;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * 
 * <p>
 * description: 流操作工具类
 * </p>
 * 
 * @author Pengyk
 * @since 2016年10月10日
 * @see
 */
public class StreamUtil {

    private static final Logger log = org.slf4j.LoggerFactory.getLogger(StreamUtil.class);

    /*
    * 将URL编码
    * */
    public static String getString(InputStream is){
        StringBuilder sb = new StringBuilder();
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        String line;
        while ((line = reader.readLine()!=null))
        return target;
    }

    /*
    * 将URL解码
    * */
    public static String decodeURL(String source){
        String target = "";
        try {
            target = URLDecoder.decode(source,"UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            log.error("decode url failure",e);
        }
        return target;
    }
}
