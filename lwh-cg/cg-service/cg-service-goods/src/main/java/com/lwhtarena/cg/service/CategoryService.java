package com.lwhtarena.cg.service;
import com.github.pagehelper.PageInfo;
import com.lwhtarena.cg.goods.pojo.Category;

import java.util.List;
/****
 * @Author:liwh
 * @Description:Category业务层接口
 * @Date 2020/07/09 0:18
 *****/
public interface CategoryService {

    /***
     * Category多条件分页查询
     * @param category
     * @param page
     * @param size
     * @return
     */
    PageInfo<Category> findPage(Category category, int page, int size);

    /***
     * Category分页查询
     * @param page
     * @param size
     * @return
     */
    PageInfo<Category> findPage(int page, int size);

    /***
     * Category多条件搜索方法
     * @param category
     * @return
     */
    List<Category> findList(Category category);

    /***
     * 删除Category
     * @param id
     */
    void delete(Integer id);

    /***
     * 修改Category数据
     * @param category
     */
    void update(Category category);

    /***
     * 新增Category
     * @param category
     */
    void add(Category category);

    /**
     * 根据ID查询Category
     * @param id
     * @return
     */
    Category findById(Integer id);

    /***
     * 查询所有Category
     * @return
     */
    List<Category> findAll();

    /**
     * 根据父节点id查找
     * @param id
     * @return
     */
    List<Category> findByParentId(Integer id);


}
