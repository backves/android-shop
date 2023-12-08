package com.example.androidshop.controller;

import com.example.androidshop.entity.po.Img;
import com.example.androidshop.entity.po.Result;
import com.example.androidshop.service.ImgService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/img")
@RequiredArgsConstructor
public class ImgController {
    private final ImgService imgService;

    @PostMapping("/addImg")
    public Result addImg(String url) {
        Img img = new Img();
        img.setUrl(url);
        imgService.save(img);
        Long id = imgService.getImgByUrl(url).getImgId();
        return Result.success(id);
    }
}
