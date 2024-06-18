package com.example.demo.service;

import org.dozer.Mapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Admins;
import com.example.demo.form.SignupForm;
import com.example.demo.repository.AdminsRepository;

import lombok.RequiredArgsConstructor;



/** サインアップ画面 Service **/
@Service
@RequiredArgsConstructor
public class SignupService {

	/**ユーザー情報テーブル**/
	private final AdminsRepository repository;
	
	
    /** Dozer Mapper **/
	private final Mapper mapper;
	
	
	/** PasswordEncoder **/
	private final PasswordEncoder passwordEncoder;
	
	
	/** ユーザー情報テーブル 新規登録 **
	 * @param form 入力情報
	 * @return 登録情報(ユーザー情報Entity)
	 */
	public Admins registAdmins(SignupForm form){
		var admins = mapper.map(form, Admins.class);
		
		var encodedPassword = passwordEncoder.encode(form.getPassword());
		admins.setPassword(encodedPassword);
				
		return repository.save(admins);
	}
	
}
