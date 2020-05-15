package com.lwhtarena.nl.model.article.pojos;

import com.lwhtarena.nl.model.annotation.DateConvert;
import lombok.Data;

import java.util.Date;

/**
 * @author liwh
 * @Title: ApAuthor
 * @Package com.lwhtarena.nl.model.article.pojos
 * @Description:
 * @Version 1.0.0
 * @date 2020/5/15 20:49
 */
@Data
public class ApAuthor {
    private Integer id;
    private String name;
    private Integer type;
    // APP社交账号
    private Long userId;
    // 自媒体管理账号
    private Long wmUserId;
    @DateConvert("yyyyMMddHHmmss")
    private Date createdTime;
}
