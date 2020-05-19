package com.lwhtarena.mt.service;


import org.springframework.security.core.Authentication;

import javax.servlet.http.HttpServletRequest;

/**
 * @author liwh
 * @Title: PermissionService
 * @Package com.lwhtarena.mt.service
 * @Description:
 * @Version 1.0.0
 * @date 2020/5/19 20:11
 */
public interface PermissionService {
    /**
     * 判断请求是否有权限
     *
     * @param request        HttpServletRequest
     * @param authentication 认证信息
     * @return 是否有权限
     */
    boolean hasPermission(HttpServletRequest request, Authentication authentication);
}
