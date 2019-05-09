package com.guys.constant;

public class CommonConstant {

	/**
	 * 用户对象放到Session中的键名称
	 */
	public static final String USER_CONTEXT = "USER_CONTEXT";
	
	/**
	 * 将登录前的URL放到Session中的键名称
	 */
	public static final String LOGIN_TO_URL = "toUrl";
	
	/**
	 * 每页的记录数
	 */
	public static final int PAGE_SIZE = 3;
	
	/**
	 * 邮箱注册验证码的过期时间,单位秒
	 */
	public static final int EXPIRE_TIME = 60 ;
	
	/**
	 * 默认头像路径
	 */
	public static final String PORTRAIT = "resource/user/common/portrait/default.jpg" ;
}
