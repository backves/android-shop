package com.example.androidshop.controller;

import cn.hutool.core.lang.Validator;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.androidshop.entity.Address;
import com.example.androidshop.entity.Result;
import com.example.androidshop.service.AddressService;
import com.example.androidshop.utils.ThreadLocalUtil;
import lombok.NonNull;
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

    @PostMapping("/addAddress")
    public Result addAddress(@RequestBody @Validated(Address.Insert.class) Address address) {
        return addressService.addAddress(address);
    }

    @PutMapping("/updateAddress")
    public Result updateAddress(@RequestBody Address address) {
        return addressService.updateAddress(address);
    }
    @GetMapping("/listAddress")
    public Result listAddressByUserId(Long userId) {
        LambdaQueryWrapper<Address> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Address::getUserId, userId);
        return Result.success(addressService.list(wrapper));
    }
    @DeleteMapping("/deleteAddress")
    public Result deleteAddress(Long addressId) {
        return addressService.deleteAddress(addressId);
    }

}
