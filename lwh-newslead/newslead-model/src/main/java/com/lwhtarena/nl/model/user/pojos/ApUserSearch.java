package com.lwhtarena.nl.model.user.pojos;

import com.lwhtarena.nl.model.annotation.IdEncrypt;
import lombok.Data;

import java.util.Date;

/**
 * @author liwh
 * @Title: ApUserSearch
 * @Package com.lwhtarena.nl.model.user.pojos
 * @Description:
 * @Version 1.0.0
 * @date 2020/5/15 19:48
 */
@Data
public class ApUserSearch {
    private Integer id;
    @IdEncrypt
    private Integer entryId;
    private String keyword;
    private Integer status;
    private Date createdTime;
}
