package com.lwhtarena.red.zcurd.account.common.interceptor;

import com.jfinal.aop.Interceptor;
import com.jfinal.aop.Invocation;
import com.lwhtarena.red.zcurd.account.common.kit.ZcurdKit;

public class SessionInterceptor implements Interceptor {
	
	@Override
	public void intercept(Invocation inv) {
		ZcurdKit.putSession(inv.getController().getSession(true));
		try {
			inv.invoke();
		} finally {
			ZcurdKit.removeSession();
		}
	}
}