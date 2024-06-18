package com.example.demo.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Admins;
import com.example.demo.repository.AdminsRepository;

import lombok.RequiredArgsConstructor;



/** サインイン画面 Service **/
@Service
@RequiredArgsConstructor
public class SigninService {

	/** ユーザー情報テーブル **/
	private final AdminsRepository repository;
	
	
	/** ユーザー情報テーブル主キー検索（Email）**
	 * @param email サインイン
	 * @return ユーザーテーブル情報をキー検索した結果(1件)
	 */
	public Optional<Admins> searchUserByEmail(String email){
	return repository.findById(email);
	}
	
}
