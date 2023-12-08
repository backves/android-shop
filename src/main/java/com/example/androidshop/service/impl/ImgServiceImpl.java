package com.example.androidshop.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.androidshop.entity.po.Img;
import com.example.androidshop.mapper.ImgMapper;
import com.example.androidshop.service.ImgService;
import org.springframework.stereotype.Service;

@Service
public class ImgServiceImpl extends ServiceImpl<ImgMapper, Img>
        implements ImgService {

    @Override
    public Img getImgByUrl(String url) {
        LambdaQueryWrapper<Img> wrapper = new LambdaQueryWrapper<Img>()
                .eq(Img::getUrl, url);

        return getOne(wrapper);
    }
}




