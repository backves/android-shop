package com.example.androidshop.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.androidshop.entity.Comment;
import com.example.androidshop.mapper.CommentMapper;
import com.example.androidshop.service.CommentService;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment>
    implements CommentService {

}




