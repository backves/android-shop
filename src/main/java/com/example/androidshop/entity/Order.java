package com.example.androidshop.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 
 * @TableName order
 */
@TableName(value ="order")
@Data
@NoArgsConstructor
public class Order implements Serializable {
    @TableId(type = IdType.AUTO)
    private Long orderId;
    private Long sellerId;
    private Long buyerId;
    private Long goodsId;
    private BigDecimal price;
    private Integer state;
    private String name;
    private String phone;
    private String location;
    private String detail;
    private Date createTime;
    private Date updateTime;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}