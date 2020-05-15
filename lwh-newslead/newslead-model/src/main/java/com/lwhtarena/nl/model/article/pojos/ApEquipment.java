package com.lwhtarena.nl.model.article.pojos;

import lombok.Data;

import java.util.Date;

/**
 * @author liwh
 * @Title: ApEquipment
 * @Package com.lwhtarena.nl.model.article.pojos
 * @Description:
 * @Version 1.0.0
 * @date 2020/5/15 20:52
 */
@Data
public class ApEquipment {
    private Integer id;
    private Boolean type;
    private String version;
    private String sys;
    private String no;
    private Date createdTime;

}
