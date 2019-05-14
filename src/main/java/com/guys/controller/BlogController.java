package com.guys.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.guys.model.Article;
import com.guys.model.UserLogin;
import com.guys.service.BlogService;

@Controller
@RequestMapping("/blog")
public class BlogController extends BaseController {
	@Resource(name = "blogService")
	private BlogService blogService ;
	
	/**
	 * 跳转到写文章页面
	 * @param request
	 * @return
	 */
	@RequestMapping("/editor")
	public ModelAndView editor(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView() ;
		mav.setViewName("/blog/editor");
		return mav ;
	}
	
	/**
	 * 查找当前用户可见的所有文章
	 * @param request
	 * @return
	 */
	@RequestMapping("/listArticle")
	public ModelAndView listBlog(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView() ;
		mav.setViewName("/blog/listArticle");
		
		UserLogin user = this.getSessionUser(request) ;		
		List<Article> articles = blogService.getAllArticle(user) ;
		mav.addObject("articles", articles) ;
		
		return mav ;
	}
	
	
	/**
	 * 删除文章
	 * @param request
	 * @return
	 */
	@RequestMapping("/removeArticle")
	public ModelAndView removeArticle(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView() ;
		mav.setViewName("removeArticle.jsp");
		return mav ;
	}
}
