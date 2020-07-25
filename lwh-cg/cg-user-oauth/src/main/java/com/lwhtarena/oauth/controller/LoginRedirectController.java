package com.lwhtarena.oauth.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author liwh
 * @Title: LoginRedirectController
 * @Package com.lwhtarena.oauth.controller
 * @Description:
 * @Version 1.0.0
 * @date 2020/7/17 10:02
 */
@Controller
@RequestMapping("/oauth")
public class LoginRedirectController {

    /**
     * 跳转到登录页面
     * @param From
     * @param model
     * @return
     */
    @RequestMapping("/login")
    public String login(String From, Model model) {
        model.addAttribute("from",From);
        return "login";
    }


}
