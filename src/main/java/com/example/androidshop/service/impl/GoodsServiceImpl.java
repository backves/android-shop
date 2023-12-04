package com.example.androidshop.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.androidshop.entity.Goods;
import com.example.androidshop.mapper.GoodsMapper;
import com.example.androidshop.service.GoodsService;
import org.springframework.stereotype.Service;

@Service
public class GoodsServiceImpl extends ServiceImpl<GoodsMapper, Goods>
        implements GoodsService {

    @Override
    public Goods getByNameAndUserId(String name, Long userId) {
        LambdaQueryWrapper<Goods> wrapper = new LambdaQueryWrapper<Goods>()
                .eq(Goods::getName, name)
                .eq(Goods::getUserId, userId);
        return getOne(wrapper);
    }
}




