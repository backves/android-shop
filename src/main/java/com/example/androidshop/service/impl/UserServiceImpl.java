package com.example.androidshop.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.androidshop.entity.User;
import com.example.androidshop.mapper.UserMapper;
import com.example.androidshop.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
        implements UserService {
}




