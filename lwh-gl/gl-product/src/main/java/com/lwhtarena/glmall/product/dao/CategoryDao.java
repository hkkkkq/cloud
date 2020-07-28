package com.lwhtarena.glmall.product.dao;

import com.lwhtarena.glmall.product.entity.CategoryEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品三级分类
 * 
 * @author liwh
 * @email lwhtarena@gmail.com
 * @date 2020-07-25 11:16:44
 */
@Mapper
public interface CategoryDao extends BaseMapper<CategoryEntity> {
	
}
