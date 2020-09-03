package com.lwhtarena.common.to.mq;

import lombok.Data;

/**
 * @author liwh
 * @Title: StockDetailTo
 * @Package com.lwhtarena.common.to.mq
 * @Description:
 * @Version 1.0.0
 * @date 2020/9/3 22:10
 */
@Data
public class StockDetailTo {

    private Long id;
    /**
     * sku_id
     */
    private Long skuId;
    /**
     * sku_name
     */
    private String skuName;
    /**
     * 购买个数
     */
    private Integer skuNum;
    /**
     * 工作单id
     */
    private Long taskId;

    /**
     * 仓库id
     */
    private Long wareId;

    /**
     * 锁定状态
     */
    private Integer lockStatus;

}
