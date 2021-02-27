package com.misssimple.mapper;

import com.misssimple.domain.Goods;
import com.misssimple.domain.GoodsVo;

import java.util.List;

/**
 * 商品的mapper接口
 */
public interface GoodsMapper {
    // 根据条件查询所有商品
    public List<Goods> findAllGoodsByCondition(GoodsVo goodsVo);
    // 根据id查询商品
    public Goods findGoodsById(Integer goodsId);
    // 添加商品
    public void saveGoods(Goods goods);
    // 更新商品
    public void updateGoods(Goods goods);
    // 删除商品
    public void deleteGoodsByGoodsId(Goods goods);
    // 图片上传

}
