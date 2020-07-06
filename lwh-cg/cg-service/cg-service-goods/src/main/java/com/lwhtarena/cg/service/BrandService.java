package com.lwhtarena.cg.service;

import com.lwhtarena.cg.goods.pojo.Brand;

import java.util.List;

/**
 * @author liwh
 * @Title: BrandService
 * @Package com.lwhtarena.cg.service
 * @Description:
 * @Version 1.0.0
 * @date 2020/7/2 06:12
 */
public interface BrandService {

    List<Brand> findAll();

    Brand findById(Integer id);


    void add(Brand brand);

    void update(Brand brand);

    void delete(Integer id);

    /**
     * 根据条件查询品牌的列表
     *
     * @param brand
     * @return
     */
    List<Brand> findList(Brand brand);


    /**
     * 分页查询 无条件
     *
     * @param page
     * @param size
     * @return
     */
    PageInfo<Brand> findPage(Integer page, Integer size);

    /**
     * 有条件的分页查询
     *
     * @param page
     * @param size
     * @param brand
     * @return
     */
    PageInfo<Brand> findPage(Integer page, Integer size, Brand brand);
}
