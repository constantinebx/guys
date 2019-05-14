package com.guys.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.guys.constant.CommonConstant;
import com.guys.model.Article;
import com.guys.model.UserLogin;
import com.guys.service.BlogService;
import com.guys.service.UserLoginService;

@Controller
@RequestMapping("/login")
public class LoginController extends BaseController {
	@Resource(name = "userLoginService")
	public UserLoginService userLoginService ;
	@Resource(name = "blogService")
	private BlogService blogService ;
	
	/**
	 * 用户登录
	 * @param request
	 * @param userLogin
	 * @return
	 */
	@RequestMapping("/doLogin")
	public ModelAndView login(HttpServletRequest request, UserLogin userLogin) {
		UserLogin user = userLoginService.getUserLoginByUserLoginName(userLogin.getName()) ;
		ModelAndView mav = new ModelAndView() ;
		mav.setViewName("forward:/login.jsp");
		if (user == null) {
			mav.addObject("errorMsg", "用户名不存在");
			log.info("----------登录用户不存在----------");
		} else if (!user.getPassword().equals(userLogin.getPassword())) {
			mav.addObject("errorMsg", "用户名密码不正确");
			log.info("----------登录密码不正确----------");
		} else {
			// session中存入userLogin
			//设置头像地址
			userLogin.setPortrait(user.getPortrait());
			setSessionUser(request, userLogin);
			String toUrl = (String) request.getSession().getAttribute(CommonConstant.LOGIN_TO_URL);
			request.getSession().removeAttribute(CommonConstant.LOGIN_TO_URL);
			// 如果当前会话中没有保存登录之前的请求URL，则直接跳转到主页
			if (StringUtils.isEmpty(toUrl)) {
				toUrl = "/index.jsp";
			}
			mav.setViewName("redirect:" + toUrl);
			log.info("----------登录成功----------");
		}
		return mav ;
	}
	
	/**
	 * 跳转到登录页面
	 * @param request
	 * @return
	 */
	@RequestMapping("/toLogin")
	public ModelAndView toLogin(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView() ;
		mav.setViewName("login");
		return mav ;
	}
	
	/**
	 * 用户注销
	 * @param session
	 * @return
	 */
	@RequestMapping("/doLogout")
	public ModelAndView logout(HttpSession session) {
		ModelAndView mav = new ModelAndView() ;
		// session中移除user
		session.removeAttribute(CommonConstant.USER_CONTEXT);
		
		log.info("----------注销成功----------");
		mav.setViewName("redirect:/index.jsp");
		return mav;
	}
	
	@RequestMapping("/blog")
	public ModelAndView blog(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView() ;
		
		List<Article> articles = blogService.listLatest() ;
		mav.addObject("articles", articles) ;
		
		mav.setViewName("blog");
		return mav ;
	}
	
}
