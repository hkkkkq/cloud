package com.lwhtarena.glmall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lwhtarena.common.utils.PageUtils;
import com.lwhtarena.glmall.product.entity.AttrEntity;
import com.lwhtarena.glmall.product.vo.AttrGroupRelationVo;
import com.lwhtarena.glmall.product.vo.AttrRespVo;
import com.lwhtarena.glmall.product.vo.AttrVo;

import java.util.List;
import java.util.Map;

/**
 * 商品属性
 *
 * @author liwh
 * @email lwhtarena@gmail.com
 * @date 2020-07-25 11:16:44
 */
public interface AttrService extends IService<AttrEntity> {

    PageUtils queryPage(Map<String, Object> params);

    void saveAttr(AttrVo attr);

    PageUtils queryBaseAttrPage(Map<String, Object> params, Long catelogId, String type);

    AttrRespVo getAttrInfo(Long attrId);

    void updateAttr(AttrVo attr);

    /**
     * 根据分组id找到关联的所有属性
     * @param attrgroupId
     * @return
     */
    List<AttrEntity> getRelationAttr(Long attrgroupId);

    void deleteRelation(AttrGroupRelationVo[] vos);

    PageUtils getNoRelationAttr(Map<String, Object> params, Long attrgroupId);

    /**
     * 在指定的所有属性集合里面，挑出检索属性
     * @param attrIds
     * @return
     */
    List<Long> selectSearchAttrs(List<Long> attrIds);
}

