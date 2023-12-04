package com.example.androidshop.service.impl;

import cn.hutool.core.lang.Validator;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.androidshop.entity.Address;
import com.example.androidshop.entity.Result;
import com.example.androidshop.mapper.AddressMapper;
import com.example.androidshop.service.AddressService;
import com.example.androidshop.utils.ThreadLocalUtil;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class AddressServiceImpl extends ServiceImpl<AddressMapper, Address>
        implements AddressService {
    @Override
    public Result addAddress(Address address) {
        Map<String, Object> map = ThreadLocalUtil.get();
        Long userId = Long.valueOf(String.valueOf(map.get("id")));

        address.setUserId(userId);

        if (count(new LambdaQueryWrapper<Address>().eq(Address::getUserId, address.getUserId())) >= 20) {
            return Result.error("最多添加20条地址");
        }

        if (!Validator.isMobile(address.getPhone())) {
            return Result.error("手机号格式不正确");
        }

        if (getOne(getWrapperToCheckRepetition(address)) != null) {
            return Result.error("该地址已存在");
        }

        save(address);
        return Result.success();
    }

    @Override
    public Result updateAddress(Address address) {

        if (!Validator.isMobile(address.getPhone())) {
            return Result.error("手机号格式不正确");
        }

        Map<String, Object> map = ThreadLocalUtil.get();
        Long userId = Long.valueOf(String.valueOf(map.get("id")));

        Address addressInDb = getById(address.getAddressId());

        if (addressInDb == null) {
            return Result.error("地址不存在");
        }

        if (!addressInDb.getUserId().equals(userId)) {
            return Result.error("没有权限");
        }

        if (getOne(getWrapperToCheckRepetition(address)) != null) {
            return Result.error("地址重复");
        }

        updateById(address);
        return Result.success();
    }

    @Override
    public Result deleteAddress(Long addressId) {

        Address address = getById(addressId);
        if (address == null) {
            return Result.error("地址不存在");
        }

        Map<String, Object> map = ThreadLocalUtil.get();
        Long userId = Long.valueOf(String.valueOf(map.get("id")));

        if (!address.getUserId().equals(userId)) {
            return Result.error("没有权限");
        }

        removeById(addressId);
        return Result.success();
    }

    private LambdaQueryWrapper<Address> getWrapperToCheckRepetition(Address address) {
        return new LambdaQueryWrapper<Address>()
                .eq(Address::getName, address.getName())
                .eq(Address::getUserId, address.getUserId())
                .eq(Address::getLocation, address.getLocation())
                .eq(Address::getDetail, address.getDetail())
                .eq(Address::getPhone, address.getPhone());
    }
}




