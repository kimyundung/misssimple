package com.misssimple.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.misssimple.domain.Category;
import com.misssimple.domain.CategoryVo;
import com.misssimple.mapper.CategoryMapper;
import com.misssimple.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * 商品分类service接口实现类
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    // 分页查询商品分类(按层级)
    @Override
    public PageInfo findCategoryWithPage(CategoryVo categoryVo) {

        // 查询所有一级分类
        if(categoryVo.getType() == 1){
            PageHelper.startPage(categoryVo.getPagenum(),categoryVo.getPagesize());
            List<Category> categoryList = categoryMapper.findFirstLevelCategory();
            PageInfo<Category> pageInfo = new PageInfo<>(categoryList);
            return pageInfo;
        }
        // 查询所有分类
        else if (categoryVo.getType() == 2) {
            PageHelper.startPage(categoryVo.getPagenum(),categoryVo.getPagesize());
            List<Category> categoryList = this.findAllCategory();
            PageInfo<Category> pageInfo = new PageInfo<>(categoryList);
            return pageInfo;
        } else {
            return null;
        }
    }

    // 查询所有商品分类
    @Override
    public List<Category> findAllCategory() {
        List<Category> categoryList = categoryMapper.findFirstLevelCategory();
        for (Category category : categoryList) {
            List<Category> children = categoryMapper.findSecondLevelCategory(category.getCatId());
            category.setChildren(children);
        }
        return categoryList;
    }

    // 根据商品分类id查询商品分类
    @Override
    public Category findCategoryByCatId(Integer catId) {
        Category category = categoryMapper.findCategoryByCatId(catId);
        return category;
    }

    // 添加商品分类
    @Override
    public void saveCategory(Category category) {
        // 1.补全信息
        Date date = new Date();
        category.setIsDel(0);
        category.setCreateTime(date);
        category.setUpdateTime(date);
        category.setCreatedBy("system");
        category.setUpdatedBy("system");
        // 2.调用mapper方法
        categoryMapper.saveCategory(category);
    }

    // 更新商品分类
    @Override
    public void updateCategory(Category category) {
        // 1 补全信息
        category.setUpdateTime(new Date());
        category.setUpdatedBy("system");
        // 2 调用mapper方法
        categoryMapper.updateCategory(category);
    }

    // 删除商品分类(如果是父级分类子级分类也同删掉)
    @Override
    public String deleteCateGory(Integer catId) {

        String string = "";
        Integer count = 0;
        Date date = new Date();

        // 1.根据id查询商品分类
        Category category = categoryMapper.findCategoryByCatId(catId);
        // 3.如果是父子id, 则线删除子级商品分类
        if(category.getCatPid() == 0) {
            List<Category> secondLevelCategories = categoryMapper.findSecondLevelCategory(category.getCatId());
            for (Category secondLevelCategory : secondLevelCategories) {
                // 0.商品分类下是否有商品?
                Integer goodsCount = categoryMapper.findGoodsByCatId(secondLevelCategory.getCatId());
                if (goodsCount != 0){
                    string += " " + secondLevelCategory.getCatName();
                }
                count += goodsCount;
            }
            // 分类下无商品
            if(count == 0){
                // 删除
                for (Category secondLevelCategory : secondLevelCategories) {
                    secondLevelCategory.setDeleteTime(date);
                    secondLevelCategory.setDeletedBy("system");
                    secondLevelCategory.setIsDel(1);
                    categoryMapper.deleteCateGory(secondLevelCategory);
                }
                // 补全数据
                category.setDeleteTime(date);
                category.setDeletedBy("system");
                category.setIsDel(1);
                categoryMapper.deleteCateGory(category);
                return "成功删除商品分类";
            }
            // 分类下有商品
            else {
                // 提示
                return string + " 分类下有商品";
            }
        }
        // 删除子级商品分类
        Integer goodsCount = categoryMapper.findGoodsByCatId(catId);
        if(goodsCount == 0){
            // 删除
            // 补全数据
            category.setDeleteTime(date);
            category.setDeletedBy("system");
            category.setIsDel(1);
            categoryMapper.deleteCateGory(category);
            return "成功删除商品分类";
        } else {
            // 提示
            string = category.getCatName();
            return string  + " 分类下有商品";
        }
    }


}
