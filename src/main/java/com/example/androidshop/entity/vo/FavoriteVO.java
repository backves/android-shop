package com.example.androidshop.entity.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Data
@NoArgsConstructor
@TableName(value = "favorite")
public class FavoriteVO {
    private Long favoriteId;
    private Long userId;
    private Long goodsId;
    private Date createTime;
    private Date updateTime;

    private String goodsName;
    private BigDecimal goodsPrice;
    private String img;
    private String detail;
    private String type;
    private Integer goodsState;
}
