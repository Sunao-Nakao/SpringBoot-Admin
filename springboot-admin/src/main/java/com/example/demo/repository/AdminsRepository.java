package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Admins;


/** 管理者ユーザー情報テーブル **/
@Repository
public interface AdminsRepository extends JpaRepository<Admins, String>{

}
