package com.lwhtarena.glmall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lwhtarena.common.utils.PageUtils;
import com.lwhtarena.glmall.product.entity.ProductAttrValueEntity;

import java.util.Map;

/**
 * spu属性值
 *
 * @author liwh
 * @email lwhtarena@gmail.com
 * @date 2020-07-25 11:16:44
 */
public interface ProductAttrValueService extends IService<ProductAttrValueEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

