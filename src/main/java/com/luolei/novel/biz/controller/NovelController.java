package com.luolei.novel.biz.controller;

import com.baomidou.mybatisplus.extension.conditions.query.QueryChainWrapper;
import com.luolei.novel.biz.domain.Novel;
import com.luolei.novel.biz.service.NovelService;
import com.luolei.novel.sys.annotation.Action;
import com.luolei.novel.sys.common.HttpResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NovelController {

    @Autowired
    private NovelService novelService;

    @RequestMapping("/queryNovel")
    @Action(name="查询")
    public HttpResult queryNovel(@RequestParam("key") String key){
        QueryChainWrapper<Novel> queryChainWrapper = novelService.query()
                .like("novel_name", key).
                        or().like("author", key);
        return HttpResult.success("成功",queryChainWrapper.list());
    }

    @RequestMapping("/addNovel")
    @Action(name="插入")
    public HttpResult addNovel(Novel novel){
        //这里故意造成一个其他异常，并且不进行处理
        Integer.parseInt("abc123");
        novelService.saveOrUpdate(novel);
        return HttpResult.success("成功");
    }
}
