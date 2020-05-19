package com.lwhtarena.mk.common.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author liwh
 * @Title: SysRole
 * @Package com.lwhtarena.mk.common.vo
 * @Description:
 * @Version 1.0.0
 * @date 2020/5/19 18:01
 */
@Data
public class SysRole implements Serializable {
    private Integer roleId;
    private String roleName;
    private String roleCode;
    private String roleDesc;
    private Date createTime;
    private Date updateTime;
    private String delFlag;
}
