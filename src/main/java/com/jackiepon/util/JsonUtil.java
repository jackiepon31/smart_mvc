package com.jackiepon.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * 
 * <p>
 * description:Json工具类
 * </p>
 * 
 * @author Pengyk
 * @since 2016年10月10日
 * @see
 */
public class JsonUtil {

    private static final Logger log = org.slf4j.LoggerFactory.getLogger(JsonUtil.class);
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    /*
    * 将POJO转为JSON
    * */
    public static <T>String toJson(T obj){
        String json = "";
        try {
            json = OBJECT_MAPPER.writeValueAsString(obj);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("convert POJO to JSON failure",e);
        }
        return json;
    }

    /*
    * 将JSON转为POJO
    * */
    @SuppressWarnings("unused")
    public static<T> T fromJson(String json, Class<T> type){
        T pojo = null;
        try {
            pojo = OBJECT_MAPPER.readValue(json,type);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("convert JSON to POJO failure",e);
        }
        return pojo;
    }
}
