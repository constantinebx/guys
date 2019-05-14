package com.guys.service.impl;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.guys.service.PictureService;

@Transactional
@Service("pictureService")
public class PictrueServiceImpl implements PictureService {

	public String getPortraitPathPre(HttpServletRequest request) {
		String realPath = request.getSession().getServletContext().getRealPath("resource/user/common/portrait");
		return realPath;
	}

}
