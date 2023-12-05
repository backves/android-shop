package com.example.androidshop.controller;

import cn.hutool.core.lang.Validator;
import com.example.androidshop.entity.po.Result;
import com.example.androidshop.entity.po.User;
import com.example.androidshop.service.AddressService;
import com.example.androidshop.service.UserService;
import com.example.androidshop.utils.JwtUtil;
import com.example.androidshop.utils.Md5Util;
import com.example.androidshop.utils.ShortUuidUtil;
import com.example.androidshop.utils.ThreadLocalUtil;
import jakarta.validation.constraints.Pattern;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private final AddressService addressService;

    @PostMapping("/register")
    public Result register(String phone, @Pattern(regexp = "^\\S{5,16}$") String password) {

        if (!Validator.isMobile(phone)) {
            return Result.error("手机号不正确");
        }

        User user = userService.getUserByPhone(phone);

        if (user != null) {
            return Result.error("用户已存在");
        }

        User newUser = new User();

        newUser.setUsername("sly_" + ShortUuidUtil.generateUuid16());
        newUser.setPassword(Md5Util.getMD5String(password));
        newUser.setPhone(phone);

        userService.save(newUser);

        return Result.success();
    }

    @PostMapping("/login")
    public Result login(String phone, String password) {

        if (!Validator.isMobile(phone)) {
            return Result.error("手机号不正确");
        }

        User user = userService.getUserByPhone(phone);
        if (user == null) {
            return Result.error("用户不存在");
        }

        if (!user.getPassword().equals(Md5Util.getMD5String(password))) {
            return Result.error("密码错误");
        }

        Map<String, Object> claims = new HashMap<>();
        claims.put("id", user.getUserId());
        claims.put("phone", user.getPhone());
        String token = JwtUtil.genToken(claims);

        return Result.success(token);
    }

    @PostMapping("/setDefaultAddress")
    public Result setDefaultAddress(Long addressId) {
        Map<String, Object> map = ThreadLocalUtil.get();
        Long userId = Long.valueOf(String.valueOf(map.get("id")));

        if (!addressService.getById(addressId).getUserId().equals(userId)) {
            return Result.error("没有权限");
        }

        User user = new User();
        user.setUserId(userId);
        user.setAddressId(addressId);

        userService.updateById(user);

        return Result.success();
    }

    @GetMapping("/userInfo")
    public Result userInfo() {
        Map<String, Object> map = ThreadLocalUtil.get();
        Long userId = Long.valueOf(String.valueOf(map.get("id")));

        User user = userService.getById(userId);

        return Result.success(user);
    }

    @GetMapping("/test")
    public Result test() {
        return Result.success("test successfully");
    }
}
