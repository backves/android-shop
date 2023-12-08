package com.example.androidshop.entity.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@Data
public class GoodsImgVO {
    private Long gImgId;
    private Long goodsId;
    private Long imgId;
    private String url;
    private Date createTime;
}
