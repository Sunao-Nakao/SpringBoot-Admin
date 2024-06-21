package com.example.demo.constant;


/** URL定数クラス **/


public class UrlConst {
	
	/** サインイン画面 **/
	public static final String SIGNIN = "/admin/signin";
	
	/** サインアップ画面 **/
	public static final String SIGNUP = "/admin/signup";
	
	/** お問合せ一覧（TOP) **/
	public static final String CONTACTS = "/admin/contacts";
	
	/** お問合せ詳細 **/
	public static final String CONTACT_DETAIL = "/admin/contacts/{id}";
	
	/** お問合せ編集画面 **/
	public static final String CONTACT_EDIT = "/admin/contacts/{id}/edit";
	
	/**認証不要画面 **/
	public static final String[] NO_AUTHENTICATION = {SIGNIN, SIGNUP, "/webjars/**"};

}
