package com.example.androidshop.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.androidshop.entity.po.Order;

import java.util.List;

public interface OrderService extends IService<Order> {

//    void addOrder(Order order);
    void PayOrder(Order order);

    void confirmOrder(Order order);

    void cancelOrder(Order order);

    List<Order> listOrder(Long userId, Integer state, Boolean isSeller);
}
