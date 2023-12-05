package com.example.androidshop.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.androidshop.entity.po.Order;
import com.example.androidshop.mapper.OrderMapper;
import com.example.androidshop.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order>
        implements OrderService {
    @Autowired
    OrderMapper orderMapper;

    @Override
    public void Payment(Order order) {
        order.setState(2);
        updateById(order);
    }

    @Override
    public void confirmOrder(Order order) {
        order.setState(3);
        updateById(order);
    }

    @Override
    public void cancelOrder(Order order) {
        order.setState(0);
        updateById(order);
    }

    @Override
    public List<Order> listOrder(Long userId, Integer state, Boolean isSeller) {

//        LambdaQueryWrapper<Order> wrapperTemp = new LambdaQueryWrapper<Order>()
//                .eq(Order::getBuyerId, userId);
//
//        LambdaQueryWrapper<Order> wrapper = new LambdaQueryWrapper<Order>()
//                .eq(isSeller != null && isSeller, Order::getSellerId, userId)
//                .eq(isSeller != null && !isSeller, Order::getBuyerId, userId)
//                .eq(isSeller == null, Order::getSellerId, userId)
//                .eq(state != null, Order::getState, state);
        return orderMapper.listOrder(userId, state, isSeller);

    }
}




