package com.guys.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_user_login")
public class UserLogin {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "i_user_login",nullable = false, updatable = false)
	private Integer iuserLogin ;
	
	@Column(name = "name",nullable = false)
	private String name ;
	
	@Column(name = "password",nullable = false)
	private String password ;
	
	@Column(name = "email",nullable = false)
	private String email ;
	
	@Column(name = "crt_time",nullable = false, updatable = false)
	private Date crtTime ;
	
	@Column(name = "upd_time",nullable = false)
	private Date updTime ;

	public Integer getIuserLogin() {
		return iuserLogin;
	}

	public void setIuserLogin(Integer iuserLogin) {
		this.iuserLogin = iuserLogin;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getCrtTime() {
		return crtTime;
	}

	public void setCrtTime(Date crtTime) {
		this.crtTime = crtTime;
	}

	public Date getUpdTime() {
		return updTime;
	}

	public void setUpdTime(Date updTime) {
		this.updTime = updTime;
	}
}
