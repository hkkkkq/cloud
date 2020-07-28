package com.lwhtarena.glmall.member.dao;

import com.lwhtarena.glmall.member.entity.MemberEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 会员
 * 
 * @author liwh
 * @email lwhtarena@gmail.com
 * @date 2020-07-25 13:41:48
 */
@Mapper
public interface MemberDao extends BaseMapper<MemberEntity> {
	
}
