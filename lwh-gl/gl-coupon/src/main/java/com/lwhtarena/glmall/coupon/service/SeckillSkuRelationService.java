package com.lwhtarena.glmall.coupon.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lwhtarena.common.utils.PageUtils;
import com.lwhtarena.glmall.coupon.entity.SeckillSkuRelationEntity;

import java.util.Map;

/**
 * 秒杀活动商品关联
 *
 * @author liwh
 * @email lwhtarena@gmail.com
 * @date 2020-07-25 13:23:28
 */
public interface SeckillSkuRelationService extends IService<SeckillSkuRelationEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

