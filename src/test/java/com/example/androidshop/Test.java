package com.example.androidshop;

import com.example.androidshop.service.FavoriteService;
import com.example.androidshop.service.GoodsService;
import com.example.androidshop.utils.Md5Util;
import com.example.androidshop.utils.ShortUuidUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;


@SpringBootTest
public class Test {
    @Autowired
    private GoodsService goodsService;
    @Autowired
    private FavoriteService foodsService;

    @org.junit.jupiter.api.Test
    public void testUUID() {
        System.out.println(ShortUuidUtil.generateUuid16());
    }

    @org.junit.jupiter.api.Test
    public void testMd5() {
        System.out.println(Md5Util.getMD5String("123456"));
    }

    @org.junit.jupiter.api.Test
    public void test() {
        System.out.println(goodsService.getByNameAndUserId("hjc", 1L));
    }

    @org.junit.jupiter.api.Test
    public void testMapper() {
        System.out.println(foodsService.listFavoriteByUserId(3L, 0, 10));
    }

    @org.junit.jupiter.api.Test
    public void testOSS() throws FileNotFoundException {
        System.out.println(AliOssUtil.uploadFile("003.png",new FileInputStream("C:\\Users\\28434\\Desktop\\stu\\1.jpg")));
    }
}
