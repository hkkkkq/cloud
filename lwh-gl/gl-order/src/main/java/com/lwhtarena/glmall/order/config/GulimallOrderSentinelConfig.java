package com.lwhtarena.glmall.order.config;

import org.springframework.context.annotation.Configuration;

/**
 * @author liwh
 * @Title: GulimallOrderSentinelConfig
 * @Package com.lwhtarena.glmall.order.config
 * @Description: 自定义阻塞返回方法
 * @Version 1.0.0
 * @date 2020/9/9 16:52
 */

@Configuration
public class GulimallOrderSentinelConfig {

    public GulimallOrderSentinelConfig() {

//        WebCallbackManager.setUrlBlockHandler(new UrlBlockHandler() {
//            @Override
//            public void blocked(HttpServletRequest request, HttpServletResponse response, BlockException ex) throws IOException {
//                R error = R.error(BizCodeEnum.TO_MANY_REQUEST.getCode(), BizCodeEnum.TO_MANY_REQUEST.getMessage());
//                response.setCharacterEncoding("UTF-8");
//                response.setContentType("application/json");
//                response.getWriter().write(JSON.toJSONString(error));
//
//            }
//        });

    }

}
