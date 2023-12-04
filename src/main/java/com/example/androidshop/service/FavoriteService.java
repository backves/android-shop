package com.example.androidshop.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.androidshop.entity.Favorite;

import java.util.List;

public interface FavoriteService extends IService<Favorite> {

    List<Favorite> listFavoriteByUserId(Long userId, Integer page, Integer size);
}
