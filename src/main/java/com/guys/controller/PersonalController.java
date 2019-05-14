package com.guys.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 个人中心
 * 点击个人中心默认跳转到个人资料页面
 * @author 新地球
 *
 */
@Controller
@RequestMapping("/personal")
public class PersonalController extends BaseController {
	/**
	 * 个人资料页面
	 * @param request
	 * @return
	 */
	@RequestMapping("/info")
	public ModelAndView toUpdateInfo(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView() ;
		mav.setViewName("/personal/info");
		return mav ;
	}
}
