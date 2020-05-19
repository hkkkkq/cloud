package com.lwhtarena.mt.feign.fallback;

import com.lwhtarena.mk.common.vo.MenuVO;
import com.lwhtarena.mt.feign.MenuService;
import com.xiaoleilu.hutool.collection.CollUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * @author liwh
 * @Title: MenuServiceFallbackImpl
 * @Package com.lwhtarena.mt.feign.fallback
 * @Description:
 * @Version 1.0.0
 * @date 2020/5/19 20:21
 */
@Slf4j
@Service
public class MenuServiceFallbackImpl implements MenuService {
    @Override
    public Set<MenuVO> findMenuByRole(String role) {
        log.error("调用{}异常{}","findMenuByRole",role);
        return CollUtil.newHashSet();
    }
}
