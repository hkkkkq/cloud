package com.lwhtarena.nl.model.mappers.app;

import com.lwhtarena.nl.model.behavior.pojos.ApBehaviorEntry;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author liwh
 * @Title: ApBehaviorEntryMapper
 * @Package com.lwhtarena.nl.model.mappers.app
 * @Description:
 * @Version 1.0.0
 * @date 2020/5/15 20:39
 */
public interface ApBehaviorEntryMapper {
    ApBehaviorEntry selectByUserIdOrEquipemntId(@Param("userId") Long userId, @Param("equipmentId") Integer equipmentId);

    List<ApBehaviorEntry> selectAllEntry();
}
