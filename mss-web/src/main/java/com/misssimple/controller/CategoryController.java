package com.misssimple.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.github.pagehelper.PageInfo;
import com.misssimple.domain.Category;
import com.misssimple.domain.CategoryVo;
import com.misssimple.domain.Meta;
import com.misssimple.domain.ResponseResult;
import com.misssimple.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 商品分类controller
 */
@RestController
@RequestMapping("/category")
public class CategoryController {

    //@Autowired
    @Reference
    private CategoryService categoryService;

    // 查询商品分类
    @RequestMapping("/findCategory")
    public ResponseResult findCategory(CategoryVo categoryVo){
        ResponseResult result = new ResponseResult();
        // 查询所有
        if(categoryVo.getType() == null){
            List<Category> categoryList = categoryService.findAllCategory();
            result.setData(categoryList);
        }
        // 分页查询
        else {
            PageInfo pageInfo = categoryService.findCategoryWithPage(categoryVo);
            result.setData(pageInfo);
        }
        // 响应数据
        result.setMeta(new Meta(200,"成功获取商品分类"));
        return result;
    }

    // 根据商品分类id查询商品分类
    @RequestMapping("/findCategoryByCatId")
    public ResponseResult findCategoryByCatId(Integer catId){
        // 1 调用service方法
        Category category = categoryService.findCategoryByCatId(catId);
        // 2 响应数据
        ResponseResult result = new ResponseResult();
        result.setData(category);
        result.setMeta(new Meta(200, "成功查询商品分类"));
        return result;
    }

    // 添加商品分类
    @RequestMapping("/saveCategory")
    public ResponseResult saveCategory(@RequestBody Category category){
        // 1.调用service方法
        categoryService.saveCategory(category);
        // 2.响应数据
        ResponseResult result = new ResponseResult();
        result.setData(null);
        result.setMeta(new Meta(201,"成功添加商品分类"));
        return result;
    }

    // 更新商品分类
    @RequestMapping("/updateCategory")
    public ResponseResult updateCategory(@RequestBody Category category){
        // 1 调用service方法
        categoryService.updateCategory(category);
        // 2 响应数据
        ResponseResult result = new ResponseResult();
        result.setData(null);
        result.setMeta(new Meta(202,"成功更新商品分类"));
        return result;
    }

    // 删除商品分类
    @RequestMapping("/deleteCateGory")
    public ResponseResult deleteCateGory(Integer catId){
        // 1 调用service方法
        String string = categoryService.deleteCateGory(catId);
        // 2 响应数据
        ResponseResult result = new ResponseResult();
        result.setData(null);
        result.setMeta(new Meta(203,string));
        return result;
    }
}
