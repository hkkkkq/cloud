package com.lwhtarena.red.zcurd.online.controller;

import java.util.List;

import com.jfinal.core.Controller;
import com.lwhtarena.red.zcurd.account.common.annotation.ClearAuth;
import com.lwhtarena.red.zcurd.account.model.SysUser;
import com.lwhtarena.red.zcurd.account.service.AuthService;

@ClearAuth
public class MainController extends Controller {
	
	public void index() {
		render("main.html");
	}

	public void urls() {
		AuthService authService = enhance(AuthService.class);
		List<String> urls = authService.getAuthUrl(SysUser.dao.findById(getParaToInt("id")));
		urls.addAll(authService.getAuthBtnUrl(SysUser.dao.findById(getParaToInt("id"))));
		renderJson(urls);
	}
	
	public void btns() {
		AuthService authService = enhance(AuthService.class);
		renderJson(authService.getNoAuthPageBtn(SysUser.dao.findById(getParaToInt("id"))));
	}
	
	public void rules() {
		AuthService authService = enhance(AuthService.class);
		renderJson(authService.getAuthDataRule(SysUser.dao.findById(getParaToInt("id"))));
	}
	
	public void menus() {
		AuthService authService = enhance(AuthService.class);
		renderJson(authService.getAuthMenuForTree(SysUser.dao.findById(getParaToInt("id"))));
	}
}
