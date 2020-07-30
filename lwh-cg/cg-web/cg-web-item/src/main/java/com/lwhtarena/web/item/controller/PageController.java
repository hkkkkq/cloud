package com.lwhtarena.web.item.controller;

import com.lwhtarena.cg.vo.Result;
import com.lwhtarena.cg.constants.StatusCode;
import com.lwhtarena.web.item.service.PageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liwh
 * @Title: PageController
 * @Package com.lwhtarena.web.item.controller
 * @Description:
 * @Version 1.0.0
 * @date 2020/7/15 20:34
 */
@RestController
@RequestMapping("/page")
public class PageController {

    @Autowired
    private PageService pageService;

    /**
     * 生成静态页面
     * @param id SPU的ID
     * @return
     */
    @RequestMapping("/createHtml/{id}")
    public Result createHtml(@PathVariable(name="id") Long id){
        pageService.createPageHtml(id);
        return new Result(true, StatusCode.OK,"ok");
    }
}
