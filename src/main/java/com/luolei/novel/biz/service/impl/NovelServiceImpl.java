package com.luolei.novel.biz.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.luolei.novel.biz.domain.Novel;
import com.luolei.novel.biz.mapper.NovelMapper;
import com.luolei.novel.biz.service.NovelService;
import org.springframework.stereotype.Service;

@Service
public class NovelServiceImpl extends ServiceImpl<NovelMapper, Novel> implements NovelService {

}
