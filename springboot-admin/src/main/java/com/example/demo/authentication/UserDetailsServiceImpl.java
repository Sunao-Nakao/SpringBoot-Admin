
package com.example.demo.authentication;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.example.demo.repository.AdminsRepository;

import lombok.RequiredArgsConstructor;

/** ユーザー情報生成 **/
@Component
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {
	
	/** ユーザー情報テーブルRepository **/
	private final AdminsRepository repository;
	
	

	/** ユーザー情報生成 **
	 * @param username メールアドレス
	 * @throws UsernameNotFoundException
	 */
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		var admins = repository.findById(username)
				.orElseThrow(() -> new UsernameNotFoundException(username));
		
		return User.withUsername(admins.getEmail())
				.password(admins.getPassword())
				.roles("USER")
				.build();
	}
	

}