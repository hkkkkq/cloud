package com.lwhtarena.mk.common.util;

import com.lwhtarena.mk.common.constant.CommonConstant;
import com.lwhtarena.mk.common.util.exception.CheckedException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.codec.Base64;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author liwh
 * @Title: AuthUtils
 * @Package com.lwhtarena.mk.common.util
 * @Description: 认证授权相关工具类
 * @Version 1.0.0
 * @date 2020/5/19 18:09
 */
@Slf4j
public class AuthUtils {
    private static final String BASIC_ = "Basic ";

    /**
     * 从header 请求中的clientId/clientsecect
     *
     * @param header header中的参数
     * @throws CheckedException if the Basic header is not present or is not valid
     *                          Base64
     */
    public static String[] extractAndDecodeHeader(String header)
            throws IOException {

        byte[] base64Token = header.substring(6).getBytes("UTF-8");
        byte[] decoded;
        try {
            decoded = Base64.decode(base64Token);
        } catch (IllegalArgumentException e) {
            throw new CheckedException(
                    "Failed to decode basic authentication token");
        }

        String token = new String(decoded, CommonConstant.UTF8);

        int delim = token.indexOf(":");

        if (delim == -1) {
            throw new CheckedException("Invalid basic authentication token");
        }
        return new String[]{token.substring(0, delim), token.substring(delim + 1)};
    }

    /**
     * *从header 请求中的clientId/clientsecect
     *
     * @param request
     * @return
     * @throws IOException
     */
    public static String[] extractAndDecodeHeader(HttpServletRequest request)
            throws IOException {
        String header = request.getHeader("Authorization");

        if (header == null || !header.startsWith(BASIC_)) {
            throw new CheckedException("请求头中client信息为空");
        }

        return extractAndDecodeHeader(header);
    }
}
