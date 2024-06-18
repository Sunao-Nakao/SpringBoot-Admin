package com.example.demo.form;

import lombok.Data;


/** ユーザー登録画面　form **/

@Data
public class SignupForm {
	
	/** 姓 **/
	private String lastName;
	
	/** 名 **/
	private String firstName;
	
	/** ID Email **/
	private String email;
	
	/** パスワード **/
	private String password;

}
