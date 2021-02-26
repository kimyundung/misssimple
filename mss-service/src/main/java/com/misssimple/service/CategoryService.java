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
    // 根据商品分类id查询商品分类
    public Category findCategoryByCatId(Integer catId);
    // 添加商品分类
    public void saveCategory(Category category);
    // 更新商品分类
    public void updateCategory(Category category);
    // 删除商品分类(如果是父级分类子级分类也同删掉)
    public void deleteCateGory(Integer catId);
}
