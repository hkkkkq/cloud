package com.lwhtarena.nl.model.article.dtos;

import com.lwhtarena.nl.model.annotation.IdEncrypt;
import lombok.Data;

/**
 * @author liwh
 * @Title: ArticleInfoDto
 * @Package com.lwhtarena.nl.model.article.dtos
 * @Description:
 * @Version 1.0.0
 * @date 2020/5/15 19:45
 */
@Data
public class ArticleInfoDto {
    // 设备ID
    @IdEncrypt
    Integer equipmentId;
    // 文章ID
    @IdEncrypt
    Integer articleId;
    // 作者ID
    @IdEncrypt
    Integer authorId;
}
