package com.example.androidshop.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.androidshop.entity.Goods;

import java.util.List;

public interface GoodsService extends IService<Goods> {
    Goods getByNameAndUserId(String name, Long userId);
}
