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
    public Long countAddress(Long userId) {
        return count(new LambdaQueryWrapper<Address>().eq(Address::getUserId, userId));
    }

    @Override
    public Boolean checkRepetition(Address address) {
        LambdaQueryWrapper<Address> wrapper = new LambdaQueryWrapper<Address>()
                .eq(Address::getName, address.getName())
                .eq(Address::getUserId, address.getUserId())
                .eq(Address::getLocation, address.getLocation())
                .eq(Address::getDetail, address.getDetail())
                .eq(Address::getPhone, address.getPhone());
        return this.baseMapper.exists(wrapper);
    }
}




