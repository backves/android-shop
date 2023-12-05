package com.example.androidshop.controller;

import com.example.androidshop.entity.po.Address;
import com.example.androidshop.entity.po.Goods;
import com.example.androidshop.entity.po.Order;
import com.example.androidshop.entity.po.Result;
import com.example.androidshop.service.GoodsService;
import com.example.androidshop.service.OrderService;
import com.example.androidshop.utils.ThreadLocalUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
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

    @PostMapping("/addOrder")
    public Result addOrder(@RequestBody @Validated(Order.Insert.class) Order order) {

        Goods goods = goodsService.getById(order.getGoodsId());
        if (goods == null) {
            return Result.error("商品不存在");
        }

        if (order.getBuyerId().equals(order.getSellerId())) {
            return Result.error("不能下单给自己");
        }

        if (order.getPrice().compareTo(BigDecimal.ZERO) <= 0) {
            return Result.error("价格不能为负数");
        }

        if (order.getPrice().compareTo(BigDecimal.valueOf(100000000000L)) > 0) {
            return Result.error("价格过大");
        }

        orderService.save(order);

        return Result.success();
    }

    //订单未付款  1->订单未发货 2
    @PostMapping("/PayOrder")
    public Result Payment(Long orderId) {

        Map<String, Object> map = ThreadLocalUtil.get();
        Long userId = Long.valueOf(String.valueOf(map.get("id")));


        Order order = orderService.getById(orderId);

        if (order == null) {
            return Result.error("订单不存在");
        }

        if (order.getState() == 0) {
            return Result.error("订单已取消");
        }

        if (order.getState() == 2) {
            return Result.error("订单已付款，无法付款");
        }

        if (order.getState() == 3) {
            return Result.error("订单已完成，无法付款");
        }
        if(!order.getBuyerId().equals(userId)){
            return Result.error("不能付款");
        }

        orderService.Payment(order);

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

        return Result.success();
    }

    //根据用户Id显示订单信息
    @GetMapping("/list")
    public Result list( Integer state, Boolean isSeller) {

        Map<String, Object> map = ThreadLocalUtil.get();
        Long userId = Long.valueOf(String.valueOf(map.get("id")));

        if (userId == null) {
            return Result.error("用户不存在");
        }

        List<Order> orderList = orderService.listOrder(userId, state, isSeller);

        return Result.success(orderList);
    }

}
