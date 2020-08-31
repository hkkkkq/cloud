package com.lwhtarena.glmall.product.controller;

import java.util.Arrays;
import java.util.Map;

import com.lwhtarena.glmall.product.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lwhtarena.glmall.product.entity.AttrGroupEntity;
import com.lwhtarena.glmall.product.service.AttrGroupService;
import com.lwhtarena.common.utils.PageUtils;
import com.lwhtarena.common.utils.R;



/**
 * 属性分组
 *
 * @author liwh
 * @email lwhtarena@gmail.com
 * @date 2020-07-25 11:16:44
 */
@RestController
@RequestMapping("product/attrgroup")
public class AttrGroupController {
    @Autowired
    private AttrGroupService attrGroupService;

    @Autowired
    private CategoryService categoryService;




    /**
     * 列表
     */
    @RequestMapping("/list/{categoryId}")
    public R list(@RequestParam Map<String, Object> params,@PathVariable(value = "categoryId") Long categoryId){
        PageUtils page =attrGroupService.queryPage(params,categoryId);
        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{attrGroupId}")
    public R info(@PathVariable("attrGroupId") Long attrGroupId){
		AttrGroupEntity attrGroup = attrGroupService.getById(attrGroupId);

        Long groupId = attrGroup.getAttrGroupId();
        Long[] path = categoryService.findCatelogPath(groupId);
        attrGroup.setCategoryPath(path);

        return R.ok().put("attrGroup", attrGroup);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody AttrGroupEntity attrGroup){
		attrGroupService.save(attrGroup);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody AttrGroupEntity attrGroup){
		attrGroupService.updateById(attrGroup);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] attrGroupIds){
		attrGroupService.removeByIds(Arrays.asList(attrGroupIds));

        return R.ok();
    }

}
