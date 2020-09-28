package com.lwhtarena.red.commons.db.mapper;

import com.lwhtarena.red.commons.db.entity.CardUserHit;
import com.lwhtarena.red.commons.db.entity.CardUserHitExample;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

public interface CardUserHitMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table card_user_hit
     *
     * @mbg.generated
     */
    long countByExample(CardUserHitExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table card_user_hit
     *
     * @mbg.generated
     */
    int deleteByExample(CardUserHitExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table card_user_hit
     *
     * @mbg.generated
     */
    @Delete({
        "delete from card_user_hit",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table card_user_hit
     *
     * @mbg.generated
     */
    @Insert({
        "insert into card_user_hit (gameid, userid, ",
        "productid, hittime)",
        "values (#{gameid,jdbcType=INTEGER}, #{userid,jdbcType=INTEGER}, ",
        "#{productid,jdbcType=INTEGER}, #{hittime,jdbcType=TIMESTAMP})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insert(CardUserHit record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table card_user_hit
     *
     * @mbg.generated
     */
    int insertSelective(CardUserHit record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table card_user_hit
     *
     * @mbg.generated
     */
    List<CardUserHit> selectByExample(CardUserHitExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table card_user_hit
     *
     * @mbg.generated
     */
    @Select({
        "select",
        "id, gameid, userid, productid, hittime",
        "from card_user_hit",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @ResultMap("com.itheima.prize.commons.db.mapper.CardUserHitMapper.BaseResultMap")
    CardUserHit selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table card_user_hit
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") CardUserHit record, @Param("example") CardUserHitExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table card_user_hit
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") CardUserHit record, @Param("example") CardUserHitExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table card_user_hit
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(CardUserHit record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table card_user_hit
     *
     * @mbg.generated
     */
    @Update({
        "update card_user_hit",
        "set gameid = #{gameid,jdbcType=INTEGER},",
          "userid = #{userid,jdbcType=INTEGER},",
          "productid = #{productid,jdbcType=INTEGER},",
          "hittime = #{hittime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(CardUserHit record);
}