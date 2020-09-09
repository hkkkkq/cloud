package com.lwhtarena.glmall.order.vo;

import com.lwhtarena.glmall.order.entity.OrderEntity;
import lombok.Data;

/**
 * @author liwh
 * @Title: SubmitOrderResponseVo
 * @Package com.lwhtarena.glmall.order.vo
 * @Description:
 * @Version 1.0.0
 * @date 2020/9/9 16:21
 */

@Data
public class SubmitOrderResponseVo {

    private OrderEntity order;

    /** 错误状态码 **/
    private Integer code;
}
