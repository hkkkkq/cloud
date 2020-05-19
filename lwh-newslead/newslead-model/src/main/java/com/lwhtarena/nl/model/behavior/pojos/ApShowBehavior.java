package com.lwhtarena.nl.model.behavior.pojos;

import lombok.Data;

import java.util.Date;

/**
 * @author liwh
 * @Title: ApShowBehavior
 * @Package com.lwhtarena.nl.model.behavior.pojos
 * @Description:
 * @Version 1.0.0
 * @date 2020/5/19 13:32
 */
@Data
public class ApShowBehavior {
    private Integer id;
    private Integer entryId;
    private Integer articleId;
    private Boolean isClick;
    private Date showTime;
    private Date createdTime;
}
