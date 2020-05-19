package com.lwhtarena.mk.service;

import com.lwhtarena.mk.common.vo.UserVO;
import com.lwhtarena.mk.feign.UserService;
import com.lwhtarena.mk.util.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author liwh
 * @Title: UserDetailServiceImpl
 * @Package com.lwhtarena.mk.service
 * @Description:
 * @Version 1.0.0
 * @date 2020/5/19 21:34
 */
@Service("userDetailService")
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public UserDetailsImpl loadUserByUsername(String username) throws UsernameNotFoundException {
        UserVO userVo = userService.findUserByUsername(username);
        if (userVo == null) {
            throw new UsernameNotFoundException("用户名不存在或者密码错误");
        }
        return new UserDetailsImpl(userVo);
    }
}
