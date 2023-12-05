package com.example.androidshop.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.androidshop.entity.po.Favorite;
import com.example.androidshop.entity.vo.FavoriteVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface FavoriteMapper extends BaseMapper<Favorite> {
    //    @Select("select * from favorite where user_id = #{userId}")
    Favorite queryFavorite(Long userId);

    List<FavoriteVO> listFavoriteByUserId(Long userId, Integer page, Integer size);
}