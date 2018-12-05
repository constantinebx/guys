package com.guys.dao;

import java.util.List;

import com.guys.model.UserLogin;

public interface UserLoginDao extends BaseDao<UserLogin> {
	/**
	 * 根据用户名称获得用户
	 * @param name
	 * @return
	 */
	public UserLogin getUserLoginByName(String name) ;
	
	/**
	 * 根据用户名进行模糊查询
	 * @param name
	 * @return
	 */
	public List<UserLogin> queryUserLoginByName(String name) ;
	
	/**
	 * 根据邮箱查询用户
	 * @param email
	 * @return
	 */
	public UserLogin getUserLoginByEmail(String email) ;
}
