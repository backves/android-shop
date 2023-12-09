package com.example.androidshop.entity.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.example.androidshop.entity.po.Order;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@TableName(value = "orders")
@Data
@NoArgsConstructor
public class OrderVO {
    private Long orderId;
    private Long sellerId;
    private Long buyerId;
    private Long goodsId;
    private String goodsImg;
    private String goodsDetail;
    private String goodsName;
    private BigDecimal goodsPrice;
    private BigDecimal price;
    private Integer state;
    private String name;
    private String phone;
    private String location;
    private String detail;

    private String username;
    private String nickname;
    private Date createTime;
    private Date updateTime;
}
