package com.example.androidshop.entity;

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
 * @TableName chat
 */
@TableName(value ="chat")
@Data
@NoArgsConstructor
public class Chat implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Long chatId;

    /**
     * 
     */
    private Long sellerId;

    /**
     * 
     */
    private Long buyerId;

    /**
     * 
     */
    private Long goodsId;

    /**
     * 
     */
    private Date createTime;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Chat other = (Chat) that;
        return (this.getChatId() == null ? other.getChatId() == null : this.getChatId().equals(other.getChatId()))
            && (this.getSellerId() == null ? other.getSellerId() == null : this.getSellerId().equals(other.getSellerId()))
            && (this.getBuyerId() == null ? other.getBuyerId() == null : this.getBuyerId().equals(other.getBuyerId()))
            && (this.getGoodsId() == null ? other.getGoodsId() == null : this.getGoodsId().equals(other.getGoodsId()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getChatId() == null) ? 0 : getChatId().hashCode());
        result = prime * result + ((getSellerId() == null) ? 0 : getSellerId().hashCode());
        result = prime * result + ((getBuyerId() == null) ? 0 : getBuyerId().hashCode());
        result = prime * result + ((getGoodsId() == null) ? 0 : getGoodsId().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", chatId=").append(chatId);
        sb.append(", sellerId=").append(sellerId);
        sb.append(", buyerId=").append(buyerId);
        sb.append(", goodsId=").append(goodsId);
        sb.append(", createTime=").append(createTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}