package com.lwhtarena.common.to.mq;

import lombok.Data;

/**
 * @author liwh
 * @Title: StockLockedTo
 * @Package com.lwhtarena.common.to.mq
 * @Description: 发送到mq消息队列的to
 * @Version 1.0.0
 * @date 2020/9/3 22:10
 */
@Data
public class StockLockedTo {

    /** 库存工作单的id **/
    private Long id;

    /** 工作单详情的所有信息 **/
    private StockDetailTo detailTo;
}
