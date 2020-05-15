package com.lwhtarena.nl.utils.common;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/**
 * @author liwh
 * @Title: Base64Utils
 * @Package com.lwhtarena.nl.utils.common
 * @Description: Base64Utils
 * @Version 1.0.0
 * @date 2020/5/15 08:48
 */
public class Base64Utils {
    /**
     * 解码
     * @param base64
     * @return
     */
    public static byte[] decode(String base64){
        BASE64Decoder decoder = new BASE64Decoder();
        try {
            // Base64解码
            byte[] b = decoder.decodeBuffer(base64);
            for (int i = 0; i < b.length; ++i) {
                /**调整异常数据**/
                if (b[i] < 0) {
                    b[i] += 256;
                }
            }
            return b;
        } catch (Exception e) {
            return null;
        }
    }


    /**
     * 编码
     * @param data
     * @return
     * @throws Exception
     */
    public static String encode(byte[] data) {
        BASE64Encoder encoder = new BASE64Encoder();
        return encoder.encode(data);
    }
}
