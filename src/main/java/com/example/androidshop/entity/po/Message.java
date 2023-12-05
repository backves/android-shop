package com.example.androidshop.entity.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @TableName message
 */
@TableName(value ="message")
@Data
@NoArgsConstructor
public class Message implements Serializable {
    @TableId(type = IdType.AUTO)
    private Long messageId;
    private Long userId;
    private Long goodsId;
    private Long replyId;
    private String content;
    private Integer praise;
    private Date createTime;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}