
package com.example.demo.service;

import java.util.Optional;

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
	 * @return 登録情報(ユーザー情報Entity),既に同じEmailで登録がある場合はEmpty
	 */
	public Optional<Admins> registAdmins(SignupForm form){
		var adminsExistedOpt = repository.findById(form.getEmail());
		if(adminsExistedOpt.isPresent()) {
			return Optional.empty();
		}
		
		var admins = mapper.map(form, Admins.class);

		var encodedPassword = passwordEncoder.encode(form.getPassword());
		admins.setPassword(encodedPassword);
				
		return Optional.of(repository.save(admins));
	}
	
}
