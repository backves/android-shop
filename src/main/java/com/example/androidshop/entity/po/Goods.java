package com.example.androidshop.entity.po;

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

@TableName(value = "goods")
@Data
@NoArgsConstructor
public class Goods implements Serializable {
    @TableId(type = IdType.AUTO)
    @NotNull(groups = Update.class)
    private Long goodsId;
    private Long userId;
    @NotNull
    private String name;
    @NotNull
    private BigDecimal price;
    @NotNull
    private String img;
    @NotNull
    private String detail;
    @NotNull(groups = Insert.class)
    private String type;
    private Integer state;
    private Date createTime;
    private Date updateTime;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    public interface Insert {
    }

    public interface Update {
    }
}