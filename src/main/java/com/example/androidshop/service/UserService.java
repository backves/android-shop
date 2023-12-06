package com.example.androidshop.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.androidshop.entity.po.User;

public interface UserService extends IService<User> {
    public User getUserByPhone(String phone);

    void removeAddress(Long userId);
}
