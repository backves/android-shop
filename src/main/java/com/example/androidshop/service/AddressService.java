package com.example.androidshop.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.androidshop.entity.po.Address;

public interface AddressService extends IService<Address> {
    Long countAddress(Long userId);

    Boolean checkRepetition(Address address);
}
