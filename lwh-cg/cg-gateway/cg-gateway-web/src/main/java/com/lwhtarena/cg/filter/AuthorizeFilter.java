package com.lwhtarena.cg.filter;

import com.lwhtarena.cg.util.JwtUtil;
import io.jsonwebtoken.Claims;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpCookie;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @author liwh
 * @Title: AuthorizeFilter
 * @Package com.lwhtarena.cg.filter
 * @Description:  全局过滤器 :用于鉴权(获取令牌 解析 判断)
 * @Version 1.0.0
 * @date 2020/7/16 15:38
 */
@Component
public class AuthorizeFilter implements GlobalFilter, Ordered {
    /**令牌的名称**/
    private static final String AUTHORIZE_TOKEN = "Authorization";

    private static final String loginURL = "http://localhost:9001/oauth/login";

    /**
     * 全局拦截
     * @param exchange
     * @param chain
     * @return
     */
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {

        //1.获取请求对象
        ServerHttpRequest request = exchange.getRequest();
        //2.获取响应对象
        ServerHttpResponse response = exchange.getResponse();

        //3.判断 是否为登录的URL 如果是 放行
        if(UrlFilter.hasAutorize(request.getURI().toString())){
            return chain.filter(exchange);
        }
        //4.判断 是否为登录的URL 如果不是      权限校验

        /**
         * 获取用户令牌信息三个途径
         * 1）头文件中
         * 2）参数获取令牌
         * 3）Cookie中
         */
        //4.1 从头header中获取令牌数据
        String token = request.getHeaders().getFirst(AUTHORIZE_TOKEN);

        if(StringUtils.isEmpty(token)){
            //4.2 从cookie中中获取令牌数据
            HttpCookie first = request.getCookies().getFirst(AUTHORIZE_TOKEN);
            if(first!=null){
                token=first.getValue();//就是令牌的数据
            }
        }

        if(StringUtils.isEmpty(token)){
            //4.3 从请求参数中获取令牌数据
            token= request.getQueryParams().getFirst(AUTHORIZE_TOKEN);
        }

        if(StringUtils.isEmpty(token)){
            //4.4. 如果没有数据    没有登录,要重定向到登录到页面
            response.setStatusCode(HttpStatus.SEE_OTHER);//303 302
            //location 指定的就是路径
            response.getHeaders().set("Location",loginURL+"?From="+request.getURI().toString());
            return response.setComplete();
        }

        //5 解析令牌数据 ( 判断解析是否正确,正确 就放行 ,否则 结束)
//        try {
//            Claims claims = JwtUtil.parseJWT(token);
//        } catch (Exception e) {
//            e.printStackTrace();
//            //解析失败
//            response.setStatusCode(HttpStatus.UNAUTHORIZED);
//            return response.setComplete();
//        }
//        /**令牌为空，则允许访问，直接拦截 Bearer **/
//        if(StringUtils.isEmpty(token)){
//            /**设置没有权限的状态码**/
//            response.setStatusCode(HttpStatus.UNAUTHORIZED);
//            /**响应空数据**/
//            return response.setComplete();
//        }else{
//            /**判断当前令牌是否有Bearer前缀，如果没有，则添加前缀**/
//            if(!token.startsWith("Bearer ")&&!token.startsWith("bearer ")){
//                token ="Bearer "+token;
//            }
//        }


        /**
         * 添加头信息 传递给 各个微服务()
         * 将令牌封装到header-- ）Oauth2.0
         */
        request.mutate().header(AUTHORIZE_TOKEN,"Bearer "+ token);

        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
