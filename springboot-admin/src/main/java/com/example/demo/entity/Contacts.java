package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/** ユーザー情報テーブル Entity **/
@Entity
@Table(name = "contacts")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Contacts {
	
	/** お問い合わせID **/
	@Id
	private String id;
	
	/** 姓 **/
	@Column(name = "last_name")
	private String lastName;
	
	/** 名 **/
	@Column(name = "first_name")
	private String firstName;
	
	/** メールアドレス **/
	@Email
	private String email;
	
	/** 電話番号 **/
	@Size(min = 10, max = 11)
	private String phone;
	
	/** 郵便番号 **/
	@Column(name = "zip_code")
	@Pattern(regexp = "[0-9]{3}[-]{0,1}[0-9]{4}")
	private String zipCode;
	
	/** 住所 **/
	private String address;
	
	/** 建物名 **/
	@Column(name = "building_name")
	private String buildingName;
	
	/** お問い合わせ種別 **/
	@Column(name = "contact_type")
	private String contactType;

	/** 内容 **/
	private String body;
	
	/** 作成日時 **/
	@Column(name = "created_at")
	private String createdAt;
	
	/** 更新日時 **/
	@Column(name = "updated_at")
	private String updatedAt;
	
}
