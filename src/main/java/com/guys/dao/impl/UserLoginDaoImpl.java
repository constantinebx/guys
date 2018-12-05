package com.guys.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.guys.dao.UserLoginDao;
import com.guys.model.UserLogin;

@Repository("UserLoginDao")
public class UserLoginDaoImpl extends BaseDaoImpl<UserLogin> implements UserLoginDao {
	private static final String GET_USER_BY_USERNAME = "from User_login u where u.userName = ?";

	private static final String QUERY_USER_BY_USERNAME = "from User_login u where u.userName like ?";
	
	private static final String GET_USER_BY_EMAIL = "from User_login u where u.email = ?" ;

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
		List<UserLogin> userLogins = (List<UserLogin>) getHibernateTemplate().find(GET_USER_BY_USERNAME, email) ;
		if(userLogins.size() == 0) {
			return null ;
		} else {
			return userLogins.get(0) ;
		}
	}

}
