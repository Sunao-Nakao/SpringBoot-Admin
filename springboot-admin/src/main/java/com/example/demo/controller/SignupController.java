package com.example.demo.controller;

import java.util.Optional;

import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.constant.SignupMessage;
import com.example.demo.constant.UrlConst;
import com.example.demo.entity.Admins;
import com.example.demo.form.SignupForm;
import com.example.demo.service.SignupService;
import com.example.demo.util.AppUtil;

import lombok.RequiredArgsConstructor;

/** サインアップ画面 Controller **/
@Controller
@RequiredArgsConstructor
//@RequestMapping("/admin")
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
	@GetMapping(UrlConst.SIGNUP)
	public String view(Model model, SignupForm form) {
		return "signup";
	}
	/** サインアップ **
	 * @param model モデル
	 * @param form 入力情報
	 * @param bdResult 入力チェック結果
	 * @return 表示画面
	 */
	@PostMapping(UrlConst.SIGNUP)
	public  String signup(Model model,@Validated SignupForm form, BindingResult bdResult) {
		if(bdResult.hasErrors()) {
			return "signup";
		}
		var adminsOpt = service.registAdmins(form);
		var signupMessage = judgeMessageKey(adminsOpt);
		var messageId = AppUtil.getMessage(messageSource, signupMessage.getMessageId());
		model.addAttribute("message", messageId);
		model.addAttribute("isError", signupMessage.isError());
		
		if (signupMessage == SignupMessage.EXISTED_EMAIL) {
	        return "signup"; 
	    } else {
	        return "redirect:/admin/signin"; 
	    }
		
	}
		
	private SignupMessage judgeMessageKey(Optional<Admins>adminsOpt) {
		if(adminsOpt.isEmpty()) {
			return SignupMessage.EXISTED_EMAIL;
		} else {
			return SignupMessage.SUCCEED;
		}
	}	
		
}





