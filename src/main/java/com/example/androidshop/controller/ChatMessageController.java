package com.example.androidshop.controller;

import com.example.androidshop.entity.po.Chat;
import com.example.androidshop.entity.po.ChatMessage;
import com.example.androidshop.entity.po.Result;
import com.example.androidshop.service.ChatMessageService;
import com.example.androidshop.service.ChatService;
import com.example.androidshop.service.UserService;
import com.example.androidshop.utils.ThreadLocalUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/chatMessage")
@RequiredArgsConstructor
public class ChatMessageController {
    private final ChatService chatService;
    private final ChatMessageService chatMessageService;
    private final UserService userService;

    @PostMapping("/addChatMessage")
    public Result addChatMessage(@RequestBody @Validated ChatMessage chatMessage) {
        if (userService.getById(chatMessage.getSenderId()) == null || userService.getById(chatMessage.getReceiverId()) == null) {
            return Result.error("用户不存在");
        }

        Chat chat = chatService.getById(chatMessage.getChatId());

        if (chat == null) {
            return Result.error("聊天室不存在");
        }

        Map<String, Object> map = ThreadLocalUtil.get();
        Long userId = Long.valueOf(String.valueOf(map.get("id")));

        if (!(chat.getBuyerId().equals(userId) || chat.getSellerId().equals(userId))) {
            return Result.error("没有权限");
        }

        chatMessageService.save(chatMessage);

        return Result.success();
    }

    @GetMapping("/listChatMessage")
    public Result listChatMessage(Long chatId, Integer page, Integer size) {
        Chat chat = chatService.getById(chatId);

        if (chat == null) {
            return Result.error("聊天室不存在");
        }

        Map<String, Object> map = ThreadLocalUtil.get();
        Long userId = Long.valueOf(String.valueOf(map.get("id")));

        if (!(chat.getBuyerId().equals(userId) || chat.getSellerId().equals(userId))) {
            return Result.error("没有权限");
        }

        return Result.success(chatMessageService.listChatMessage(chatId, page, size));
    }
}
