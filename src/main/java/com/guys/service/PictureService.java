package com.guys.service;

import javax.servlet.http.HttpServletRequest;

public interface PictureService {
	
	/**
	 * 获取头像路径前缀
	 * @param request
	 * @return
	 */
	public String getPortraitPathPre(HttpServletRequest request) ;
}
