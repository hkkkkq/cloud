package com.lwhtarena.mk.common.bean.xss;

import com.lwhtarena.mk.common.util.exception.CheckedException;
import org.apache.commons.lang3.StringUtils;

/**
 * @author liwh
 * @Title: SqlFilter
 * @Package com.lwhtarena.mk.common.bean.xss
 * @Description: SQL过滤
 * @Version 1.0.0
 * @date 2020/5/19 19:28
 */
public class SqlFilter {
    /**
     * SQL注入过滤
     * @param str  待验证的字符串
     */
    public static String sqlInject(String str){
        if(StringUtils.isBlank(str)){
            return null;
        }
        //去掉'|"|;|\字符
        str = StringUtils.replace(str, "'", "");
        str = StringUtils.replace(str, "\"", "");
        str = StringUtils.replace(str, ";", "");
        str = StringUtils.replace(str, "\\", "");

        //转换成小写
        str = str.toLowerCase();

        //非法字符
        String[] keywords = {"master", "truncate", "insert", "select", "delete", "update", "declare", "alert", "drop"};

        //判断是否包含非法字符
        for(String keyword : keywords){
            if(str.indexOf(keyword) != -1){
                throw new CheckedException("包含非法字符");
            }
        }

        return str;
    }
}
