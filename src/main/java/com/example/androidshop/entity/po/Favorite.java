package com.example.androidshop.entity.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@TableName(value = "favorite")
@Data
@NoArgsConstructor
public class Favorite implements Serializable {
    @TableId(type = IdType.AUTO)
    private Long favoriteId;
    @NotNull(groups = Integer.class)
    private Long userId;
    @NotNull(groups = Integer.class)
    private Long goodsId;
    private Integer state;
    private Date createTime;
    private Date updateTime;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    public interface Insert {
    }
}