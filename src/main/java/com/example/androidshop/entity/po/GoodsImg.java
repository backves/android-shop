package com.example.androidshop.entity.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@TableName(value ="goods_img")
@Data
@NoArgsConstructor
public class GoodsImg implements Serializable {
    @TableId(type = IdType.AUTO)
    private Long gImgId;
    private Long goodsId;
    private Long imgId;
    private Date createTime;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}