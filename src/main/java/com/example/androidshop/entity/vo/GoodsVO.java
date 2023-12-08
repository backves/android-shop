package com.example.androidshop.entity.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@TableName(value = "goods")
@Data
@NoArgsConstructor
public class GoodsVO implements Serializable {
    @TableId(type = IdType.AUTO)
    private String username;
    private String nickname;
    private String userAvatar;
    private Long goodsId;
    private Long userId;
    private String name;
    private BigDecimal price;
    private String img;
    private String detail;
    private String type;
    private Integer state;
    private Boolean isFavorite;
    private Date createTime;
    private Date updateTime;
}