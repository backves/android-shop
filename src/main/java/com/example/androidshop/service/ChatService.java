package com.example.androidshop.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.androidshop.entity.po.Chat;
import com.example.androidshop.entity.vo.ChatVO;

import java.util.List;

public interface ChatService extends IService<Chat> {

    List<ChatVO> listChat(Long userId, Integer page, Integer size);

    Chat getChat(Long buyerId, Long sellerId, Long goodsId);
}
