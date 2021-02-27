package com.misssimple.mapper;

import com.misssimple.domain.GoodsPics;

import java.util.List;

/**
 * 商品相册的mapper接口
 */
public interface GoodsPicsMapper {
    // 添加相册
    public void saveGoodsPics(GoodsPics goodsPics);
    // 根据商品id查询相册
    public List<GoodsPics> findGoodsPicsByGoodsId(Integer goodsId);
    // 根据商品id删除相册(物理删除)
    public void deleteGoodsPicsByGoodsId(Integer goodsId);
    // 根据商品id删除相册(逻辑删除)
    public void deleteGoodsPicsByGoodsId2(GoodsPics goodsPics);
}
