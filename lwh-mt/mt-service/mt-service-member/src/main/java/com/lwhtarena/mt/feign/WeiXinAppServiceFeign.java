package com.lwhtarena.mt.feign;

import com.lwhtarena.mt.service.WeiXinService;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author liwh
 * @Title: WeiXinAppServiceFeign
 * @Package com.lwhtarena.mt.feign
 * @Description:
 * @Version 1.0.0
 * @date 2020/5/16 23:37
 */
@FeignClient(name = "app-mt-weixin")
public interface WeiXinAppServiceFeign extends WeiXinService {
}
