package com.jackiepon.util;

import org.slf4j.Logger;

import java.io.*;

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
    * 从输入流中获取字符串
    * */
    public static String getString(InputStream is){
        StringBuilder sb = new StringBuilder();
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            String line;
            while ((line = reader.readLine())!=null){
                sb.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
            log.error("get string failure",e);
        }
        return sb.toString();
    }

}
