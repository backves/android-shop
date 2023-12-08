package com.example.androidshop.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.androidshop.entity.po.GoodsImg;
import com.example.androidshop.entity.vo.GoodsImgVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface GoodsImgMapper extends BaseMapper<GoodsImg> {

    List<GoodsImgVO> listByGoodsId(Long goodsId);
}




