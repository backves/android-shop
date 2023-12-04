package com.example.androidshop.controller;

import com.example.androidshop.entity.Goods;
import com.example.androidshop.entity.Result;
import com.example.androidshop.service.GoodsService;
import com.example.androidshop.utils.ThreadLocalUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/goods")
@RequiredArgsConstructor
public class GoodsController {
    private final GoodsService goodsService;

    @PostMapping("/postGoods")
    public Result postGoods(@RequestBody @Validated(Goods.Insert.class) Goods goods) {

        Map<String, Object> map = ThreadLocalUtil.get();
        Long userId = Long.valueOf(String.valueOf(map.get("id")));

        Goods g = goodsService.getByNameAndUserId(goods.getName(), userId);

        if (g != null) {
            return Result.error("商品名称重复");
        }

        goods.setUserId(userId);

        goodsService.save(goods);
        return Result.success();
    }

    @GetMapping("/goodsInfo")
    public Result getGoods(Long id) {

        Goods goods = getById(id);

        return Result.success(goods);
    }

    @PutMapping("/updateGoods")
    public Result updateGoods(@RequestBody @Validated(Goods.Update.class) Goods goods) {

        Goods g = getById(goods.getGoodsId());

        Map<String, Object> map = ThreadLocalUtil.get();
        Long userId = Long.valueOf(String.valueOf(map.get("id")));

        if (!g.getUserId().equals(userId)) {
            return Result.error("没有权限");
        }

        goodsService.updateById(goods);

        return Result.success();
    }

    @GetMapping("/listGoods")
    public Result getGoodsList(String name, Long userId, Boolean priceAsc, Integer page, Integer size) {
        return Result.success(goodsService.getGoodsList(name, userId, priceAsc, page, size));
    }
    @DeleteMapping("/deleteGoods")
    public Result deleteGoods(Long id) {

        Goods goods = getById(id);

        Map<String, Object> map = ThreadLocalUtil.get();
        Long userId = Long.valueOf(String.valueOf(map.get("id")));

        if (!goods.getUserId().equals(userId)) {
            return Result.error("没有权限");
        }

        goodsService.removeById(id);

        return Result.success();
    }

    private Goods getById(Long id) {
        Goods goods = goodsService.getById(id);

        if (goods == null) {
            throw new RuntimeException("商品不存在");
        }

        return goods;
    }
}
