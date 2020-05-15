package com.lwhtarena.nl.utils.common;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * @author liwh
 * @Title: FileUtils
 * @Package com.lwhtarena.nl.utils.common
 * @Description:
 * @Version 1.0.0
 * @date 2020/5/15 08:53
 */
public class FileUtils {
    /**
     * 重资源流中读取第一行内容
     * @param in
     * @return
     * @throws IOException
     */
    public static String readFristLineFormResource(InputStream in) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(in));
        return br.readLine();
    }
}
