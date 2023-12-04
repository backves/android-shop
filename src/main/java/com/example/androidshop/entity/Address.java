package com.example.androidshop.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@TableName(value ="address")
@Data
@NoArgsConstructor
public class Address implements Serializable {
    @TableId(type = IdType.AUTO)
    private Long addressId;
    private Long userId;
    private String name;
    private String phone;
    private String location;
    private String detail;
    private Date createTime;
    private Date updateTime;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}