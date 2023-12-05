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

/**
 * @TableName chat_message
 */
@TableName(value = "chat_message")
@Data
@NoArgsConstructor
public class ChatMessage implements Serializable {
    @TableId(type = IdType.AUTO)
    private Long chatMessageId;
    @NotNull(groups = Insert.class)
    private Long chatId;
    @NotNull(groups = Insert.class)
    private Long senderId;
    @NotNull(groups = Insert.class)
    private Long receiverId;
    @NotNull(groups = Insert.class)
    private String content;
    private Integer type;
    private Date createTime;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    public interface Insert {
    }
}