package com.lwhtarena.cg.utils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author liwh
 * @Title: ConvertUtils
 * @Package com.lwhtarena.cg.utils
 * @Description: 转换工具类
 * @Version 1.0.0
 * @date 2020/8/2 12:01
 */
public class ConvertUtils {
    /**
     * 输入流转换为xml字符串
     * @param inputStream
     * @return
     */
    public static String convertToString(InputStream inputStream) throws IOException {
        ByteArrayOutputStream outSteam = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int len = 0;
        while ((len = inputStream.read(buffer)) != -1) {
            outSteam.write(buffer, 0, len);
        }
        outSteam.close();
        inputStream.close();
        String result  = new String(outSteam.toByteArray(), "utf-8");
        return result;
    }
}
