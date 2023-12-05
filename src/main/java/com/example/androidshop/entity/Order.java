package com.example.androidshop.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 
 * @TableName order
 */
@TableName(value ="orders")
@Data
@NoArgsConstructor
public class Order implements Serializable {
    @TableId(type = IdType.AUTO)
    private Long orderId;
    @NotNull(groups = Order.Insert.class)
    private Long sellerId;
    @NotNull(groups = Order.Insert.class)
    private Long buyerId;
    @NotNull(groups = Order.Insert.class)
    private Long goodsId;
    @NotNull(groups = Order.Insert.class)
    private BigDecimal price;
    private Integer state;
    @NotNull(groups = Order.Insert.class)
    private String name;
    @NotNull(groups = Order.Insert.class)
    private String phone;
    @NotNull(groups = Order.Insert.class)
    private String location;
    @NotNull(groups = Order.Insert.class)
    private String detail;
    private Date createTime;
    private Date updateTime;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    public interface Insert {
    }
}