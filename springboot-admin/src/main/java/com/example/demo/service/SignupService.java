
package com.example.demo.service;

import java.util.Optional;

import com.example.demo.entity.Admins;
import com.example.demo.form.SignupForm;



/** サインアップ画面 Service **/

public interface SignupService {

	Optional<Admins> registAdmins(SignupForm form);
	
}
