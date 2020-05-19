package com.lwhtarena.mt.member.controller;

import com.lwhtarena.mt.entity.AppEntity;
import com.lwhtarena.mt.service.MemberService;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liwh
 * @Title: MemberController
 * @Package com.lwhtarena.mt.member.controller
 * @Description:
 * @Version 1.0.0
 * @date 2020/5/16 23:28
 */
@RestController
public class MemberController implements MemberService {



    @Override
    public AppEntity memberInvokeWeiXin() {
        return null;
    }
}
