package com.example.androidshop.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.androidshop.entity.Favorite;
import com.example.androidshop.entity.Goods;
import com.example.androidshop.mapper.FavoriteMapper;
import com.example.androidshop.service.FavoriteService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FavoriteServiceImpl extends ServiceImpl<FavoriteMapper, Favorite>
        implements FavoriteService {

    @Override
    public List<Favorite> listFavoriteByUserId(Long userId, Integer page, Integer size) {
        LambdaQueryWrapper<Favorite> wrapper = new LambdaQueryWrapper<Favorite>()
                .eq(Favorite::getUserId, userId);

        if (page == null) {
            page = 1;
        }
        if (size == null) {
            size = 20;
        }
        Page<Favorite> p = Page.of(page, size);

        return baseMapper.selectPage(p, wrapper).getRecords();

    }
}




