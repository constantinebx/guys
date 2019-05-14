package com.guys.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.guys.dao.BlogDao;
import com.guys.model.Article;
import com.guys.model.UserLogin;
import com.guys.service.BlogService;

@Transactional
@Service("blogService")
public class BlogServiceImpl implements BlogService {

	@Resource(name = "blogDao")
	private BlogDao blogDao ;
	
	public List<Article> getAllArticle(UserLogin user) {
		List<Article> articles = blogDao.findAll() ;
		return deleteLimition(articles, user) ;
	}

	public void addArticle(Article article) {
		blogDao.save(article);
	}

	public void removeArticle(int id) {
		Article article = blogDao.findArticleById(id) ;
		blogDao.remove(article);
	}

	public List<Article> deleteLimition(List<Article> articles, UserLogin user) {
		//遍历每篇文章，把当前用户不可见的去掉
		for(Article art : articles) {
			//所有人可见文章，不进行操作
			if(art.getLimition() == 0) {
				continue ;
			}
			//好友可见文章，需要查询文章作者好友表，并与当前用户对比
			if(art.getLimition() == 1) {
				//TODO
			}
			//当前文章仅作者自己可见，需去掉
			if(art.getLimition() == 2) {
				articles.remove(art) ;
			}
		}
		return articles ;
	}

	public List<Article> getMyAll(UserLogin user) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Article> listLatest() {
		List<Article> articles = blogDao.listLatest() ;
		return articles;
	}
}
