package com.example.androidshop.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.androidshop.entity.po.Favorite;
import com.example.androidshop.entity.vo.FavoriteVO;
import com.example.androidshop.mapper.FavoriteMapper;
import com.example.androidshop.service.FavoriteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.lang.reflect.Method;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FavoriteServiceImpl extends ServiceImpl<FavoriteMapper, Favorite>
        implements FavoriteService {

    private final FavoriteMapper favoriteMapper;

    @Override
    public List<FavoriteVO> listFavoriteByUserId(Long userId, Integer page, Integer size) {

        if (page == null) {
            page = 0;
        }
        if (size == null) {
            size = 20;
        }

        System.out.println("page:" + page);
        System.out.println("size:" + size);

//        try {
//            Class clazz = Class.forName("com.example.androidshop.mapper.FavoriteMapper");
//            Method method = clazz.getMethod("listFavoriteByUserId", Long.class, Integer.class, Integer.class);
//            System.out.println("Method Found");
//        } catch (NoSuchMethodException e) {
//            System.out.println("Method Not Found");
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }

//        System.out.println("this:" + baseMapper.queryFavorite(userId));
        return favoriteMapper.listFavoriteByUserId(userId, page * size, size);
//        return null;
    }


    @Override
    public Boolean checkRepetition(Long userId, Long goodsId) {
        LambdaQueryWrapper<Favorite> wrapper = new LambdaQueryWrapper<Favorite>()
                .eq(Favorite::getUserId, userId)
                .eq(Favorite::getGoodsId, goodsId);
        return baseMapper.exists(wrapper);
    }
}




