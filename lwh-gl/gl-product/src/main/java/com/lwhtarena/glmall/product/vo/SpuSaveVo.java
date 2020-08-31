package com.lwhtarena.glmall.product.vo;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author liwh
 * @Title: SpuSaveVo
 * @Package com.lwhtarena.glmall.product.vo
 * @Description:
 * @Version 1.0.0
 * @date 2020/8/31 21:47
 */
@Data
public class SpuSaveVo {

    private String spuName;
    private String spuDescription;
    private Long catalogId;
    private Long brandId;
    private BigDecimal weight;
    private int publishStatus;
    private List<String> decript;
    private List<String> images;
    private Bounds bounds;
    private List<BaseAttrs> baseAttrs;
    private List<Skus> skus;
}