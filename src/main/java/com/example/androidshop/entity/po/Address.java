package com.example.androidshop.entity.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.io.Serializable;
import java.util.Date;

@TableName(value ="address")
@Data
@NoArgsConstructor
public class Address implements Serializable {
    @TableId(type = IdType.AUTO)
    private Long addressId;
    private Long userId;
    @NotNull(groups = Insert.class)
    private String name;
    @NotNull(groups = Insert.class)
    private String phone;
    @NotNull(groups = Insert.class)
    private String location;
    @NotNull(groups = Insert.class)
    private String detail;
    private Date createTime;
    private Date updateTime;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
    public interface Insert {
    }
}