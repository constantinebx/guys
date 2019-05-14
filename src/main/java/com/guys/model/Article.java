package com.guys.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_article")
public class Article {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "i_article",nullable = false, updatable = false)
	private Integer iarticle ;
	
	/**
	 * 博客标题
	 */
	@Column(name = "title", nullable = false)
	private String title ;
	
	/**
	 * 博客描述（简介）
	 */
	@Column(name = "description", nullable = false)
	private String description ;
	
	/**
	 * 博客内容
	 */
	@Column(name = "content", nullable = false)
	private String content ;
	
	/**
	 * 该文章可见范围
	 * 0 - 所有人可见
	 * 1 - 好友可见
	 * 2 - 自己可见
	 */
	@Column(name = "limition", nullable = false)
	private int limition ;
	
	/**
	 * 浏览量
	 */
	@Column(name = "browse", nullable = false)
	private int browse ;
	
	/**
	 * 点赞量
	 */
	@Column(name = "praise", nullable = false)
	private int praise ;
	
	/**
	 * 作者主键
	 */
	@Column(name = "i_user_login", nullable = false)
	private Integer iuserLogin ;
	
	@Column(name = "crt_time", nullable = false)
	private Date crt_time ;
	
	@Column(name = "upd_time", nullable = false)
	private Date upd_time ;

	public Integer getIarticle() {
		return iarticle;
	}

	public void setIarticle(Integer iarticle) {
		this.iarticle = iarticle;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getLimition() {
		return limition;
	}

	public void setLimition(Integer limition) {
		this.limition = limition;
	}

	public Date getCrt_time() {
		return crt_time;
	}

	public void setCrt_time(Date crt_time) {
		this.crt_time = crt_time;
	}

	public Date getUpd_time() {
		return upd_time;
	}

	public void setUpd_time(Date upd_time) {
		this.upd_time = upd_time;
	}

	public int getBrowse() {
		return browse;
	}

	public void setBrowse(int browse) {
		this.browse = browse;
	}

	public int getPraise() {
		return praise;
	}

	public void setPraise(int praise) {
		this.praise = praise;
	}

	public Integer getIuserLogin() {
		return iuserLogin;
	}

	public void setIuserLogin(Integer iuserLogin) {
		this.iuserLogin = iuserLogin;
	}

	public void setLimition(int limition) {
		this.limition = limition;
	}
	
}
