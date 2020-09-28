package com.lwhtarena.red.zcurd.common.handler;

import com.lwhtarena.red.zcurd.online.vo.ZcurdMeta;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;


public interface CurdHandle {
	
	public void add(ZcurdMeta zcurdMeta, HttpServletRequest req, Map<String, String[]> paraMap);
	
	public void update(ZcurdMeta zcurdMeta, HttpServletRequest req, Map<String, String[]> paraMap);
	
	public void delete(ZcurdMeta zcurdMeta, HttpServletRequest req, Map<String, String[]> paraMap);

}
