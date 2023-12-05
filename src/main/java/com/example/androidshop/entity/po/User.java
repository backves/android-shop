package com.example.androidshop.entity.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@TableName(value = "user")
@Data
@NoArgsConstructor
public class User implements Serializable {
    @TableId(type = IdType.AUTO)
    private Long userId;
    private String username;
    private String nickname;
    @JsonIgnore
    private String password;
    private String email;
    private String phone;
    private String avatar;
    private Long addressId;
    private Date createTime;
    private Date updateTime;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}