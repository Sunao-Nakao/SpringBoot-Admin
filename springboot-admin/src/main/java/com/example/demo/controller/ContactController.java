package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/** コンタクト画面Controller **/
@Controller
@RequestMapping("/admin")
public class ContactController {
	
	/** 初期表示 **
	 * @return 表示画面
	 */
	@GetMapping("/contacts")
	public String view() {
		
		return "/contacts";
	}

}
