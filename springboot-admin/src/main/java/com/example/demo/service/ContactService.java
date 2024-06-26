package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.entity.Contacts;



/** コンタクトサービスクラス **/

public interface ContactService {
	Optional<Contacts> selectById(Long Id);
	List<Contacts> findAll();
	void insert(Contacts contact);
	void update(Contacts contact);
	void delete(Long id);
}
