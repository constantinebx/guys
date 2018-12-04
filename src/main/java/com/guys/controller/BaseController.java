package com.guys.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

import com.guys.constant.CommonConstant;
import com.guys.model.UserLogin;

public class BaseController {
	protected static final String ERROR_MSG_KEY = "errorMsg";

	/**
	 * 日志
	 */
	protected Logger log = LoggerFactory.getLogger(getClass());
	
	/**
	 * 获取保存在Session中的用户对象
	 * 
	 * @param request
	 * @return
	 */
	protected UserLogin getSessionUser(HttpServletRequest request) {
		log.debug("-----获取保存在Session中的用户对象-----");
		return (UserLogin) request.getSession().getAttribute(CommonConstant.USER_CONTEXT);
	}   
	
	/**
	 * 保存用户对象到Session中
	 * 
	 * @param request
	 * @param user
	 */
	protected void setSessionUser(HttpServletRequest request, UserLogin user) {
		log.debug("-----保存用户对象到Session中-----");
		request.getSession().setAttribute(CommonConstant.USER_CONTEXT, user);
	}
	
	/**
	 * 获取基于应用程序的url绝对路径
	 * 
	 * @param request
	 * @param url
	 * 				以"/"打头的URL地址
	 * @return 基于应用程序的url绝对路径
	 */
	public final String getAppbaseUrl(HttpServletRequest request, String url) {
		Assert.hasLength(url, "url不能为空");
		Assert.isTrue(url.startsWith("/"), "必须以/打头");
		return request.getContextPath() + url;
	}

}