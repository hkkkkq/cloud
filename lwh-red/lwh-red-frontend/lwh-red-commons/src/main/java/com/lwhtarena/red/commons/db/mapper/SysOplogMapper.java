package com.lwhtarena.red.commons.db.mapper;

import com.lwhtarena.red.commons.db.entity.SysOplog;
import com.lwhtarena.red.commons.db.entity.SysOplogExample;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

public interface SysOplogMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_oplog
     *
     * @mbg.generated
     */
    long countByExample(SysOplogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_oplog
     *
     * @mbg.generated
     */
    int deleteByExample(SysOplogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_oplog
     *
     * @mbg.generated
     */
    @Delete({
        "delete from sys_oplog",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_oplog
     *
     * @mbg.generated
     */
    @Insert({
        "insert into sys_oplog (user_id, op_content, ",
        "ip, create_time)",
        "values (#{userId,jdbcType=INTEGER}, #{opContent,jdbcType=VARCHAR}, ",
        "#{ip,jdbcType=VARCHAR}, #{createTime,jdbcType=TIMESTAMP})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insert(SysOplog record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_oplog
     *
     * @mbg.generated
     */
    int insertSelective(SysOplog record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_oplog
     *
     * @mbg.generated
     */
    List<SysOplog> selectByExample(SysOplogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_oplog
     *
     * @mbg.generated
     */
    @Select({
        "select",
        "id, user_id, op_content, ip, create_time",
        "from sys_oplog",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @ResultMap("com.itheima.prize.commons.db.mapper.SysOplogMapper.BaseResultMap")
    SysOplog selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_oplog
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") SysOplog record, @Param("example") SysOplogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_oplog
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") SysOplog record, @Param("example") SysOplogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_oplog
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(SysOplog record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_oplog
     *
     * @mbg.generated
     */
    @Update({
        "update sys_oplog",
        "set user_id = #{userId,jdbcType=INTEGER},",
          "op_content = #{opContent,jdbcType=VARCHAR},",
          "ip = #{ip,jdbcType=VARCHAR},",
          "create_time = #{createTime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(SysOplog record);
}