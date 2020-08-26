package com.lwhtarena;

import com.github.wxpay.sdk.WXPay;
import com.github.wxpay.sdk.WXPayUtil;
import org.junit.Test;

import javax.xml.crypto.Data;
import java.util.HashMap;
import java.util.Map;

/**
 * @author liwh
 * @Title: WeiXinUtil
 * @Package com.lwhtarena
 * @Description: 微信支付demo
 * @Version 1.0.0
 * @date 2020/8/2 05:42
 */
public class WeiXinUtil {

    /**
     * 1、生成随机字符串
     * 2、将map转成xml字符串
     * 3、将map转成xml字符串（带签名）
     * 4、将xml转成map
     */
    @Test
    public void test001() throws Exception {
        String str = WXPayUtil.generateNonceStr();
        System.out.println("随机字符串："+str);

        Map<String,String> datamap =new HashMap<>();;
        datamap.put("id","NO.808080");
        datamap.put("title","畅购微信支付");
        datamap.put("money","999$");
        String xml = WXPayUtil.mapToXml(datamap);
        System.out.println(xml);

        /**将map转成xml字符串，并且生成签名**/
        String signedXml = WXPayUtil.generateSignedXml(datamap, "liwenhao");
        System.out.println("带签名的xml字符串："+signedXml);


        Map<String, String> toMap = WXPayUtil.xmlToMap(signedXml);
        System.out.println("xml转成map:"+toMap);

    }
}
