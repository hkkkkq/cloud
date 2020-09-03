package com.lwhtarena.glmall.product.vo;

import lombok.Data;
import lombok.ToString;

import java.util.List;

/**
 * @author liwh
 * @Title: SpuItemAttrGroupVo
 * @Package com.lwhtarena.glmall.product.vo
 * @Description:
 * @Version 1.0.0
 * @date 2020/9/3 21:54
 */
@Data
@ToString
public class SpuItemAttrGroupVo {
    private String groupName;
    private List<Attr> attrs;
}
