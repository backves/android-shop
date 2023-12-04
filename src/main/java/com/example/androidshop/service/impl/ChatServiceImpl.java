package com.example.androidshop.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.androidshop.entity.Chat;
import com.example.androidshop.mapper.ChatMapper;
import com.example.androidshop.service.ChatService;
import org.springframework.stereotype.Service;

@Service
public class ChatServiceImpl extends ServiceImpl<ChatMapper, Chat>
    implements ChatService {

}




