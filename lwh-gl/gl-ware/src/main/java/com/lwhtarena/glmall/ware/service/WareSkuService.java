package com.lwhtarena.glmall.ware.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lwhtarena.common.to.OrderTo;
import com.lwhtarena.common.to.mq.StockLockedTo;
import com.lwhtarena.common.utils.PageUtils;
import com.lwhtarena.glmall.ware.entity.WareSkuEntity;
import com.lwhtarena.glmall.ware.vo.SkuHasStockVo;
import com.lwhtarena.glmall.ware.vo.WareSkuLockVo;
import java.util.List;
import java.util.Map;

/**
 * 商品库存
 *
 * @author liwh
 * @email lwhtarena@gmail.com
 * @date 2020-07-25 14:13:18
 */
public interface WareSkuService extends IService<WareSkuEntity> {

    PageUtils queryPage(Map<String, Object> params);

    /**
     * 添加库存
     * @param skuId
     * @param wareId
     * @param skuNum
     */
    void addStock(Long skuId, Long wareId, Integer skuNum);

    /**
     * 判断是否有库存
     * @param skuIds
     * @return
     */
    List<SkuHasStockVo> getSkuHasStock(List<Long> skuIds);

    /**
     * 锁定库存
     * @param vo
     * @return
     */
    boolean orderLockStock(WareSkuLockVo vo);


    /**
     * 解锁库存
     * @param to
     */
    void unlockStock(StockLockedTo to);

    /**
     * 解锁订单
     * @param orderTo
     */
    void unlockStock(OrderTo orderTo);
}

