package com.example.demo.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.example.demo.constant.UrlConst;

import lombok.RequiredArgsConstructor;


/** Spring Security Webセキュリティ設定クラス **/
@EnableWebSecurity
@Configuration
@RequiredArgsConstructor
public class WebSecurityConfig {
	
	/** パスワードエンコーダー **/
	private final PasswordEncoder passwordEncoder;
	
	/** ユーザー情報取得Servise **/
	private final UserDetailsService userDetailsService;
	
	/** メッセージ取得 **/
	private final MessageSource messageSource;
	
	/** ユーザー名のname属性 **/
	private final String USRANAME_PARAMETER = "email";
	
	/** セキュリティフィルターチェーンの設定 **
	 * @param http HttpSecurityの設定オブジェクト
	 * @return 設定されたSecurityFilterChain
	 * @throws Exception 設定中にエラーが発生した場合
	 */
	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http)throws Exception {
		
		http
		.authorizeHttpRequests(
				authorize -> authorize.requestMatchers(UrlConst.NO_AUTHENTICATION).permitAll()
					.anyRequest().authenticated())
		
		.formLogin(
				login -> login.loginPage(UrlConst.SIGNIN)
					.usernameParameter(USRANAME_PARAMETER)
					.defaultSuccessUrl(UrlConst.CONTACTS));
		
	
		
		return http.build();
	}
	
	
	/** DaoAuthenticationProvider設定 **
	 * @return カスタマイズされたDaoAuthenticationProvider
	 */
	@Bean
	AuthenticationProvider daoAuthenticationProvider() {
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setUserDetailsService(userDetailsService);
		provider.setPasswordEncoder(passwordEncoder);
		provider.setMessageSource(messageSource);
		
		return provider;
	}
	

}