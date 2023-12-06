package com.example.androidshop.controller;

import cn.hutool.core.lang.Validator;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.androidshop.entity.po.Address;
import com.example.androidshop.entity.po.Result;
import com.example.androidshop.entity.po.User;
import com.example.androidshop.service.AddressService;
import com.example.androidshop.service.UserService;
import com.example.androidshop.utils.Md5Util;
import com.example.androidshop.utils.ThreadLocalUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/address")
@RequiredArgsConstructor
public class AddressController {
    private final AddressService addressService;
    private final UserService userService;

    @PostMapping("/addAddress")
    public Result addAddress(@RequestBody @Validated(Address.Insert.class) Address address) {

        if (!Validator.isMobile(address.getPhone())) {
            return Result.error("手机号格式不正确");
        }

        Map<String, Object> map = ThreadLocalUtil.get();
        Long userId = Long.valueOf(String.valueOf(map.get("id")));

        address.setUserId(userId);

        if (addressService.countAddress(userId) >= 20) {
            return Result.error("最多添加20条地址");
        }

        if (addressService.checkRepetition(address)) {
            return Result.error("该地址已存在");
        }

        addressService.save(address);

        return Result.success();
    }


    @PutMapping("/updateAddress")
    public Result updateAddress(@RequestBody Address address) {

        if (!Validator.isMobile(address.getPhone())) {
            return Result.error("手机号格式不正确");
        }

        Address addressInDb = addressService.getById(address.getAddressId());

        if (addressInDb == null) {
            return Result.error("地址不存在");
        }

        checkAuth(addressInDb);

        addressService.updateById(address);

        return Result.success();
    }

    @GetMapping("/listAddress")
    public Result listAddressByUserId() {

        Map<String, Object> map = ThreadLocalUtil.get();
        Long userId = Long.valueOf(String.valueOf(map.get("id")));

        LambdaQueryWrapper<Address> wrapper = new LambdaQueryWrapper<Address>()
                .eq(Address::getUserId, userId);

        List<Address> addressList = addressService.list(wrapper);

        return Result.success(addressList);
    }

    @DeleteMapping("/deleteAddress")
    public Result deleteAddress(Long addressId) {

        Address address = addressService.getById(addressId);

        if (address == null) {
            return Result.error("地址不存在");
        }

        Map<String, Object> map = ThreadLocalUtil.get();
        Long userId = Long.valueOf(String.valueOf(map.get("id")));

        if (!address.getUserId().equals(userId)) {
            return Result.error("无权限删除该地址");
        }

        checkAuth(address);

        User user = userService.getById(userId);
        if (user.getAddressId().equals(addressId)) {
            userService.removeAddress(userId);
        }

        addressService.removeById(addressId);

        return Result.success();
    }

    @PostMapping("/updatePwd")
    public Result updatePwd(String oldPwd, String newPwd, String rePwd) {

        Map<String, Object> map = ThreadLocalUtil.get();
        Long userId = Long.valueOf(String.valueOf(map.get("id")));

        User user = userService.getById(userId);

        if (!user.getPassword().equals(Md5Util.getMD5String(oldPwd))) {
            return Result.error("原密码错误");
        }

        if (!newPwd.equals(rePwd)) {
            return Result.error("两次密码不一致");
        }

        user.setPassword(newPwd);
        userService.updateById(user);

        return Result.success();
    }

    private void checkAuth(Address address) {
        Map<String, Object> map = ThreadLocalUtil.get();
        Long userId = Long.valueOf(String.valueOf(map.get("id")));

        if (!address.getUserId().equals(userId)) {
            throw new RuntimeException("没有权限");
        }
    }
}
