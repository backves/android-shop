package com.example.androidshop.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.androidshop.entity.po.Order;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface OrderMapper extends BaseMapper<Order> {

    List<Order> listOrder(Long userId, Integer state, Boolean isSeller);
}




