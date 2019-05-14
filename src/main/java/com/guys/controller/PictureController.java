package com.guys.controller;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSONObject;
import com.guys.constant.CommonConstant;
import com.guys.model.UserLogin;
import com.guys.service.PictureService;
import com.guys.service.UserLoginService;

@Controller
@RequestMapping("/picture")
public class PictureController extends BaseController {
	@Resource(name="pictureService")
	private PictureService pictureService ;
	@Resource(name="userLoginService")
	private UserLoginService userLoginService ;
	
	@RequestMapping("/upload")
	@ResponseBody
	public JSONObject upload(@RequestParam(value="myFileName")MultipartFile mf, HttpServletRequest request) {
		JSONObject jsonObject = new JSONObject() ;
		URL path = this.getClass().getClassLoader().getResource("default.jpg");
		String realPath = pictureService.getPortraitPathPre(request) ;
		//获取源文件名
		String filename = mf.getOriginalFilename();
		//使用.划分文件名，方便得到文件名后缀
		String[] names=filename.split("\\.");
		String tempNum=(int)(Math.random()*100000)+"";
		String uploadFileName=tempNum +System.currentTimeMillis()+"."+names[names.length-1];
		File targetFile = new File (realPath,uploadFileName);//目标文件
		
		//从session中获取的userLogina没有id值，在update的时候会报错
		//The given object has a null identifier
		//所以重新查一次userLogin
		//昵称是唯一 的，所以查出来的用户也是唯一的
		UserLogin userLogin = userLoginService.getUserLoginByUserLoginName(this.getSessionUser(request).getName()) ;
		
		try {
	        mf.transferTo(targetFile);
	        log.info("用户[" + userLogin.getName() + "]上传头像:" + uploadFileName + "成功") ;
	    } catch (IllegalStateException e) {
	    	jsonObject.put("state", 0) ;
	    	log.info("用户[" + userLogin.getName() + "]上传头像:" + uploadFileName + "失败") ;
	    	return jsonObject ;
	    } catch (IOException e) {
	    	jsonObject.put("state", 0) ;
	    	log.info("用户[" + userLogin.getName() + "]上传头像:" + uploadFileName + "失败") ;
	    	return jsonObject ;
	    }
		
		userLogin.setPortrait(CommonConstant.PORTRAITPRE + uploadFileName);
		userLoginService.update(userLogin);
		jsonObject.put("state", 1) ;
		jsonObject.put("url", uploadFileName) ;
		
		return jsonObject ;
	}
}
