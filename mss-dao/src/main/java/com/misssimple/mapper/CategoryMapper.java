package com.misssimple.mapper;

import com.misssimple.domain.Category;

import java.util.List;

/**
 * 商品分类mapper接口
 */
public interface CategoryMapper {
    // 查询所有一级分类
    public List<Category> findFirstLevelCategory();
    // 根据一级分类查询二级分类
    public List<Category> findSecondLevelCategory(Integer pid);
}
