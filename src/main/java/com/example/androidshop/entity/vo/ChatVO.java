package com.example.androidshop.entity.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@TableName(value = "chat")
@Data
@NoArgsConstructor
public class ChatVO {
    @TableId(type = IdType.AUTO)
    private Long chatId;
    private Long sellerId;
    private Long buyerId;
    private Long goodsId;
    private Date createTime;

    private String username;
    private String avatar;
    private String name;
    private String img;
    private String price;

    private String lastMessage;
    private Date lastTime;
}
