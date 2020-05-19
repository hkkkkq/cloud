package com.lwhtarena.nl.behavior.controller.v1;

import com.lwhtarena.nl.behavior.apis.BehaviorControllerApi;
import com.lwhtarena.nl.behavior.service.AppShowBehaviorService;
import com.lwhtarena.nl.model.behavior.dtos.ShowBehaviorDto;
import com.lwhtarena.nl.model.common.dtos.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liwh
 * @Title: BehaviorController
 * @Package com.lwhtarena.nl.behavior.controller.v1
 * @Description:
 * @Version 1.0.0
 * @date 2020/5/19 13:22
 */
@RestController
@RequestMapping("/api/v1/behavior")
public class BehaviorController implements BehaviorControllerApi {

    @Autowired
    private AppShowBehaviorService appShowBehaviorService;

    @Override
    @PostMapping("/show_behavior")
    public ResponseResult saveShowBehavior(ShowBehaviorDto dto) {
        return null;
    }
}
