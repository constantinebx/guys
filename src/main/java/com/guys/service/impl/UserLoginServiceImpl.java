package com.guys.service.impl;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import com.guys.dao.UserLoginDao;
import com.guys.exception.EmailConflictException;
import com.guys.exception.EmailExistException;
import com.guys.exception.UserExistException;
import com.guys.exception.ValidateCodeErrorException;
import com.guys.exception.ValidateCodeExpireException;
import com.guys.model.UserLogin;
import com.guys.service.UserLoginService;
import com.guys.utils.EmailUtil;

public class UserLoginServiceImpl implements UserLoginService {
	@Resource(name = "userLoginDao")
	private UserLoginDao userLoginDao ;

	public void register(UserLogin userLogin, HttpSession session)
			throws UserExistException, ValidateCodeExpireException, ValidateCodeErrorException, EmailConflictException {
		UserLogin u = this.getUserLoginByUserLoginName(userLogin.getName());
		
		if (u != null) {
			throw new UserExistException("用户名已经存在");
 		} else if("".equals(session.getAttribute("code"))) {
 			throw new ValidateCodeExpireException("验证码过期") ;
 		} else if(!(session.getAttribute("code").equals(userLogin.getValidateCode()))) {
 			throw new ValidateCodeErrorException("验证码错误") ;
 		} else if(!(userLogin.getTempEmail().equals(session.getAttribute("email")))) {
 			throw new EmailConflictException("该邮箱与发送验证码使用的邮箱不一致") ;
 		}else {
			// 初始化user并保存
 			/*---------------------------待续
			userLogin.setCredit(100);
			userLogin.setUserType(1);
			userLogin.setLastVisit(new Date());
			*/
			userLogin.setEmail(userLogin.getTempEmail());
			//userLogin.setPassword(EncryptionUtil.getHash(user.getPassword(), "MD5"));
			userLoginDao.save(userLogin);
		}
	}

	public void update(UserLogin userLogin) {
		userLoginDao.update(userLogin);
	}

	public UserLogin getUserLoginByUserLoginName(String userLoginName) {
		return userLoginDao.getUserLoginByName(userLoginName) ;
	}

	public UserLogin getUserLoginByEmail(String email) {
		return userLoginDao.getUserLoginByEmail(email) ;
	}

	public UserLogin getUserLoginById(int userLoginId) {
		return userLoginDao.get(userLoginId) ;
	}

	public void lockUserLogin(String userLoginName) {
		// TODO Auto-generated method stub
		
	}

	public void unlockUserLogin(String userLoginName) {
		// TODO Auto-generated method stub
		
	}

	public List<UserLogin> queryUserLoginByUserLoginName(String userLoginName) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<UserLogin> getAllUserLogins() {
		// TODO Auto-generated method stub
		return null;
	}

	public void loginSuccess(UserLogin userLogin, boolean isSameDay) {
		// TODO Auto-generated method stub
		
	}

	public void sendValidateCode(UserLogin userLogin, String to) throws EmailExistException {
		UserLogin u_email = this.getUserLoginByEmail(userLogin.getTempEmail()) ;
		
		if(u_email != null) {
			throw new EmailExistException("邮箱已被注册") ;
		} else {
			userLogin.setTempEmail(to);
			//发送邮件
			EmailUtil.sendEmail(to);
		}
	}

}
