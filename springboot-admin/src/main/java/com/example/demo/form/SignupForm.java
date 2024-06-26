package com.example.demo.form;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;


/** ユーザー登録画面　form **/

@Data
public class SignupForm {
	
	/** 姓 **/
	@NotBlank(message = "{jakarta.validation.constraints.NotNull.message}")
	private String lastName;
	
	/** 名 **/
	@NotBlank(message = "{jakarta.validation.constraints.NotNull.message}")
	private String firstName;
	
	/** ID Email **/
	@NotBlank(message = "{jakarta.validation.constraints.NotNull.message}")
	@Email
	private String email;
	
	/** パスワード **/
	@NotBlank(message = "{jakarta.validation.constraints.NotNull.message}")
	@Length(min = 8, max = 16)
	private String password;

}
