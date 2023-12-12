package com.example.androidshop.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.androidshop.entity.po.Order;
import com.example.androidshop.entity.vo.OrderVO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface OrderMapper extends BaseMapper<Order> {

    List<OrderVO> listOrder(Long userId, Integer state, Boolean isSeller);

    OrderVO orderInfo(Long orderId);
}




