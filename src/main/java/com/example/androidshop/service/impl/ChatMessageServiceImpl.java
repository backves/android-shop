package com.example.androidshop.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.androidshop.entity.po.ChatMessage;
import com.example.androidshop.entity.po.Message;
import com.example.androidshop.mapper.ChatMessageMapper;
import com.example.androidshop.service.ChatMessageService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChatMessageServiceImpl extends ServiceImpl<ChatMessageMapper, ChatMessage>
        implements ChatMessageService {

    @Override
    public List<ChatMessage> listChatMessage(Long chatId, Integer page, Integer size) {
        if (page == null) {
            page = 1;
        }
        if (size == null) {
            size = 20;
        }
        Page<ChatMessage> p = Page.of(page, size);
        LambdaQueryWrapper<ChatMessage> wrapper = new LambdaQueryWrapper<ChatMessage>()
                .eq(ChatMessage::getChatId, chatId)
                .orderByDesc(ChatMessage::getCreateTime);

        return baseMapper.selectPage(p, wrapper).getRecords();
    }
}




