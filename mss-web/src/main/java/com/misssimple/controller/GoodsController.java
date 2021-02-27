package com.misssimple.controller;

import com.github.pagehelper.PageInfo;
import com.misssimple.domain.Goods;
import com.misssimple.domain.GoodsVo;
import com.misssimple.domain.Meta;
import com.misssimple.domain.ResponseResult;
import com.misssimple.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 商品的controller
 */
@RestController
@RequestMapping("/goods")
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    // 根据条件分页查询商品
    @RequestMapping("/findAllGoods")
    private ResponseResult findAllGoods(@RequestBody GoodsVo goodsVo){
        // 1 调用service方法
        PageInfo<Goods> pageInfo = goodsService.findGoodsByConditionAndPage(goodsVo);
        // 2 响应数据
        ResponseResult result = new ResponseResult();
        result.setData(pageInfo);
        result.setMeta(new Meta(200,"成功查询商品"));
        return  result;
    }

    // 根据id查询商品
    @RequestMapping("/findGoodsById")
    public ResponseResult findGoodsById(Integer goodsId){
        // 1.调用service方法
        Goods goods = goodsService.findGoodsById(goodsId);
        // 2.响应数据
        ResponseResult result = new ResponseResult();
        result.setData(goods);
        result.setMeta(new Meta(200,"成功查询商品"));
        return result;
    }

    // 添加商品
    @RequestMapping("/saveGoods")
    public ResponseResult saveGoods(@RequestBody GoodsVo goodsVo){
        // 1.调用 service方法
        goodsService.saveGoodsTran(goodsVo);
        // 2.响应数据
        ResponseResult result = new ResponseResult();
        result.setData(null);
        result.setMeta(new Meta(201,"成功添加商品"));
        return result;
    }

    // 更新商品
    @RequestMapping("/updateGoods")
    public ResponseResult updateGoods(@RequestBody GoodsVo goodsVo){
        // 1.调用service方法
        goodsService.updateGoodsTran(goodsVo);
        // 2.响应数据
        ResponseResult result = new ResponseResult();
        result.setData(null);
        result.setMeta(new Meta(202,"成功更新商品信息"));
        return result;
    }

    // 删除商品
    @RequestMapping("/deleteGoods")
    public ResponseResult deleteGoods(Integer goodsId){
        // 1.调用service方法
        goodsService.deleteGoodsTran(goodsId);
        // 2.响应数据
        ResponseResult result = new ResponseResult();
        result.setData(null);
        result.setMeta(new Meta(203,"成功删除商品"));
        return result;
    }


}
