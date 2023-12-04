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
 * @TableName message
 */
@TableName(value ="message")
@Data
@NoArgsConstructor
public class Message implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Long messageId;

    /**
     * 
     */
    private Long userId;

    /**
     * 
     */
    private Long goodsId;

    /**
     * 
     */
    private Long replyId;

    /**
     * 
     */
    private String content;

    /**
     * 
     */
    private Integer praise;

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
        Message other = (Message) that;
        return (this.getMessageId() == null ? other.getMessageId() == null : this.getMessageId().equals(other.getMessageId()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getGoodsId() == null ? other.getGoodsId() == null : this.getGoodsId().equals(other.getGoodsId()))
            && (this.getReplyId() == null ? other.getReplyId() == null : this.getReplyId().equals(other.getReplyId()))
            && (this.getContent() == null ? other.getContent() == null : this.getContent().equals(other.getContent()))
            && (this.getPraise() == null ? other.getPraise() == null : this.getPraise().equals(other.getPraise()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getMessageId() == null) ? 0 : getMessageId().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getGoodsId() == null) ? 0 : getGoodsId().hashCode());
        result = prime * result + ((getReplyId() == null) ? 0 : getReplyId().hashCode());
        result = prime * result + ((getContent() == null) ? 0 : getContent().hashCode());
        result = prime * result + ((getPraise() == null) ? 0 : getPraise().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", messageId=").append(messageId);
        sb.append(", userId=").append(userId);
        sb.append(", goodsId=").append(goodsId);
        sb.append(", replyId=").append(replyId);
        sb.append(", content=").append(content);
        sb.append(", praise=").append(praise);
        sb.append(", createTime=").append(createTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}