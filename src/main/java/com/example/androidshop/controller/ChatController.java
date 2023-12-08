package com.example.androidshop.controller;

import com.example.androidshop.entity.po.Chat;
import com.example.androidshop.entity.po.ChatMessage;
import com.example.androidshop.entity.po.Goods;
import com.example.androidshop.entity.po.Result;
import com.example.androidshop.service.ChatMessageService;
import com.example.androidshop.service.ChatService;
import com.example.androidshop.service.GoodsService;
import com.example.androidshop.service.UserService;
import com.example.androidshop.utils.ThreadLocalUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/chat")
@RequiredArgsConstructor
public class ChatController {
    private final ChatService chatService;
    private final ChatMessageService chatMessageService;
    private final UserService userService;
    private final GoodsService goodsService;

    @Transactional
    @PostMapping("/addChat")
    public Result addChat(Long buyerId, Long sellerId, Long goodsId) {
        Chat chat = new Chat();

        if (userService.getById(buyerId) == null || userService.getById(sellerId) == null) {
            return Result.error("用户不存在");
        }

        Goods goods = goodsService.getById(goodsId);

        if (goods == null) {
            return Result.error("商品不存在");
        }

        if (buyerId.equals(sellerId)) {
            return Result.error("不能买自己的东西");
        }

        if (!((goods.getUserId().equals(buyerId) && goods.getType().equals("买")) || (goods.getUserId().equals(sellerId) && goods.getType().equals("卖")))) {
            return Result.error("开启聊天失败");
        }

        Chat chatInDb = chatService.getChat(buyerId, sellerId, goodsId);
        if (chatInDb != null) {
            return Result.success(chatInDb);
        }

        chat.setSellerId(sellerId);
        chat.setBuyerId(buyerId);
        chat.setGoodsId(goodsId);
        chatService.save(chat);

        Chat generagtedChat = chatService.getChat(buyerId, sellerId, goodsId);
        ChatMessage chatMessage = new ChatMessage();
        chatMessage.setChatId(generagtedChat.getChatId());
        chatMessage.setSenderId(buyerId);
        chatMessage.setReceiverId(sellerId);
        chatMessage.setContent("你好");
        chatMessageService.save(chatMessage);

        return Result.success(generagtedChat);
    }

    @GetMapping("/listChat")
    public Result getChatList(Integer page, Integer size) {

        Map<String, Object> map = ThreadLocalUtil.get();
        Long userId = Long.valueOf(String.valueOf(map.get("id")));

        return Result.success(chatService.listChat(userId, page, size));
    }
}
