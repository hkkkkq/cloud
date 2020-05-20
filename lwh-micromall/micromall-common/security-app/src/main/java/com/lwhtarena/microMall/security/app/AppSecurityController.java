//package com.lwhtarena.micromall.security.app;
//
//import com.lwhtarena.micromall.security.app.social.AppSingUpUtils;
//import org.springframework.http.HttpStatus;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ResponseStatus;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.context.request.ServletWebRequest;
//import sun.security.util.SecurityConstants;
//
//import javax.annotation.Resource;
//import javax.servlet.http.HttpServletRequest;
//
///**
// * The class App security controller.
// *
// * @author paascloud.net@gmail.comg
// */
//@RestController
//public class AppSecurityController extends BaseSocialController {
//
//	@Resource
//	private ProviderSignInUtils providerSignInUtils;
//
//	@Resource
//	private AppSingUpUtils appSingUpUtils;
//
//	/**
//	 * 需要注册时跳到这里，返回401和用户信息给前端
//	 *
//	 * @param request the request
//	 *
//	 * @return social user info
//	 */
//	@GetMapping(SecurityConstants.DEFAULT_SOCIAL_USER_INFO_URL)
//	@ResponseStatus(HttpStatus.UNAUTHORIZED)
//	public SocialUserInfo getSocialUserInfo(HttpServletRequest request) {
//		Connection<?> connection = providerSignInUtils.getConnectionFromSession(new ServletWebRequest(request));
//		appSingUpUtils.saveConnectionData(new ServletWebRequest(request), connection.createData());
//		return buildSocialUserInfo(connection);
//	}
//
//}
