package com.example.androidshop;

import cn.hutool.core.lang.UUID;
import com.example.androidshop.service.GoodsService;
import com.example.androidshop.utils.Md5Util;
import com.example.androidshop.utils.ShortUuidUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class Test {
    @Autowired
    private GoodsService goodsService;

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
}
