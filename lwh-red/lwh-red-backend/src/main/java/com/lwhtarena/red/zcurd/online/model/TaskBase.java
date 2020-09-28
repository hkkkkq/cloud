package com.lwhtarena.red.zcurd.online.model;

import com.lwhtarena.red.zcurd.common.DbMetaTool;
import com.lwhtarena.red.zcurd.online.model.base.BaseTaskBase;
import java.util.Map;


public class TaskBase extends BaseTaskBase<TaskBase> {
	private static final long serialVersionUID = 1L;
	public static final TaskBase me = new TaskBase();
	
	public Map<String, Object> getDictDatatarget_type() {
		return DbMetaTool.getDictData("select dict_key, dict_value from sys_dict where dict_type='task_type'");
	}	
		
	public Map<String, Object> getDictDatastatus() {
		return DbMetaTool.getDictData("select dict_key, dict_value from sys_dict where dict_type='task_statu'");
	}
}
