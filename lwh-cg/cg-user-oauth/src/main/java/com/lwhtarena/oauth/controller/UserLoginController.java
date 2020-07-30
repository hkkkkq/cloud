package com.lwhtarena.oauth.controller;

import com.lwhtarena.cg.vo.Result;
import com.lwhtarena.cg.constants.StatusCode;
import com.lwhtarena.oauth.service.LoginService;
import com.lwhtarena.oauth.util.AuthToken;
import com.lwhtarena.oauth.util.CookieUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * @author liwh
 * @Title: UserLoginController
 * @Package com.lwhtarena.oauth.controller
 * @Description:
 * @Version 1.0.0
 * @date 2020/7/17 10:03
 */
@RestController
@RequestMapping("/user")
public class UserLoginController {

    @Autowired
    private LoginService loginService;

    @Value("${auth.clientId}")
    private String clientId;

    @Value("${auth.clientSecret}")
    private String clientSecret;

    /**授权模式 密码模式**/
    private static final String GRAND_TYPE = "password";


    @Value("${auth.cookieDomain}")
    private String cookieDomain;

    /**Cookie生命周期**/
    @Value("${auth.cookieMaxAge}")
    private int cookieMaxAge;


    /**
     * 密码模式认证.
     *
     * @param username
     * @param password
     * @return
     */
    @RequestMapping("/login")
    public Result<Map> login(String username, String password) {
        if(StringUtils.isEmpty(username)){
            throw new RuntimeException("用户名不允许为空！");
        }
        if(StringUtils.isEmpty(password)){
            throw new RuntimeException("密码不允许为空");
        }

        /**登录 之后生成令牌的数据返回-->申请令牌**/
        AuthToken authToken = loginService.login(username, password, clientId, clientSecret, GRAND_TYPE);

        /**设置到cookie中**/
        saveCookie(authToken.getAccessToken());
        return new Result<>(true, StatusCode.OK,"令牌生成成功",authToken);
    }

    /**
     * 设置令牌到cookie中
     * @param token
     */
    private void saveCookie(String token){
        HttpServletResponse response = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();
        CookieUtil.addCookie(response,cookieDomain,"/","Authorization",token,cookieMaxAge,false);
    }
}
