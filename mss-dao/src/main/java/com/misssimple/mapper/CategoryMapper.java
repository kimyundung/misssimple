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
    // 根据商品分类id查询商品分类
    public Category findCategoryByCatId(Integer catId);
    // 查询商品分类下的商品数量
    public Integer findGoodsByCatId(Integer catId);

    // 添加分类
    public void saveCategory(Category category);
    // 更新商品分类
    public void updateCategory(Category category);
    // 删除商品分类(如果是父级分类子级分类也同删掉)
    public void deleteCateGory(Category category);
}
