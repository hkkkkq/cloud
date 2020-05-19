package com.lwhtarena.mk.common.web;

import com.lwhtarena.mk.common.util.UserUtils;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author liwh
 * @Title: BaseController
 * @Package com.lwhtarena.mk.common.web
 * @Description:
 * @Version 1.0.0
 * @date 2020/5/19 17:55
 */
public class BaseController {

    @Autowired
    private HttpServletRequest request;

    protected org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(this.getClass());

    /**
     * 根据请求heard中的token获取用户角色
     *
     * @return 角色名
     */
    public List<String> getRole() {
        return UserUtils.getRole(request);
    }

    /**
     * 根据请求heard中的token获取用户ID
     *
     * @return 用户ID
     */
    public Integer getUserId() {
        return UserUtils.getUserId(request);
    }
}
