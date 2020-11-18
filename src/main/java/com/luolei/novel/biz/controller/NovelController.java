package com.luolei.novel.biz.controller;

import com.baomidou.mybatisplus.extension.conditions.query.QueryChainWrapper;
import com.luolei.novel.biz.domain.Novel;
import com.luolei.novel.biz.service.NovelService;
import com.luolei.novel.sys.common.HttpResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NovelController {

    @Autowired
    private NovelService novelService;

    @RequestMapping("/queryNovel")
    public HttpResult queryNovel(String key){
        QueryChainWrapper<Novel> queryChainWrapper = novelService.query()
                .like("novel_name", key).
                        or().like("author", key);
        return HttpResult.success("成功",queryChainWrapper.list());
    }
}
