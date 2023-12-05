package com.example.androidshop.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.androidshop.entity.po.Chat;
import com.example.androidshop.entity.vo.ChatVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ChatMapper extends BaseMapper<Chat> {
    List<ChatVO> listChat(Long userId, Integer page, Integer size);
}