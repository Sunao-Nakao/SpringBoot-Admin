package com.example.demo.controller;

import java.util.Optional;

import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.constant.MessageConst;
import com.example.demo.entity.Admins;
import com.example.demo.form.SignupForm;
import com.example.demo.service.SignupService;
import com.example.demo.util.AppUtil;

import lombok.RequiredArgsConstructor;

/** サインアップ画面 Controller **/
@Controller
@RequiredArgsConstructor
@RequestMapping("/admin")
public class SignupController {
	
	/**サインアップ service**/
	private final SignupService service;
	
	/** メッセージソース **/
	private final MessageSource messageSource;
	
	
	/** 初期表示 **
	 * @param model モデル
	 * @param form 入力情報
	 * @return 表示画面
	 */
	@GetMapping("/signup")
	public String view(Model model, SignupForm form) {
		return "signup";
	}
	/** サインアップ **
	 * @param model モデル
	 * @param form 入力情報
	 * @return 表示画面
	 */
	@PostMapping("/signup")
	public String signup(Model model, SignupForm form) {
		var adminsOpt = service.registAdmins(form);
		var message = AppUtil.getMessage(messageSource, judgeMessageKey(adminsOpt));
		model.addAttribute("message", message);
		
		if(adminsOpt.isEmpty()) {
			return "signup";
		} else {
			return "redirect:/admin/signin";
		}		
			
	}
		
	private String judgeMessageKey(Optional<Admins>adminsOpt) {
		if(adminsOpt.isEmpty()) {
			return MessageConst.SIGNUP_EXISTED_EMAIL;
		} else {
			return  MessageConst.SIGNUP_RESIST_SUCCED;
		}
	}	
		
}






