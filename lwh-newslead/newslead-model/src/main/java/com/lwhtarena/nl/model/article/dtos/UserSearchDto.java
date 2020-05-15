package com.lwhtarena.nl.model.article.dtos;

import com.lwhtarena.nl.model.annotation.IdEncrypt;
import com.lwhtarena.nl.model.user.pojos.ApUserSearch;
import lombok.Data;

import java.util.List;

/**
 * @author liwh
 * @Title: UserSearchDto
 * @Package com.lwhtarena.nl.model.article.dtos
 * @Description:
 * @Version 1.0.0
 * @date 2020/5/15 19:46
 */
@Data
public class UserSearchDto {
    // 设备ID
    @IdEncrypt
    Integer equipmentId;
    String searchWords;
    //查询tag: all, article, login, author
    String tag;
    List<ApUserSearch> hisList;
    String hotDate;
    int pageNum;
    int pageSize;

    public int getFromIndex(){
        if(this.pageNum<1)return 0;
        if(this.pageSize<1) this.pageSize = 10;
        return this.pageSize * (pageNum-1);
    }
}
