package com.example.androidshop.entity.po;

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
 * @TableName chat_message
 */
@TableName(value ="chat_message")
@Data
@NoArgsConstructor
public class ChatMessage implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Long chatMessageId;

    /**
     * 
     */
    private Long chatId;

    /**
     * 
     */
    private String content;

    /**
     * 
     */
    private Integer type;

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
        ChatMessage other = (ChatMessage) that;
        return (this.getChatMessageId() == null ? other.getChatMessageId() == null : this.getChatMessageId().equals(other.getChatMessageId()))
            && (this.getChatId() == null ? other.getChatId() == null : this.getChatId().equals(other.getChatId()))
            && (this.getContent() == null ? other.getContent() == null : this.getContent().equals(other.getContent()))
            && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getChatMessageId() == null) ? 0 : getChatMessageId().hashCode());
        result = prime * result + ((getChatId() == null) ? 0 : getChatId().hashCode());
        result = prime * result + ((getContent() == null) ? 0 : getContent().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", chatMessageId=").append(chatMessageId);
        sb.append(", chatId=").append(chatId);
        sb.append(", content=").append(content);
        sb.append(", type=").append(type);
        sb.append(", createTime=").append(createTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}