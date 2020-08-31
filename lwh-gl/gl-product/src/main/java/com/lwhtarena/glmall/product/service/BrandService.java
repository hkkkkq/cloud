package com.lwhtarena.glmall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lwhtarena.common.utils.PageUtils;
import com.lwhtarena.glmall.product.entity.BrandEntity;

import java.util.Map;

/**
 * 品牌
 *
 * @author liwh
 * @email lwhtarena@gmail.com
 * @date 2020-07-25 11:16:44
 */
public interface BrandService extends IService<BrandEntity> {

    PageUtils queryPage(Map<String, Object> params);

    void updateDetail(BrandEntity brand);
}

