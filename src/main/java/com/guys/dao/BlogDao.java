package com.guys.dao;

import java.util.List;

import com.guys.model.Article;

public interface BlogDao extends BaseDao<Article> {
	/**
	 * 根据文章题目查找
	 * @param title
	 * @return
	 */
	public Article findArticleByTitle(String title) ;
	
	/**
	 * 根据文章题目模糊查询
	 * @param title
	 * @return
	 */
	public List<Article> getArticleByTitle(String title) ;
	
	/**
	 * 根据ID查找文章
	 * @param id
	 * @return
	 */
	public Article findArticleById(Integer id) ;
	
	/**
	 * 查找所有文章
	 * @return
	 */
	public List<Article> findAll() ;
}
