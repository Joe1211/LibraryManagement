package com.wonders.shixi.util;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;

/**
 * base64转换工具类
 * @author 邱家锦
 */
public class Base64Utils {
    /**
     * 读取流中的数据，转换为base64编码
     * @param input
     * @return
     * @throws IOException
     */
    public static String encode(InputStream input) throws IOException {
        byte[] imgData=new byte[input.available()];
        input.read(imgData);
        return Base64.getEncoder().encodeToString(imgData);
    }
}
