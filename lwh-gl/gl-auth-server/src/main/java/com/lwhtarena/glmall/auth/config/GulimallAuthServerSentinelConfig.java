package com.lwhtarena.glmall.auth.config;

//import com.alibaba.csp.sentinel.adapter.servlet.callback.UrlBlockHandler;
//import com.alibaba.csp.sentinel.adapter.servlet.callback.WebCallbackManager;
import com.alibaba.csp.sentinel.adapter.spring.webflux.callback.WebFluxCallbackManager;
import com.alibaba.csp.sentinel.adapter.spring.webmvc.callback.BlockExceptionHandler;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.fastjson.JSON;
import com.lwhtarena.common.exception.BizCodeEnume;
import com.lwhtarena.common.utils.R;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
/**
 * @author liwh
 * @Title: GulimallAuthServerSentinelConfig
 * @Package com.lwhtarena.glmall.auth.config
 * @Description: 自定义阻塞返回方法,自定义sentinel异常返回信息
 *
 *     public GulimallAuthServerSentinelConfig() {
 *
 *         WebCallbackManager.setUrlBlockHandler(new UrlBlockHandler() {
 *             @Override
 *             public void blocked(HttpServletRequest request, HttpServletResponse response, BlockException ex) throws IOException {
 *                 R error = R.error(BizCodeEnume.TO_MANY_REQUEST.getCode(), BizCodeEnume.TO_MANY_REQUEST.getMsg());
 *                 response.setCharacterEncoding("UTF-8");
 *                 response.setContentType("application/json");
 *                 response.getWriter().write(JSON.toJSONString(error));
 *
 *             }
 *         });
 *
 *     }
 *
 * sentinel找不到UrlBlockHandler接口解决方法
 * 最近在学习springcloud alibaba时候，需要sentinel进行流量管理控制，在统一处理返回异常时候，网上大多数教程都是继承
 * UrlBlockHandler这个方法，但是我在sentinel 1.8版本时候并没有找到这个接口，于是找了附近的源码，发现官方改成了
 * BlockExceptionHandler这个接口与实现。
 *
 * 解决方案：
 * 继承BlockExceptionHandler接口
 *
 * 具体代码如下：
 *
 * 自定义sentinel异常返回信息
 *@Component
 * public class MyUrlBlockHandler extends BaseController implements BlockExceptionHandler{
 *   @Override
 *   public void handle(HttpServletRequest request, HttpServletResponse response, BlockException ex) throws Exception {
 *      String msg = null;
 *      if (ex instanceof FlowException) {
 *          msg = "限流了";
 *      } else if (ex instanceof DegradeException) {
 *          msg = "降级了";
 *      } else if (ex instanceof ParamFlowException) {
 *          msg = "热点参数限流";
 *      } else if (ex instanceof SystemBlockException) {
 *          msg = "系统规则（负载/...不满足要求）";
 *      } else if (ex instanceof AuthorityException) {
 *          msg = "授权规则不通过";
 *      }
 *      // http状态码
 *      response.setStatus(500);
 *      response.setCharacterEncoding("utf-8");
 *      response.setHeader("Content-Type", "application/json;charset=utf-8");
 *      response.setContentType("application/json;charset=utf-8");
 *      // spring mvc自带的json操作工具，叫jackson
 *      new ObjectMapper()
 *              .writeValue(
 *                      response.getWriter(),
 *                     this.responseResult(RequestMsgEnum.Failtrue, msg)
 *             );
 *          }
 *      }
 * 注意：BaseController 此类是我自己写的定义类，自定义格式返回给前端，需要根据自己的需要修改
 *
 *  `Spring Cloud Alibaba Sentinel` 不再依赖 `sentinel-web-servlet` 实现，而是依赖 `sentinel-spring-webmvc-dapter` ,
 *  基于 Spring 的 `Interceptor` 拦截资源,而不再是 `CommonFilter`。
 * @Version 1.0.0
 * @date 2020/9/29 16:50
 */
@Configuration
public class GulimallAuthServerSentinelConfig {

    @Bean
    public BlockExceptionHandler sentinelBlockExceptionHandler() {
        return (request, response, e) -> {
            // 429 Too Many Requests
            response.setStatus(429);
            R error = R.error(BizCodeEnume.TO_MANY_REQUEST.getCode(), BizCodeEnume.TO_MANY_REQUEST.getMsg());
            response.setCharacterEncoding("UTF-8");
            response.setContentType("application/json");
            response.getWriter().write(JSON.toJSONString(error));
        };
    }
}
