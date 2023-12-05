package com.example.androidshop.controller;

import com.example.androidshop.entity.po.Favorite;
import com.example.androidshop.entity.po.Result;
import com.example.androidshop.service.FavoriteService;
import com.example.androidshop.service.GoodsService;
import com.example.androidshop.utils.ThreadLocalUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/favorite")
@RequiredArgsConstructor
public class FavoriteController {
    private final FavoriteService favoriteService;
    private final GoodsService goodsService;

    @PostMapping("/addFavorite")
    public Result addFavorite(Long goodsId) {

        Map<String, Object> map = ThreadLocalUtil.get();
        Long userId = Long.valueOf(String.valueOf(map.get("id")));

        if (goodsService.getById(goodsId) == null) {
            return Result.error("商品不存在");
        }

        if (favoriteService.checkRepetition(userId, goodsId)) {
            return Result.error("已收藏");
        }

        Favorite favorite = new Favorite();
        favorite.setUserId(userId);
        favorite.setGoodsId(goodsId);

        favoriteService.save(favorite);
        return Result.success();
    }

    @GetMapping("/listFavorite")
    public Result getFavoriteList(Integer page, Integer size) {

        Map<String, Object> map = ThreadLocalUtil.get();
        Long userId = Long.valueOf(String.valueOf(map.get("id")));

        return Result.success(favoriteService.listFavoriteByUserId(userId, page, size));
    }

    @DeleteMapping("/deleteFavorite")
    public Result deleteFavorite(Long id) {

        Favorite favorite = favoriteService.getById(id);

        if (favorite == null) {
            return Result.error("收藏不存在");
        }

        Map<String, Object> map = ThreadLocalUtil.get();
        Long userId = Long.valueOf(String.valueOf(map.get("id")));

        if (!favorite.getUserId().equals(userId)) {
            return Result.error("无权限删除");
        }

        favoriteService.removeById(id);
        return Result.success();
    }
}
