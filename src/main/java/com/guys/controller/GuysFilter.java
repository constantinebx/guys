package com.guys.controller;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import com.guys.constant.CommonConstant;
import com.guys.model.UserLogin;

public class GuysFilter implements Filter {
	private static final String FILTERED_REQUEST = "@@session_context_filtered_request";

	/**
	 * 不需要登录即可访问的URI资源
	 */
	private static final String[] INHERENT_ESCAPE_URIS = { "/index.jsp", "/index.html", "/login.jsp",
			"/login/doLogin.html", "/blog.jsp", "/register.jsp", "/register.html", "/email.html", "/board/listBoardTopics-",
			"/board/listTopicPosts-" };

	/**
	 * 执行过滤
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		//保证该过滤器在一次请求中只被调用一次
		if(request != null && request.getAttribute(FILTERED_REQUEST) != null) {
			chain.doFilter(request, response);
		}
		
		//设置过滤标识，防止一次请求多次过滤
		request.setAttribute(FILTERED_REQUEST, Boolean.TRUE);
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		UserLogin userContext = getSessionUser(httpRequest);
		
		//用户未登录，且当前URI资源需要登录才能访问
		if(userContext == null && !isURILogin(httpRequest.getRequestURI(), httpRequest)) {
			//获取前一页面url，包括参数
			String toUrl = httpRequest.getHeader("Referer");

			//将用户的请求URL保存在session中，用于登录成功后，跳到目标URL
			httpRequest.getSession().setAttribute(CommonConstant.LOGIN_TO_URL, toUrl);
			
			//转发到登录页面
			request.getRequestDispatcher("/login.jsp").forward(request, response);
			return;
		}
		chain.doFilter(request, response);
	}
	
	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * 当前URI资源是否需要登录才能访问
	 * @param requestURI
	 * @param request
	 * @return
	 */
	private boolean isURILogin(String requestURI, HttpServletRequest request) {
		if (request.getContextPath().equalsIgnoreCase(requestURI)
				|| (request.getContextPath() + "/").equalsIgnoreCase(requestURI)) {
			return true;
		}
		for(String uri : INHERENT_ESCAPE_URIS) {
			if (requestURI != null && requestURI.indexOf(uri) >= 0) {
				return true;
			}
		}
		return false;
	}

	protected UserLogin getSessionUser(HttpServletRequest request) {
		return (UserLogin) request.getSession().getAttribute(CommonConstant.USER_CONTEXT);
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
	}

}
