package com.lwhtarena.mt.service;

import org.springframework.web.servlet.support.RequestContext;

/**
 * @author liwh
 * @Title: LogSendService
 * @Package com.lwhtarena.mt.service
 * @Description:
 * @Version 1.0.0
 * @date 2020/5/19 20:15
 */
public interface LogSendService {
    /**
     * 往消息通道发消息
     *
     * @param requestContext requestContext
     */
    void send(RequestContext requestContext);
}
