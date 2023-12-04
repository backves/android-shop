package com.example.androidshop.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.androidshop.entity.Favorite;
import com.example.androidshop.mapper.FavoriteMapper;
import com.example.androidshop.service.FavoriteService;
import org.springframework.stereotype.Service;

@Service
public class FavoriteServiceImpl extends ServiceImpl<FavoriteMapper, Favorite>
    implements FavoriteService {

}




