package com.example.demo.constant;


/** URL定数クラス **/


public class UrlConst {
	
	/** サインイン画面 **/
	public static final String SIGNIN = "/admin/signin";
	
	/** サインアップ画面 **/
	public static final String SIGNUP = "/admin/signup";
	
	/** お問合せ一覧（TOP) **/
	public static final String CONTACTS = "/admin/contacts";
	
	/**認証不要画面 **/
	public static final String[] NO_AUTHENTICATION = {SIGNIN, SIGNUP, "/webjars/**"};

}
