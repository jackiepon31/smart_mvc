package com.jackiepon.util;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.log4j.spi.LoggerFactory;
import org.slf4j.Logger;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * 
 * <p>
 * description: 编码与解码操作工具类
 * </p>
 * 
 * @author Pengyk
 * @since 2016年10月10日
 * @see
 */
public class CodecUtil {

    private static final Logger log = org.slf4j.LoggerFactory.getLogger(CodecUtil.class);

    /*
    * 将URL编码
    * */
    public static String encodeURL(String source){
        String target = "";
        try {
            target = URLEncoder.encode(source,"UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            log.error("encode url failure",e);
        }
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
