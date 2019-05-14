package com.guys.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.guys.dao.BlogDao;
import com.guys.model.Article;

@Repository("blogDao")
public class BlogDaoImpl extends BaseDaoImpl<Article> implements BlogDao{

	@SuppressWarnings({ "unchecked", "deprecation" })
	public Article findArticleByTitle(String title) {
		String hql = "from Article where title = ?" ;
		List<Article> articles = (List<Article>)getHibernateTemplate().find(hql, title) ;
		if(articles.size() == 0) {
			return null ;
		}
		return articles.get(0) ;
	}

	@SuppressWarnings({ "unchecked", "deprecation" })
	public List<Article> getArticleByTitle(String title) {
		String hql = "from Article where title like ?" ;
		List<Article> articles = (List<Article>)getHibernateTemplate().find(hql, title) ;
		if(articles.size() == 0) {
			return null ;
		}
		return articles ;
	}

	@SuppressWarnings({ "unchecked", "deprecation" })
	public Article findArticleById(Integer id) {
		String hql = "from Article where i_title = ?" ;
		List<Article> articles = (List<Article>)getHibernateTemplate().find(hql, id) ;
		if(articles.size() == 0) {
			return null ;
		}
		return articles.get(0) ;
	}

	@SuppressWarnings({ "unchecked", "deprecation" })
	public List<Article> findAll() {
		String hql = "from Article" ;
		List<Article> articles = (List<Article>)getHibernateTemplate().find(hql) ;
		if(articles.size() == 0) {
			return null ;
		}
		return articles ;
	}

	@SuppressWarnings({ "unchecked", "deprecation" })
	public List<Article> listLatest() {
		String hql = "from Article order by crt_time desc" ;
		List<Article> articles = (List<Article>)getHibernateTemplate().find(hql) ;
		if(articles.size() == 0) {
			return null ;
		}
		return articles ;
	}

}
