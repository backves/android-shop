package com.example.androidshop.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.androidshop.entity.User;

public interface UserService extends IService<User> {
    public User getUserByPhone(String phone);
}
