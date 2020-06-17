//package com.lwhtarena.micromall.security.server;
//
//import com.lwhtarena.micromall.security.app.authentication.openid.OpenIdAuthenticationSecurityConfig;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import javax.annotation.Resource;
//import javax.sql.DataSource;
//
///**
// * 资源服务器配置
// *
// * @author paascloud.net @gmail.com
// */
//@Configuration
//@EnableResourceServer
//public class PcResourceServerConfig extends ResourceServerConfigurerAdapter {
//
//	@Autowired
//	private OAuth2WebSecurityExpressionHandler pcSecurityExpressionHandler;
//
//	@Autowired
//	private AccessDeniedHandler pcAccessDeniedHandler;
//
//	@Autowired
//	protected AuthenticationSuccessHandler pcAuthenticationSuccessHandler;
//
//	@Autowired
//	protected AuthenticationFailureHandler pcAuthenticationFailureHandler;
//
//	@Autowired
//	private SmsCodeAuthenticationSecurityConfig smsCodeAuthenticationSecurityConfig;
//
//	@Autowired
//	private ValidateCodeSecurityConfig validateCodeSecurityConfig;
//
//	@Autowired
//	private SpringSocialConfigurer pcSocialSecurityConfig;
//
//	@Autowired
//	private AuthorizeConfigManager authorizeConfigManager;
//
//	@Autowired
//	private FormAuthenticationConfig formAuthenticationConfig;
//
//	@Autowired
//	private OpenIdAuthenticationSecurityConfig openIdAuthenticationSecurityConfig;
//
//	@Resource
//	private DataSource dataSource;
//
//	/**
//	 * 记住我功能的token存取器配置
//	 *
//	 * @return the persistent token repository
//	 */
//	@Bean
//	public PersistentTokenRepository persistentTokenRepository() {
//		JdbcTokenRepositoryImpl tokenRepository = new JdbcTokenRepositoryImpl();
//		tokenRepository.setDataSource(dataSource);
////		tokenRepository.setCreateTableOnStartup(true); // 第一次启动创建
//		return tokenRepository;
//	}
//
//	/**
//	 * Configure.
//	 *
//	 * @param http the http
//	 *
//	 * @throws Exception the exception
//	 */
//	@Override
//	public void configure(HttpSecurity http) throws Exception {
//		formAuthenticationConfig.configure(http);
//		http.headers().frameOptions().disable();
//		http.apply(validateCodeSecurityConfig)
//				.and()
//				.apply(smsCodeAuthenticationSecurityConfig)
//				.and()
//				.apply(pcSocialSecurityConfig)
//				.and()
//				.apply(openIdAuthenticationSecurityConfig)
//				.and()
//				.headers().frameOptions().disable()
//				.and()
//				.exceptionHandling().accessDeniedHandler(pcAccessDeniedHandler)
//				.and()
//				.csrf().disable();
//
//		authorizeConfigManager.config(http.authorizeRequests());
//	}
//
//	@Override
//	public void configure(ResourceServerSecurityConfigurer resources) {
//		resources.expressionHandler(pcSecurityExpressionHandler);
//	}
//}