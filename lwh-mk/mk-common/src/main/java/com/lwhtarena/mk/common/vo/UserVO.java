package com.lwhtarena.mk.common.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author liwh
 * @Title: UserVO
 * @Package com.lwhtarena.mk.common.vo
 * @Description:
 * @Version 1.0.0
 * @date 2020/5/19 18:01
 */
@Data
public class UserVO implements Serializable {
    /**
     * 主键ID
     */
    private Integer userId;
    /**
     * 用户名
     */
    private String username;
    /**
     * 密码
     */
    private String password;
    /**
     * 随机盐
     */
    private String salt;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 修改时间
     */
    private Date updateTime;
    /**
     * 0-正常，1-删除
     */
    private String delFlag;
    /**
     * 简介
     */
    private String phone;
    /**
     * 头像
     */
    private String avatar;

    /**
     * 部门ID
     */
    private Integer deptId;
    /**
     * 部门名称
     */
    private String deptName;

    /**
     * 角色列表
     */
    private List<SysRole> roleList;
}
