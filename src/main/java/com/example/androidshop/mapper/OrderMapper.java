package com.example.androidshop.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.androidshop.entity.po.Order;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface OrderMapper extends BaseMapper<Order> {
//    @Select("select * from `orders` where seller_id =#{userId} or buyer_id =#{userId}")
    List<Order> getOrderListByUserId(Long userId);
}




