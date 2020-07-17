package com.lwhtarena.cg.filter;

/**
 * @author liwh
 * @Title: UrlFilter
 * @Package filter
 * @Description: 用户如果是登录、注册等（一些不需要做权限认证的请求，直接放行）
 * @Version 1.0.0
 * @date 2020/7/16 15:36
 */
public class UrlFilter {

    private static  final String nointerceterurl="/api/user/login,/api/user/add";
    /**
     * 用来判断 如果 当前的请求 在 放行的请求中存在,(不需要拦截 :true,否则需要拦截:false)
     * @return
     */
    public static boolean hasAutorize(String uri){
        String[] split = nointerceterurl.split(",");

        for (String s : split) {
            if(s.equals(uri)){
                //不需要拦截
                return true;
            }
        }

        //要拦截
        return false;
    }
}
