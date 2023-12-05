package com.example.androidshop.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.androidshop.entity.po.ChatMessage;
import com.example.androidshop.entity.po.Message;

import java.util.List;

public interface ChatMessageService extends IService<ChatMessage> {

    List<ChatMessage> listChatMessage(Long chatId, Integer page, Integer size);
}
