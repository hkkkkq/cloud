package com.lwhtarena.cg.user.feign;

import com.lwhtarena.cg.vo.Result;
import com.lwhtarena.cg.user.pojo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author liwh
 * @Title: UserFeign
 * @Package com.lwhtarena.cg.feign
 * @Description: user微服务
 * @Version 1.0.0
 * @date 2020/7/16 18:54
 */
@FeignClient(name="user")
@RequestMapping("/user")
public interface UserFeign {

    @GetMapping("/load/{id}")
    public Result<User> findByUsername(@PathVariable(name="id") String id);


    /**
     * 添加积分
     * @param points
     * @param username
     * @return
     */
    @GetMapping(value = "/points/add")
    public Result addPoints(@RequestParam(value="points") Integer points, @RequestParam(value="username") String username );
}
