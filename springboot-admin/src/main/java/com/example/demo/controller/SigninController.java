
package com.example.demo.controller;

import org.springframework.context.MessageSource;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.WebAttributes;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.constant.MessageConst;
import com.example.demo.constant.UrlConst;
import com.example.demo.form.SigninForm;
import com.example.demo.service.SigninService;
import com.example.demo.util.AppUtil;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

/** サインイン画面 Controller **/
@Controller
//@RequestMapping("/admin")
@RequiredArgsConstructor
public class SigninController {
	
	/** サインインservice **/
	private final SigninService service;
	
	/** PasswordEncoder **/
	private final PasswordEncoder passwordEncoder;
	
	/** メッセージソース **/
	private final MessageSource messageSource;
	
	/** セッション情報 **/
	private final HttpSession session;
	
	/** 初期表示 **
	 * @param model モデル
	 * @param form 入力情報
	 * @return 表示画面
	 */
	@GetMapping(UrlConst.SIGNIN)
	public String view(Model model, SigninForm form) {
		return "signin";
	} 
	
	/** ログインエラー画面表示 **
	 * @param model モデル
	 * @param form 入力情報
	 * @return 表示画面
	 */
	@GetMapping(value = UrlConst.SIGNIN, params = "error")
	public String viewWithError(Model model, SigninForm form) {
		var admins = (Exception)session.getAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
		model.addAttribute("errorMsg", admins.getMessage());
		return "signin";
	} 
	
	/** サインイン **
	 * @param model モデル
	 * @param form 入力情報
	 * @return 表示画面
	 */
	@PostMapping(UrlConst.SIGNIN)
	public String signin(Model model, SigninForm form) {
		
		var admins = service.searchUserByEmail(form.getEmail());		
		var isCorrectUserAuth = admins.isPresent() 
				&& passwordEncoder.matches(form.getPassword(), admins.get().getPassword());
		
		if(isCorrectUserAuth) {
			return "redirect:/admin/contacts";
			
		} else {
			var errorMsg = AppUtil.getMessage(messageSource, MessageConst.SIGNIN_WRONG_INPUT);
			model.addAttribute("errorMsg", errorMsg);
			return "signin";
		}
	}
}
