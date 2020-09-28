package com.lwhtarena.red.zcurd.account.model;

import java.util.List;

import com.zcurd.account.model.base.BaseSysMenuDatarule;

/**
 * Generated by JFinal.
 */
@SuppressWarnings("serial")
public class SysMenuDatarule extends BaseSysMenuDatarule<SysMenuDatarule> {
	public static final SysMenuDatarule dao = new SysMenuDatarule().dao();
	
	public List<SysMenuDatarule> findByRoleId(Integer roleId) {
		return find("select b.* from sys_role_datarule a join sys_menu_datarule b on a.datarule_id=b.id where a.role_id=?", roleId);
	}
}
