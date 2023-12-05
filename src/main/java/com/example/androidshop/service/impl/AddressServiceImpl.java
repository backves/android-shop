package com.example.androidshop.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.androidshop.entity.po.Address;
import com.example.androidshop.mapper.AddressMapper;
import com.example.androidshop.service.AddressService;
import org.springframework.stereotype.Service;

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



