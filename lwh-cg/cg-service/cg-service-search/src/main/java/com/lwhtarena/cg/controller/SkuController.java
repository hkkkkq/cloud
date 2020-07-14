package com.lwhtarena.cg.controller;

import com.lwhtarena.cg.entity.Result;
import com.lwhtarena.cg.entity.StatusCode;
import com.lwhtarena.cg.service.SkuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author liwh
 * @Title: SkuController
 * @Package com.lwhtarena.cg.controller
 * @Description:
 * @Version 1.0.0
 * @date 2020/7/13 21:22
 */
@RestController
@CrossOrigin
@RequestMapping("/search")
public class SkuController {

    @Autowired
    private SkuService skuService;

    @RequestMapping("/import")
    public Result importEs() {
        skuService.importEs();
        return new Result(true, StatusCode.OK, "导入成功");
    }

    /**
     *
     * @param searchMap  搜索的条件 map
     * @return  resultMap  返回的结果 map
     */
    @GetMapping
    public Map search(@RequestParam(required = false) Map<String,String> searchMap){
        return  skuService.search(searchMap);
    }
}
