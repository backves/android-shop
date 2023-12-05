package com.example.androidshop.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.androidshop.entity.po.Goods;

import java.util.List;

public interface GoodsService extends IService<Goods> {
    Goods getByNameAndUserId(String name, Long userId);

    List<Goods> getGoodsList(String name, Long userId, Boolean priceAsc, Integer page, Integer size);
}
