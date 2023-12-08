package com.example.androidshop.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.androidshop.entity.po.GoodsImg;
import com.example.androidshop.entity.vo.GoodsImgVO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface GoodsImgService extends IService<GoodsImg> {

    List<GoodsImgVO> listByGoodsId(Long goodsId);
}
