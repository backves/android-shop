package com.example.androidshop.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.androidshop.entity.Goods;
import com.example.androidshop.mapper.GoodsMapper;
import com.example.androidshop.service.GoodsService;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public List<Goods> getGoodsList(String name, Long userId, Boolean priceAsc, Integer page, Integer size) {
        LambdaQueryWrapper<Goods> wrapper = new LambdaQueryWrapper<Goods>()
                .like(name != null, Goods::getName, "%" + name)
                .eq(userId != null, Goods::getUserId, userId)
                .orderByAsc(priceAsc != null && priceAsc, Goods::getPrice)
                .orderByDesc(priceAsc != null && !priceAsc, Goods::getPrice);

        if (page == null) {
            page = 1;
        }
        if (size == null) {
            size = 20;
        }

        Page<Goods> p = Page.of(page, size);
        return baseMapper.selectPage(p, wrapper).getRecords();
    }
}




