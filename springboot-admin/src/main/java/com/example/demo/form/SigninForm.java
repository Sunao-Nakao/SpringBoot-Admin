package com.example.demo.form;

import lombok.Data;

@Data
public class SigninForm {
	
	/** サインインID Email **/
	private String email;
	
	/** パスワード **/
	private String password;

}
