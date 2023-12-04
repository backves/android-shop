package com.example.androidshop.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.androidshop.entity.Address;
import com.example.androidshop.entity.Result;

public interface AddressService extends IService<Address> {

    Result addAddress(Address address);

    Result updateAddress(Address address);

    Result deleteAddress(Long addressId);
}
