package com.misssimple.controller;

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

    @Autowired
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
}
