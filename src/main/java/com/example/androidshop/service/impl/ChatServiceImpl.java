package com.example.androidshop.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.androidshop.entity.po.Chat;
import com.example.androidshop.entity.vo.ChatVO;
import com.example.androidshop.mapper.ChatMapper;
import com.example.androidshop.service.ChatService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ChatServiceImpl extends ServiceImpl<ChatMapper, Chat>
        implements ChatService {
    private final ChatMapper chatMapper;

    @Override
    public List<ChatVO> listChat(Long userId, Integer page, Integer size) {
        if (page == null) {
            page = 0;
        }
        if (size == null) {
            size = 20;
        }

        return chatMapper.listChat(userId, page * size, size);
    }

    @Override
    public Chat getChat(Long buyerId, Long sellerId, Long goodsId) {

        LambdaQueryWrapper<Chat> queryWrapper = new LambdaQueryWrapper<Chat>()
                .eq(Chat::getBuyerId, buyerId)
                .eq(Chat::getSellerId, sellerId)
                .eq(Chat::getGoodsId, goodsId);

        System.out.println(queryWrapper.getSqlSegment());

        return getOne(queryWrapper);
    }
}




