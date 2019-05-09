package com.guys.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.guys.dao.UserLoginDao;
import com.guys.model.UserLogin;

@Repository("userLoginDao")
public class UserLoginDaoImpl extends BaseDaoImpl<UserLogin> implements UserLoginDao {
	private static final String GET_USER_BY_USERNAME = "from UserLogin u where u.name = ?";

	private static final String QUERY_USER_BY_USERNAME = "from UserLogin u where u.name like ?";
	
	private static final String GET_USER_BY_EMAIL = "from UserLogin u where u.email = ?" ;

	@SuppressWarnings({ "unchecked", "deprecation" })
	public UserLogin getUserLoginByName(String name) {
		List<UserLogin> userLogins = (List<UserLogin>) getHibernateTemplate().find(GET_USER_BY_USERNAME, name) ;
		if(userLogins.size() == 0) {
			return null ;
		} else {
			return userLogins.get(0) ;
		}
	}

	@SuppressWarnings({ "unchecked", "deprecation" })
	public List<UserLogin> queryUserLoginByName(String name) {
		return (List<UserLogin>) getHibernateTemplate().find(QUERY_USER_BY_USERNAME, name + "%");
	}

	@SuppressWarnings({ "deprecation", "unchecked" })
	public UserLogin getUserLoginByEmail(String email) {
		List<UserLogin> userLogins = (List<UserLogin>) getHibernateTemplate().find(GET_USER_BY_EMAIL, email) ;
		if(userLogins.size() == 0) {
			return null ;
		} else {
			return userLogins.get(0) ;
		}
	}

}
