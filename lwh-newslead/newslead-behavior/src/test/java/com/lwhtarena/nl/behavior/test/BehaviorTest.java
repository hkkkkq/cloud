package com.lwhtarena.nl.behavior.test;

import com.lwhtarena.nl.behavior.BehaviorJarApplication;
import com.lwhtarena.nl.behavior.service.AppShowBehaviorService;
import com.lwhtarena.nl.model.article.pojos.ApArticle;
import com.lwhtarena.nl.model.behavior.dtos.ShowBehaviorDto;
import com.lwhtarena.nl.model.user.pojos.ApUser;
import com.lwhtarena.nl.utils.threadlocal.AppThreadLocalUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.ArrayList;
import java.util.List;

/**
 * @author liwh
 * @Title: BehaviorTest
 * @Package com.lwhtarena.nl.behavior.test
 * @Description:
 * @Version 1.0.0
 * @date 2020/6/17 17:05
 */
@SpringBootTest(classes = BehaviorJarApplication.class)
@RunWith(SpringRunner.class)
public class BehaviorTest {

    @Autowired
    private AppShowBehaviorService appShowBehaviorService;

    @Test
    public void testSave(){
        ApUser user =new ApUser();
        user.setId(1l);
        AppThreadLocalUtils.setUser(user);
        ShowBehaviorDto dto =new ShowBehaviorDto();

        List<ApArticle> list =new ArrayList<>();
        ApArticle apArticle =new ApArticle();
        apArticle.setId(200);
        list.add(apArticle);

        appShowBehaviorService.saveShowBehavior(dto);
    }
}
