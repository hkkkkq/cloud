package com.lwhtarena.red.commons.db.mapper;

import com.lwhtarena.red.commons.db.entity.SysMenuBtn;
import com.lwhtarena.red.commons.db.entity.SysMenuBtnExample;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

public interface SysMenuBtnMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_menu_btn
     *
     * @mbg.generated
     */
    long countByExample(SysMenuBtnExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_menu_btn
     *
     * @mbg.generated
     */
    int deleteByExample(SysMenuBtnExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_menu_btn
     *
     * @mbg.generated
     */
    @Delete({
        "delete from sys_menu_btn",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_menu_btn
     *
     * @mbg.generated
     */
    @Insert({
        "insert into sys_menu_btn (menu_id, btn_name, ",
        "class_name, method_name, ",
        "create_time)",
        "values (#{menuId,jdbcType=INTEGER}, #{btnName,jdbcType=VARCHAR}, ",
        "#{className,jdbcType=VARCHAR}, #{methodName,jdbcType=VARCHAR}, ",
        "#{createTime,jdbcType=TIMESTAMP})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insert(SysMenuBtn record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_menu_btn
     *
     * @mbg.generated
     */
    int insertSelective(SysMenuBtn record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_menu_btn
     *
     * @mbg.generated
     */
    List<SysMenuBtn> selectByExample(SysMenuBtnExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_menu_btn
     *
     * @mbg.generated
     */
    @Select({
        "select",
        "id, menu_id, btn_name, class_name, method_name, create_time",
        "from sys_menu_btn",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @ResultMap("com.itheima.prize.commons.db.mapper.SysMenuBtnMapper.BaseResultMap")
    SysMenuBtn selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_menu_btn
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") SysMenuBtn record, @Param("example") SysMenuBtnExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_menu_btn
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") SysMenuBtn record, @Param("example") SysMenuBtnExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_menu_btn
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(SysMenuBtn record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_menu_btn
     *
     * @mbg.generated
     */
    @Update({
        "update sys_menu_btn",
        "set menu_id = #{menuId,jdbcType=INTEGER},",
          "btn_name = #{btnName,jdbcType=VARCHAR},",
          "class_name = #{className,jdbcType=VARCHAR},",
          "method_name = #{methodName,jdbcType=VARCHAR},",
          "create_time = #{createTime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(SysMenuBtn record);
}