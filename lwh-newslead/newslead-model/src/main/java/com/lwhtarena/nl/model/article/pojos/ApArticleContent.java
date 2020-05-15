package com.lwhtarena.nl.model.article.pojos;

import com.lwhtarena.nl.model.annotation.IdEncrypt;
import lombok.Data;

/**
 * @author liwh
 * @Title: ApArticleContent
 * @Package com.lwhtarena.nl.model.article.pojos
 * @Description:
 * @Version 1.0.0
 * @date 2020/5/15 20:46
 */
@Data
public class ApArticleContent {
    private Integer id;
    // 增加注解，JSON序列化时自动混淆加密
    @IdEncrypt
    private Integer articleId;
    private String content;
}
