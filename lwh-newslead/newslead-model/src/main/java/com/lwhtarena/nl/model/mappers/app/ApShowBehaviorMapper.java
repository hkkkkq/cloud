package com.lwhtarena.nl.model.mappers.app;

import com.lwhtarena.nl.model.behavior.pojos.ApShowBehavior;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author liwh
 * @Title: ApShowBehaviorMapper
 * @Package com.lwhtarena.nl.model.mappers.app
 * @Description:
 * @Version 1.0.0
 * @date 2020/5/19 13:36
 */
public interface ApShowBehaviorMapper {
    List<ApShowBehavior> selectListByEntryIdAndArticleIds(@Param("entryId") Integer id, @Param("articleIds")Integer[] articleIds);

    void saveShowBehavior(@Param("articleIds") Integer[] articleIds, @Param("entryId") Integer entryId);

}
