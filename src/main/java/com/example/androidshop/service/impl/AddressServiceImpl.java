package com.example.androidshop.service.impl;

import cn.hutool.core.lang.Validator;
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
    public void addAddress(Address address) {
        Map<String, Object> map = ThreadLocalUtil.get();
        Long userId = Long.valueOf(String.valueOf(map.get("id")));

        address.setUserId(userId);
        save(address);
    }
}




