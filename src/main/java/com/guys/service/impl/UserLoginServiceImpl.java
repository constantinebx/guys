package com.guys.service.impl;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.guys.exception.EmailConflictException;
import com.guys.exception.EmailExistException;
import com.guys.exception.UserExistException;
import com.guys.exception.ValidateCodeErrorException;
import com.guys.exception.ValidateCodeExpireException;
import com.guys.model.UserLogin;
import com.guys.service.UserLoginService;

public class UserLoginServiceImpl implements UserLoginService {

	public void register(UserLogin UserLogin, HttpSession session)
			throws UserExistException, ValidateCodeExpireException, ValidateCodeErrorException, EmailConflictException {
		// TODO Auto-generated method stub
		
	}

	public void update(UserLogin UserLogin) {
		// TODO Auto-generated method stub
		
	}

	public UserLogin getUserLoginByUserLoginName(String UserLoginName) {
		// TODO Auto-generated method stub
		return null;
	}

	public UserLogin getUserLoginByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	public UserLogin getUserLoginById(int UserLoginId) {
		// TODO Auto-generated method stub
		return null;
	}

	public void lockUserLogin(String UserLoginName) {
		// TODO Auto-generated method stub
		
	}

	public void unlockUserLogin(String UserLoginName) {
		// TODO Auto-generated method stub
		
	}

	public List<UserLogin> queryUserLoginByUserLoginName(String UserLoginName) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<UserLogin> getAllUserLogins() {
		// TODO Auto-generated method stub
		return null;
	}

	public void loginSuccess(UserLogin UserLogin, boolean isSameDay) {
		// TODO Auto-generated method stub
		
	}

	public void sendValidateCode(UserLogin UserLogin, String to) throws EmailExistException {
		// TODO Auto-generated method stub
		
	}

}
