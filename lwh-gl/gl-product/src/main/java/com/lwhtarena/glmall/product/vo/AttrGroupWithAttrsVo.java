package com.lwhtarena.glmall.product.vo;

import com.lwhtarena.glmall.product.entity.AttrEntity;
import lombok.Data;

import java.util.List;

/**
 * @author liwh
 * @Title: AttrGroupWithAttrsVo
 * @Package com.lwhtarena.glmall.product.vo
 * @Description:
 * @Version 1.0.0
 * @date 2020/8/31 21:44
 */
@Data
public class AttrGroupWithAttrsVo {

    /**
     * 分组id
     */
    private Long attrGroupId;
    /**
     * 组名
     */
    private String attrGroupName;
    /**
     * 排序
     */
    private Integer sort;
    /**
     * 描述
     */
    private String descript;
    /**
     * 组图标
     */
    private String icon;
    /**
     * 所属分类id
     */
    private Long catelogId;

    private List<AttrEntity> attrs;
}
