package com.lwhtarena.nl.behavior.service;

import com.lwhtarena.nl.model.behavior.dtos.ShowBehaviorDto;
import com.lwhtarena.nl.model.common.dtos.ResponseResult;

/**
 * @author liwh
 * @Title: AppShowBehaviorService
 * @Package com.lwhtarena.nl.behavior.service
 * @Description:
 * @Version 1.0.0
 * @date 2020/5/19 13:24
 */
public interface AppShowBehaviorService {
    ResponseResult saveShowBehavior(ShowBehaviorDto dto);
}
