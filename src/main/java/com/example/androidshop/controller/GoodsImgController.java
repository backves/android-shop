package com.example.androidshop.controller;

import com.example.androidshop.entity.po.Goods;
import com.example.androidshop.entity.po.GoodsImg;
import com.example.androidshop.entity.po.Img;
import com.example.androidshop.entity.po.Result;
import com.example.androidshop.entity.vo.GoodsImgVO;
import com.example.androidshop.service.GoodsImgService;
import com.example.androidshop.service.GoodsService;
import com.example.androidshop.utils.ThreadLocalUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/goodsImg")
@RequiredArgsConstructor
public class GoodsImgController {
    private final GoodsImgService goodsImgService;
    private final GoodsService goodsService;

    @PostMapping("/addGoodsImg")
    public Result addGoodsImg(@RequestBody Map<String, Object> json) {

        Long goodsId = Long.valueOf(String.valueOf(json.get("goodsId")));
        List<Integer> imgIds = (List<Integer>) json.get("imgIds");

        System.out.println(goodsId);
        System.out.println(imgIds);

        Goods goods = goodsService.getById(goodsId);
        if (goods == null) {
            return Result.error("商品不存在");
        }
        if (goods.getState() != 1) {
            return Result.error("商品已下架");
        }

        Map<String, Object> map = ThreadLocalUtil.get();
        Long userId = Long.valueOf(String.valueOf(map.get("id")));

        if (!goods.getUserId().equals(userId)) {
            return Result.error("没有权限");
        }

        for (Integer imgId : imgIds) {
            Long imgIdLong = Long.valueOf(String.valueOf(imgId));
            GoodsImg goodsImg = new GoodsImg();
            goodsImg.setGoodsId(goodsId);
            goodsImg.setImgId(imgIdLong);
            goodsImgService.save(goodsImg);
        }
        return Result.success();
    }

    @GetMapping("/listGoodsImg")
    public Result getGoodsImgList(Long goodsId) {
        List<GoodsImgVO> goodsImages = goodsImgService.listByGoodsId(goodsId);
        return Result.success(goodsImages);
    }
}
