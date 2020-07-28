package com.lwhtarena.glmall.member.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lwhtarena.common.utils.PageUtils;
import com.lwhtarena.glmall.member.entity.MemberEntity;

import java.util.Map;

/**
 * 会员
 *
 * @author liwh
 * @email lwhtarena@gmail.com
 * @date 2020-07-25 13:41:48
 */
public interface MemberService extends IService<MemberEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

