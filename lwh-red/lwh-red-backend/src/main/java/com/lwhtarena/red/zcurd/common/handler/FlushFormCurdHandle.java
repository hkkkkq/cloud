package com.lwhtarena.red.zcurd.common.handler;

import com.lwhtarena.red.zcurd.common.DbMetaTool;
import com.lwhtarena.red.zcurd.online.vo.ZcurdMeta;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;


/**
 * 刷新表单CurdHandle
 * @author 钟世云 2016.11.3
 */
public class FlushFormCurdHandle implements CurdHandle {

	@Override
	public void add(ZcurdMeta zcurdMeta, HttpServletRequest req, Map<String, String[]> paraMap) {
		//刷新扩展JS、按钮所属表单
		String[] headIdArr = paraMap.get("model.head_id");
		if(headIdArr != null && headIdArr.length > 0) {
			int fHeadId = Integer.parseInt(headIdArr[0]);
			DbMetaTool.updateMetaData(fHeadId);
		}
	}

	@Override
	public void update(ZcurdMeta zcurdMeta, HttpServletRequest req, Map<String, String[]> paraMap) {
		//刷新扩展JS、按钮所属表单
		String[] headIdArr = paraMap.get("model.head_id");
		if(headIdArr != null && headIdArr.length > 0) {
			int fHeadId = Integer.parseInt(headIdArr[0]);
			DbMetaTool.updateMetaData(fHeadId);
		}
		
	}

	@Override
	public void delete(ZcurdMeta zcurdMeta, HttpServletRequest req, Map<String, String[]> paraMap) {
		
	}

}
