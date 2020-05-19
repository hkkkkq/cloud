package com.lwhtarena.nl.model.behavior.dtos;

import com.lwhtarena.nl.model.annotation.IdEncrypt;
import com.lwhtarena.nl.model.article.pojos.ApArticle;
import lombok.Data;

import java.util.List;

/**
 * @author liwh
 * @Title: ShowBehaviorDto
 * @Package com.lwhtarena.nl.model.behavior.dtos
 * @Description:
 * @Version 1.0.0
 * @date 2020/5/19 13:13
 */
@Data
public class ShowBehaviorDto {
    /**设备ID**/
    @IdEncrypt
    Integer equipmentId;

    List<ApArticle> articleIds;
}
