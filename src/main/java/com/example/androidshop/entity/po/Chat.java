package com.example.androidshop.entity.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@TableName(value ="chat")
@Data
@NoArgsConstructor
public class Chat implements Serializable {
    @TableId(type = IdType.AUTO)
    private Long chatId;
    private Long sellerId;
    private Long buyerId;
    private Long goodsId;
    private Date createTime;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}