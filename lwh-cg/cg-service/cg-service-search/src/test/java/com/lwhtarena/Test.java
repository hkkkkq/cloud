package com.lwhtarena;

import com.alibaba.fastjson.JSON;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author liwh
 * @Title: Test
 * @Package com.lwhtarena
 * @Description:
 * @Version 1.0.0
 * @date 2020/7/16 08:12
 */
public class Test {
    public static void main(String[] args) {
        String keyAsString ="{\"手机屏幕尺寸\":\"5.5寸\",\"网络\":\"电信4G\",\"颜色\":\"白\",\"测试\":\"s11\",\"机身内存\":\"128G\",\"存储\":\"16G\",\"像素\":\"300万像素\"}";

        Map<String, Set<String>> specMap = new HashMap<String, Set<String>>();
        Set<String> specValues = new HashSet<String>();

        Map<String, String> map = JSON.parseObject(keyAsString, Map.class);
        for (Map.Entry<String, String> stringStringEntry : map.entrySet()) {
            /**规格名称   手机屏幕尺寸**/
            String key = stringStringEntry.getKey();
            /**规格的名称对应的单个选项值 5.5寸**/
            String value = stringStringEntry.getValue();
            System.out.println("key="+key+";value="+value);

            specValues = specMap.get(key);
            if (specValues == null) {
                specValues = new HashSet<>();
            }
            specValues.add(value);
            specMap.put(key, specValues);
        }

        System.out.println(specMap.toString());
    }
}
