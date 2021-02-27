package com.misssimple.service;

import com.github.pagehelper.PageInfo;
import com.misssimple.domain.Goods;
import com.misssimple.domain.GoodsVo;

import java.util.List;

/**
 * 商品的service接口
 */
public interface GoodsService {
    // 根据条件分页查询商品
    public PageInfo<Goods> findGoodsByConditionAndPage(GoodsVo goodsVo);
    // 根据id查询商品
    public Goods findGoodsById(Integer goodsId);
    // 添加商品
    public void saveGoodsTran(GoodsVo goodsVo);
    // 更新商品
    public void updateGoodsTran(GoodsVo goodsVo);
    // 删除商品
    public void deleteGoodsTran(Integer goodsId);
}
