package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;


/** ユーザー情報テーブル Entity **/
@Entity
@Table(name = "admins")
@Data
@NoArgsConstructor
public class Admins {
	
	private String lastName;
	
	private String firstName;
	
	/** サインインID Email **/
	@Id
	private String email;
	
	/**パスワード**/
	private String password;

	
	
	
}
