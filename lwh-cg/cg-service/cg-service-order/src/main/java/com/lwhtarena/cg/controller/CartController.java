package com.lwhtarena.cg.controller;

import com.lwhtarena.cg.constants.StatusCode;
import com.lwhtarena.cg.service.CartService;
import com.lwhtarena.cg.utils.TokenDecode;
import com.lwhtarena.cg.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;

/**
 * 描述 购物车
 *
 * @author www.itheima.com
 * @version 1.0
 * @since 1.0
 */
@RestController
@RequestMapping("/cart")
@CrossOrigin
public class CartController {

    @Autowired
    private CartService cartService;

    /**
     * 添加购物车
     *
     * @param id  要购买的商品的SKU的ID
     * @param num 要购买的数量
     * @return
     */
    @RequestMapping("/add")
    public Result add(Long id, Integer num) {
        //springsecurity 获取当前的用户名 传递service
//        String username = "changgou";

        /**用户的令牌信息-》解析令牌信息-》登录认证名 **/
        Map<String, String> userInfo = TokenDecode.getUserInfo();
        String username = userInfo.get("username");

        System.out.println("哇塞::用户名:"+username);

        cartService.add(id, num, username);
        return new Result(true, StatusCode.OK, "添加成功");

    }

    /**
     * 购物车列表
     * @return
     */
    @GetMapping("/list")
    public Map list() {
        //动态获取当前人信息,暂时静态
        //String username = "itcast";
        String username = TokenDecode.getUserInfo().get("username");
        Map map = cartService.list(username);
        return map;
    }


}
