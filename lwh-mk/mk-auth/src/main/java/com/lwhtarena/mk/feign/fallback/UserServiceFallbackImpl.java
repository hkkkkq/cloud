package com.lwhtarena.mk.feign.fallback;

import com.lwhtarena.mk.common.vo.UserVO;
import com.lwhtarena.mk.feign.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author liwh
 * @Title: UserServiceFallbackImpl
 * @Package com.lwhtarena.mk.feign.fallback
 * @Description: 用户服务的fallback
 * @Version 1.0.0
 * @date 2020/5/19 21:36
 */
@Service
@Slf4j
public class UserServiceFallbackImpl implements UserService {

    @Override
    public UserVO findUserByUsername(String username) {
        log.error("调用{}异常:{}", "findUserByUsername", username);
        return null;
    }

    /**
     * 通过手机号查询用户、角色信息
     *
     * @param mobile 手机号
     * @return UserVo
     */
    @Override
    public UserVO findUserByMobile(String mobile) {
        log.error("调用{}异常:{}", "通过手机号查询用户", mobile);
        return null;
    }

    /**
     * 根据OpenId查询用户信息
     *
     * @param openId openId
     * @return UserVo
     */
    @Override
    public UserVO findUserByOpenId(String openId) {
        log.error("调用{}异常:{}", "通过OpenId查询用户", openId);
        return null;
    }
}
