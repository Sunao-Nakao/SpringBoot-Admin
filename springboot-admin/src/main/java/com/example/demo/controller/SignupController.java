package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.form.SignupForm;
import com.example.demo.service.SignupService;

import lombok.RequiredArgsConstructor;

/** サインアップ画面 Controller **/
@Controller
@RequiredArgsConstructor
@RequestMapping("/admin")
public class SignupController {
	
	/**サインアップ service**/
	private final SignupService service;
	
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
	public void signup(Model model, SignupForm form) {
		service.registAdmins(form);
	}
}