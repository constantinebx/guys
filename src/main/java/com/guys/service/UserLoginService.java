package com.guys.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.guys.exception.EmailConflictException;
import com.guys.exception.EmailExistException;
import com.guys.exception.UserExistException;
import com.guys.exception.ValidateCodeErrorException;
import com.guys.exception.ValidateCodeExpireException;
import com.guys.model.UserLogin;

/**
 * 用户登录service
 * @author 新地球
 *
 */
public interface UserLoginService {
	/**
	 * 注册一个新用户
	 * 
	 * @param UserLogin
	 * @param session
	 * @throws UserLoginExistException 用户名已存在
	 * @throws ValidateCodeExpireException 邮箱验证码过期
	 * @throws ValidateCodeErrorException 邮箱验证码错误
	 * @throws EmailConflictException 邮箱不一致
	 */
	public void register(UserLogin userLogin, HttpSession session) throws UserExistException, ValidateCodeExpireException, ValidateCodeErrorException, EmailConflictException;

	/**
	 * 更新用户
	 * 
	 * @param UserLogin
	 */
	public void update(UserLogin userLogin);

	/**
	 * 根据用户名查询UserLogin对象
	 * 
	 * @param UserLoginName
	 *            用户名
	 * @return
	 */
	public UserLogin getUserLoginByUserLoginName(String userLoginName);
	
	/**
	 * 根据邮箱查询UserLogin对象
	 * 
	 * @param email
	 * @return
	 */
	public UserLogin getUserLoginByEmail(String email);

	/**
	 * 根据UserLoginId加载UserLogin对象
	 * 
	 * @param UserLoginId
	 * @return
	 */
	public UserLogin getUserLoginById(int userLoginId);

	/**
	 * 将用户锁定，锁定的用户不能够登录
	 * 
	 * @param UserLoginName
	 *            锁定目标用户的用户名
	 */
	public void lockUserLogin(String userLoginName);

	/**
	 * 解除用户的锁定
	 * 
	 * @param UserLoginName
	 *            解除锁定目标用户的用户名
	 */
	public void unlockUserLogin(String userLoginName);

	/**
	 * 根据用户名作为条件，执行模糊查询操作
	 * 
	 * @param UserLoginName
	 *            查询用户名
	 * @return 所有用户名前缀匹配的UserLoginName的用户
	 */
	public List<UserLogin> queryUserLoginByUserLoginName(String userLoginName);

	/**
	 * 获取所有用户
	 * 
	 * @return 所有用户
	 */
	public List<UserLogin> getAllUserLogins();

	/**
	 * 登录成功
	 * 
	 * @param UserLogin
	 * @param isSameDay 判断当天是否已经登录
	 */
	public void loginSuccess(UserLogin userLogin, boolean isSameDay);
	
	/**
	 * 发送验证码,并判断邮箱是否被注册
	 * 
	 * @param UserLogin
	 * @param to
	 * @throws EmailExistException 
	 */
	public void sendValidateCode(UserLogin userLogin, String to) throws EmailExistException;
}
