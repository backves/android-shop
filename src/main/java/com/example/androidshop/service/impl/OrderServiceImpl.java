package com.example.androidshop.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.androidshop.entity.Order;
import com.example.androidshop.mapper.OrderMapper;
import com.example.androidshop.service.OrderService;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order>
    implements OrderService {

}




