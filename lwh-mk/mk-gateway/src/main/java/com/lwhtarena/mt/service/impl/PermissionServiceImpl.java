package com.lwhtarena.mt.service.impl;

import com.lwhtarena.mk.common.vo.MenuVO;
import com.lwhtarena.mt.feign.MenuService;
import com.lwhtarena.mt.service.PermissionService;
import com.xiaoleilu.hutool.collection.CollUtil;
import com.xiaoleilu.hutool.util.StrUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;
import org.springframework.util.AntPathMatcher;

import javax.servlet.http.HttpServletRequest;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @author liwh
 * @Title: PermissionServiceImpl
 * @Package com.lwhtarena.mt.service.impl
 * @Description:
 * @Version 1.0.0
 * @date 2020/5/19 20:17
 */
@Slf4j
@Service("permissionService")
public class PermissionServiceImpl implements PermissionService {
    @Autowired
    private MenuService menuService;

    private AntPathMatcher antPathMatcher = new AntPathMatcher();

    @Override
    public boolean hasPermission(HttpServletRequest request, Authentication authentication) {
        //ele-admin options 跨域配置，现在处理是通过前端配置代理，不使用这种方式，存在风险
//        if (HttpMethod.OPTIONS.name().equalsIgnoreCase(request.getMethod())) {
//            return true;
//        }
        Object principal = authentication.getPrincipal();
        List<SimpleGrantedAuthority> authorityList = (List<SimpleGrantedAuthority>) authentication.getAuthorities();
        AtomicBoolean hasPermission = new AtomicBoolean(false);

        if (principal != null) {
            if (CollUtil.isEmpty(authorityList)) {
                log.warn("角色列表为空：{}", authentication.getPrincipal());
                return false;
            }

            Set<MenuVO> urls = new HashSet<>();
            authorityList.stream().filter(authority ->
                    !StrUtil.equals(authority.getAuthority(), "ROLE_USER"))
                    .forEach(authority -> {
                        Set<MenuVO> menuVOSet = menuService.findMenuByRole(authority.getAuthority());
                        CollUtil.addAll(urls, menuVOSet);
                    });

            urls.stream().filter(menu -> StrUtil.isNotEmpty(menu.getUrl())
                    && antPathMatcher.match(menu.getUrl(), request.getRequestURI())
                    && request.getMethod().equalsIgnoreCase(menu.getMethod()))
                    .findFirst().ifPresent(menuVO -> hasPermission.set(true));
        }
        return hasPermission.get();
    }
}
