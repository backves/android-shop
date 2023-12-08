package com.example.androidshop.entity.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@TableName(value ="img")
@Data
public class Img implements Serializable {
    @TableId(type = IdType.AUTO)
    private Long imgId;
    private String url;
    private Date createTime;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}