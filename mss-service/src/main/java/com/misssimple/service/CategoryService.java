package com.misssimple.service;

import com.github.pagehelper.PageInfo;
import com.misssimple.domain.Category;
import com.misssimple.domain.CategoryVo;

import java.util.List;

/**
 * 商品分类service接口
 */
public interface CategoryService {
    // 分页查询商品分类(按层级)
    public PageInfo findCategoryWithPage(CategoryVo categoryVo);
    // 查询所有商品分类(按层级)
    public List<Category> findAllCategory();
}
