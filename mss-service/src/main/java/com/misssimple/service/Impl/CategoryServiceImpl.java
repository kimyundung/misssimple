package com.misssimple.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.misssimple.domain.Category;
import com.misssimple.domain.CategoryVo;
import com.misssimple.mapper.CategoryMapper;
import com.misssimple.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
