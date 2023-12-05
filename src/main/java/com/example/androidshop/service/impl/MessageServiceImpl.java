package com.example.androidshop.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.androidshop.entity.po.Message;
import com.example.androidshop.mapper.MessageMapper;
import com.example.androidshop.service.MessageService;
import org.springframework.stereotype.Service;

@Service
public class MessageServiceImpl extends ServiceImpl<MessageMapper, Message>
    implements MessageService {

}




