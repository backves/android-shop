package com.example.androidshop.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.androidshop.entity.po.GoodsImg;
import com.example.androidshop.entity.vo.GoodsImgVO;
import com.example.androidshop.mapper.GoodsImgMapper;
import com.example.androidshop.service.GoodsImgService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsImgServiceImpl extends ServiceImpl<GoodsImgMapper, GoodsImg>
        implements GoodsImgService {

    @Override
    public List<GoodsImgVO> listByGoodsId(Long goodsId) {
        return baseMapper.listByGoodsId(goodsId);
    }

    @Override
    public boolean checkRepetition(Long goodsId, Integer imgId) {
        LambdaQueryWrapper<GoodsImg> wrapper = new LambdaQueryWrapper<GoodsImg>()
                .eq(GoodsImg::getGoodsId, goodsId)
                .eq(GoodsImg::getImgId, imgId);
        GoodsImg goodsImg = getOne(wrapper);
        return goodsImg != null;
    }
}




