package com.misssimple.service.Impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.misssimple.domain.Goods;
import com.misssimple.domain.GoodsPics;
import com.misssimple.domain.GoodsVo;
import com.misssimple.domain.PicVo;
import com.misssimple.mapper.GoodsMapper;
import com.misssimple.mapper.GoodsPicsMapper;
import com.misssimple.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * 商品service接口实现类
 */
@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private GoodsMapper goodsMapper;
    @Autowired
    private GoodsPicsMapper goodsPicsMapper;

    // 根据条件分页查询商品
    @Override
    public PageInfo<Goods> findGoodsByConditionAndPage(GoodsVo goodsVo) {
        PageHelper.startPage(goodsVo.getPagenum(),goodsVo.getPagesize());
        List<Goods> goodsList = goodsMapper.findAllGoodsByCondition(goodsVo);
        PageInfo<Goods> pageInfo = new PageInfo<>(goodsList);
        return pageInfo;
    }

    // 根据id查询商品
    @Override
    public Goods findGoodsById(Integer goodsId) {
        Goods goods = goodsMapper.findGoodsById(goodsId);
        return goods;
    }

    // 添加商品
    @Override
    public void saveGoodsTran(GoodsVo goodsVo) {
        Date date = new Date();

        // 1.添加商品
        // 准备商品信息
        Goods goods = new Goods();
        goods.setGoodsName(goodsVo.getGoodsName());
        goods.setGoodsPrice(goodsVo.getGoodsPrice());
        goods.setCatId(goodsVo.getCatIds().get(1));
        goods.setGoodsIntroduce(goodsVo.getGoodsIntroduce());
        goods.setCatOneId(goodsVo.getCatIds().get(0));
        goods.setCaTwoId(goodsVo.getCatIds().get(1));
        goods.setIsDel(0);
        goods.setCreateTime(date);
        goods.setUpdateTime(date);
        goods.setCreatedBy("system");
        goods.setUpdatedBy("system");
        // 添加
        goodsMapper.saveGoods(goods);

        // 2.添加商品相册
        List<PicVo> pics = goodsVo.getPics();
        // 循环获取商品照片
        for (PicVo pic : pics) {
            // 准备数据
            GoodsPics goodsPics = new GoodsPics();
            goodsPics.setGoodsId(goods.getGoodsId());
            goodsPics.setPicsBig(pic.getPic());
            goodsPics.setIsDel(0);
            goodsPics.setCreateTime(date);
            goodsPics.setUpdateTime(date);
            goodsPics.setCreatedBy("system");
            goodsPics.setUpdatedBy("system");
            // 添加
            goodsPicsMapper.saveGoodsPics(goodsPics);
        }

    }

    // 更新商品
    @Override
    public void updateGoodsTran(GoodsVo goodsVo) {
        Date date = new Date();
        // 1.修改商品
        Goods goods = new Goods();
        goods.setGoodsId(goodsVo.getGoodsId());
        goods.setGoodsName(goodsVo.getGoodsName());
        goods.setGoodsPrice(goodsVo.getGoodsPrice());
        goods.setCatId(goodsVo.getCatIds().get(1));
        goods.setGoodsIntroduce(goodsVo.getGoodsIntroduce());
        goods.setCatOneId(goodsVo.getCatIds().get(0));
        goods.setCaTwoId(goodsVo.getCatIds().get(1));
        goods.setUpdateTime(date);
        goods.setUpdatedBy("system");
        goodsMapper.updateGoods(goods);
//int i = 1/0;
        // 2.修改商品相册
        // 先删除商品关联相册
        goodsPicsMapper.deleteGoodsPicsByGoodsId(goodsVo.getGoodsId());
        // 重新插入商品相册
        List<PicVo> pics = goodsVo.getPics();
        for (PicVo pic : pics) {
            // 准备数据
            GoodsPics goodsPics = new GoodsPics();
            goodsPics.setGoodsId(goods.getGoodsId());
            goodsPics.setPicsBig(pic.getPic());
            goodsPics.setIsDel(0);
            goodsPics.setCreateTime(date);
            goodsPics.setUpdateTime(date);
            goodsPics.setCreatedBy("system");
            goodsPics.setUpdatedBy("system");
            // 添加
            goodsPicsMapper.saveGoodsPics(goodsPics);
        }

    }

    // 删除商品
    @Override
    public void deleteGoodsTran(Integer goodsId) {
        Date date = new Date();
        // 1.删除商品关联相册
        GoodsPics goodsPics = new GoodsPics();
        goodsPics.setGoodsId(goodsId);
        goodsPics.setIsDel(1);
        goodsPics.setDeleteTime(date);
        goodsPics.setDeletedBy("system");
        goodsPicsMapper.deleteGoodsPicsByGoodsId2(goodsPics);
//int i = 1/0;
        // 2.删除商品
        Goods goods = new Goods();
        goods.setGoodsId(goodsId);
        goods.setIsDel(1);
        goods.setDeleteTime(date);
        goods.setDeletedBy("system");
        goodsMapper.deleteGoodsByGoodsId(goods);
    }

}
