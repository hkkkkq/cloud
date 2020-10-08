package com.lwhtarena.glmall.seckill.vo;

import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @author liwh
 * @Title: SeckillSessionWithSkusVo
 * @Package com.lwhtarena.glmall.seckill.vo
 * @Description:
 * @Version 1.0.0
 * @date 2020/10/9 04:11
 */
@Data
public class SeckillSessionWithSkusVo {

    private Long id;
    /**
     * 场次名称
     */
    private String name;
    /**
     * 每日开始时间
     */
    private Date startTime;
    /**
     * 每日结束时间
     */
    private Date endTime;
    /**
     * 启用状态
     */
    private Integer status;
    /**
     * 创建时间
     */
    private Date createTime;

    private List<SeckillSkuVo> relationSkus;

}
