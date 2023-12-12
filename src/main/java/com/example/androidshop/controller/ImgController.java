package com.example.androidshop.controller;

import com.example.androidshop.entity.po.Img;
import com.example.androidshop.entity.po.Result;
import com.example.androidshop.service.ImgService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/img")
@RequiredArgsConstructor
public class ImgController {
    private final ImgService imgService;

    @PostMapping("/addImg")
    public Result addImg(String url) {
        if (imgService.getImgByUrl(url) != null) {
            return Result.error("图片已存在");
        }
        Img img = new Img();
        img.setUrl(url);
        imgService.save(img);
        Long id = imgService.getImgByUrl(url).getImgId();
        return Result.success(id);
    }

//    @PostMapping("/addImages")
//    public Result addImages(List<String> urls) {
//
//        return Result.success();
//    }
}
