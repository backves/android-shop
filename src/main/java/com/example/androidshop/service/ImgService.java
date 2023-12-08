package com.example.androidshop.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.androidshop.entity.po.Img;
import org.springframework.stereotype.Service;

public interface ImgService extends IService<Img> {

    Img getImgByUrl(String url);
}
