package com.example.androidshop.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.androidshop.entity.po.Favorite;
import com.example.androidshop.entity.vo.FavoriteVO;

import java.util.List;

public interface FavoriteService extends IService<Favorite> {

    List<FavoriteVO> listFavoriteByUserId(Long userId, Integer page, Integer size);

    Boolean checkRepetition(Long userId, Long goodsId);

    void removeByGoodsId(Long userId, Long goodsId);
}
