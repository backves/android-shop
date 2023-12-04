package com.example.androidshop.controller;

import cn.hutool.core.lang.Validator;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.androidshop.entity.Address;
import com.example.androidshop.entity.Result;
import com.example.androidshop.service.AddressService;
import com.example.androidshop.utils.ThreadLocalUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/address")
@RequiredArgsConstructor
public class AddressController {
    private final AddressService addressService;

    @PostMapping("/addAddress")
    public Result addAddress(@RequestBody @Validated(Address.Insert.class) Address address) {

        Map<String, Object> map = ThreadLocalUtil.get();
        Long userId = Long.valueOf(String.valueOf(map.get("id")));

        if (!Validator.isMobile(address.getPhone())) {
            return Result.error("手机号格式不正确");
        }
        address.setUserId(userId);
        addressService.save(address);
        return Result.success();
    }

    @PutMapping("/updateAddress")
    public Result updateAddress(@RequestBody Address address) {

        if (!Validator.isMobile(address.getPhone())) {
            return Result.error("手机号格式不正确");
        }

        LambdaQueryWrapper<Address> wrapper = new LambdaQueryWrapper<Address>()
                .eq(Address::getAddressId, address.getAddressId());

        System.out.println(wrapper.getSqlSegment());

        if (addressService.getOne(wrapper) == null) {
            return Result.error("地址不存在");
        }

        addressService.updateById(address);
        return Result.success();
    }
}
