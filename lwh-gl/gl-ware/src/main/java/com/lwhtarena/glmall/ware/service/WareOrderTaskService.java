package com.lwhtarena.glmall.ware.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lwhtarena.common.utils.PageUtils;
import com.lwhtarena.glmall.ware.entity.WareOrderTaskEntity;

import java.util.Map;

/**
 * 库存工作单
 *
 * @author liwh
 * @email lwhtarena@gmail.com
 * @date 2020-07-25 14:13:19
 */
public interface WareOrderTaskService extends IService<WareOrderTaskEntity> {

    PageUtils queryPage(Map<String, Object> params);

    WareOrderTaskEntity getOrderTaskByOrderSn(String orderSn);
}

