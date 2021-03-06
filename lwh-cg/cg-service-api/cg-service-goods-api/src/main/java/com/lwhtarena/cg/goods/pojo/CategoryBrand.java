package com.lwhtarena.cg.goods.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.io.Serializable;
import java.lang.Integer;

/****
 * @Author:liwh
 * @Description:CategoryBrand构建
 * @Date 2020/07/09 0:18
 *****/
@ApiModel(description = "CategoryBrand", value = "CategoryBrand")
@Table(name = "tb_category_brand")
public class CategoryBrand implements Serializable {

    @ApiModelProperty(value = "分类ID", required = false)
    @Id
    @Column(name = "category_id")
    private Integer categoryId;//分类ID

    @ApiModelProperty(value = "品牌ID", required = false)
    @Column(name = "brand_id")
    private Integer brandId;//品牌ID


    //get方法
    public Integer getCategoryId() {
        return categoryId;
    }

    //set方法
    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    //get方法
    public Integer getBrandId() {
        return brandId;
    }

    //set方法
    public void setBrandId(Integer brandId) {
        this.brandId = brandId;
    }


}
