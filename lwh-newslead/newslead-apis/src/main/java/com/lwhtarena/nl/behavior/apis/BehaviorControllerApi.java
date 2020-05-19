package com.lwhtarena.nl.behavior.apis;

import com.lwhtarena.nl.model.behavior.dtos.ShowBehaviorDto;
import com.lwhtarena.nl.model.common.dtos.ResponseResult;

/**
 * @author liwh
 * @Title: BehaviorControllerApi
 * @Package com.lwhtarena.nl.behavior.apis
 * @Description:
 * @Version 1.0.0
 * @date 2020/5/19 13:17
 */
public interface BehaviorControllerApi {
    /**
     * 保存用户点击文章的行为
     * @param dto
     * @return
     */
    ResponseResult saveShowBehavior(ShowBehaviorDto dto);

//    /**
//     * 保存点赞行为
//     */
//    ResponseResult saveLikesBehavior(LikesBehaviorDto dto);
//
//    /**
//     * 保存不喜欢行为数据
//     */
//    ResponseResult saveUnlikesBehavior(UnLikesBehaviorDto dto);
//
//    /**
//     * 保存或修改阅读行为数据
//     */
//    ResponseResult saveReadBehavior(ReadBehaviorDto dto);
}
