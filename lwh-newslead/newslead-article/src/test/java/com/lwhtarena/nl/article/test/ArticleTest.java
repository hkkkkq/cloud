package com.lwhtarena.nl.article.test;

import com.lwhtarena.nl.article.ArticleJarApplication;
import com.lwhtarena.nl.article.service.AppArticleService;
import com.lwhtarena.nl.common.article.constans.ArticleConstans;
import com.lwhtarena.nl.model.article.dtos.ArticleHomeDto;
import com.lwhtarena.nl.model.common.dtos.ResponseResult;
import com.lwhtarena.nl.model.user.pojos.ApUser;
import com.lwhtarena.nl.utils.threadlocal.AppThreadLocalUtils;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author liwh
 * @Title: ArticleTest
 * @Package com.lwhtarena.nl.article.test
 * @Description:
 * @Version 1.0.0
 * @date 2020/5/15 23:02
 */
@SpringBootTest(classes = ArticleJarApplication.class)
@RunWith(SpringRunner.class)
public class ArticleTest {
    @Autowired
    private AppArticleService appArticleService;

    @Test
    public void testArticle(){
        ApUser apUser = new ApUser();
        apUser.setId(2104l);
        AppThreadLocalUtils.setUser(apUser);
        ArticleHomeDto dto = new ArticleHomeDto();
        dto.setTag("3");
        ResponseResult result = appArticleService.loadV2(ArticleConstans.LOADTYPE_LOAD_MORE, null,true);
        System.out.println(result.getData());
    }
}
