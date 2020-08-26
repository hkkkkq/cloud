package com.lwhtarena;

import com.lwhtarena.cg.utils.HttpClient;
import org.apache.http.impl.client.HttpClients;
import org.junit.Test;

import java.io.IOException;

/**
 * @author liwh
 * @Title: HttpClientTest
 * @Package com.lwhtarena
 * @Description: httpclient 工具类测试
 *
 * @Version 1.0.0
 * @date 2020/8/2 06:03
 */
public class HttpClientTest {

    @Test
    public void test() throws IOException {
        String url ="https://api.mch.wixin.qq.com/pay/orderquery";
        HttpClient httpClient = new HttpClient(url);

        String xml ="<xml><name>刘晶</name></xml>";

        httpClient.setHttps(true);//http|https
        httpClient.setXmlParam(xml);

        /**发送post请求**/
        httpClient.post();

        /**获取响应的结果**/
        String content = httpClient.getContent();



    }

}
