package com.example.androidshop.controller;

import com.example.androidshop.entity.po.ChatMessage;
import com.example.androidshop.entity.po.Goods;
import com.example.androidshop.entity.po.Order;
import com.example.androidshop.entity.po.Result;
import com.example.androidshop.service.ChatMessageService;
import com.example.androidshop.service.ChatService;
import com.example.androidshop.service.GoodsService;
import com.example.androidshop.service.OrderService;
import com.example.androidshop.utils.ThreadLocalUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;
    private final GoodsService goodsService;
    private final ChatService chatService;
    private final ChatMessageService chatMessageService;

    @PostMapping("/addOrder")
    public Result addOrder(@RequestBody @Validated(Order.Insert.class) Order order) {

        Goods goods = goodsService.getById(order.getGoodsId());

        if (goods == null) {
            return Result.error("商品不存在");
        }

        Map<String, Object> map = ThreadLocalUtil.get();
        Long userId = Long.valueOf(String.valueOf(map.get("id")));

        if (!order.getSellerId().equals(userId)) {
            return Result.error("卖家才能发送订单");
        }

        if (order.getBuyerId().equals(order.getSellerId())) {
            return Result.error("不能卖给自己");
        }

        if (order.getPrice().compareTo(BigDecimal.ZERO) <= 0) {
            return Result.error("价格不能为负数");
        }

        if (order.getPrice().compareTo(BigDecimal.valueOf(100000000000L)) > 0) {
            return Result.error("价格过大");
        }

        orderService.save(order);

        goods.setState(2);
        goodsService.updateById(goods);

        String message = "订单已生成，等待买家支付";
        Long chatId = chatService.getChat(order.getBuyerId(), order.getSellerId(), order.getGoodsId()).getChatId();
        ChatMessage chatMessage = new ChatMessage();
        chatMessage.setChatId(chatId);
        chatMessage.setSenderId(userId);
        chatMessage.setReceiverId(order.getBuyerId());
        chatMessage.setType(1);
        chatMessage.setContent(message);
        chatMessageService.save(chatMessage);

        return Result.success();
    }

    //订单未付款  1->订单未发货 2
    @PostMapping("/payOrder")
    public Result Payment(@RequestBody @Validated(Order.Buy.class) Order order) {

        Order orderInDb = orderService.getById(order.getOrderId());

        Map<String, Object> map = ThreadLocalUtil.get();
        Long userId = Long.valueOf(String.valueOf(map.get("id")));


        if (orderInDb == null) {
            return Result.error("订单不存在");
        }

        if (orderInDb.getState() == 0) {
            return Result.error("订单已取消");
        }

        if (orderInDb.getState() == 2) {
            return Result.error("订单已付款，无法付款");
        }

        if (orderInDb.getState() == 3) {
            return Result.error("订单已完成，无法付款");
        }

        if (!orderInDb.getBuyerId().equals(userId)) {
            return Result.error("不能付款");
        }

        orderService.PayOrder(order);

        String message = "已付款，等待交易完成";
        Long chatId = chatService.getChat(orderInDb.getBuyerId(), orderInDb.getSellerId(), orderInDb.getGoodsId()).getChatId();
        ChatMessage chatMessage = new ChatMessage();
        chatMessage.setChatId(chatId);
        chatMessage.setSenderId(userId);
        chatMessage.setReceiverId(order.getSellerId());
        chatMessage.setType(1);
        chatMessage.setContent(message);
        chatMessageService.save(chatMessage);

        return Result.success();
    }

    //订单未发货 2->订单已完成 3
    @PostMapping("/confirmOrder")
    public Result confirmOrder(Long orderId) {

        Order order = orderService.getById(orderId);

        if (order == null) {
            return Result.error("订单不存在");
        }

        if (order.getState() == 0) {
            return Result.error("订单已取消");
        }

        if (order.getState() == 3) {
            return Result.error("订单已完成，无法确认");
        }

        if (order.getState() == 1) {
            return Result.error("订单未付款，无法确认");
        }

        orderService.confirmOrder(order);

        Map<String, Object> map = ThreadLocalUtil.get();
        Long userId = Long.valueOf(String.valueOf(map.get("id")));

        if (!order.getBuyerId().equals(userId)) {
            return Result.error("您不是买家");
        }

        String message = "确认收货，交易已完成";
        Long chatId = chatService.getChat(order.getBuyerId(), order.getSellerId(), order.getGoodsId()).getChatId();
        ChatMessage chatMessage = new ChatMessage();
        chatMessage.setChatId(chatId);
        chatMessage.setReceiverId(order.getSellerId());
        chatMessage.setSenderId(userId);
        chatMessage.setType(1);
        chatMessage.setContent(message);
        chatMessageService.save(chatMessage);

        return Result.success();
    }

    //订单取消 0
    @DeleteMapping("/cancelOrder")
    public Result deleteOrder(Long orderId) {

        Order order = orderService.getById(orderId);

        if (order == null) {
            return Result.error("订单不存在");
        }
        if (order.getState() != 1) {
            return Result.error("订单已完成，无法取消");
        }

        orderService.cancelOrder(order);

        Map<String, Object> map = ThreadLocalUtil.get();
        Long userId = Long.valueOf(String.valueOf(map.get("id")));

        String message = "交易取消";
        Long chatId = chatService.getChat(order.getBuyerId(), order.getSellerId(), order.getGoodsId()).getChatId();
        ChatMessage chatMessage = new ChatMessage();
        chatMessage.setChatId(chatId);
        chatMessage.setSenderId(userId);
        chatMessage.setReceiverId(order.getBuyerId());
        chatMessage.setType(2);
        chatMessage.setContent(message);
        chatMessageService.save(chatMessage);


        return Result.success();
    }

    @GetMapping("/list")
    public Result list(Integer state, Boolean isSeller) {

        Map<String, Object> map = ThreadLocalUtil.get();
        Long userId = Long.valueOf(String.valueOf(map.get("id")));

        List<Order> orderList = orderService.listOrder(userId, state, isSeller);

        return Result.success(orderList);
    }

}