package com.guys.service;

import java.util.List;

import com.guys.model.Article;
import com.guys.model.UserLogin;

public interface BlogService {
	/**
	 * 查找所有当前用户可见的文章
	 * @return
	 */
	public List<Article> getAllArticle(UserLogin user) ;
	
	/**
	 * 获取当前用户自己写的所有文章
	 * @param user
	 * @return
	 */
	public List<Article> getMyAll(UserLogin user) ;
	
	/**
	 * 新增文章
	 * @param article
	 */
	public void addArticle(Article article) ;
	
	/**
	 * 删除文章
	 * @param id
	 */
	public void removeArticle(int id) ;
	
	/**
	 * 去掉当前用户不可见的文章
	 * @param articles
	 */
	public List<Article> deleteLimition(List<Article> articles, UserLogin user) ;
	
	/**
	 * 查找最近更新的文章，用户主页中展示
	 * @return
	 */
	public List<Article> listLatest() ;
}
