package com.guys.controller;

import java.util.Timer;
import java.util.TimerTask;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.guys.constant.CommonConstant;
import com.guys.exception.EmailConflictException;
import com.guys.exception.EmailExistException;
import com.guys.exception.UserExistException;
import com.guys.exception.ValidateCodeErrorException;
import com.guys.exception.ValidateCodeExpireException;
import com.guys.model.UserLogin;
import com.guys.service.UserLoginService;
import com.guys.utils.EmailUtil;

@Controller("/register")
public class RegisterController extends BaseController {
	@Resource(name = "userLoginService")
	private UserLoginService userLoginService ;
	
	@RequestMapping(value = "/regist", method = RequestMethod.POST)
	public ModelAndView regist(HttpServletRequest request, UserLogin userLogin) {
		HttpSession session = request.getSession();
		ModelAndView mav = new ModelAndView();
		mav.setViewName("success");
		
		//若用户名已存在，则需重新填写
				try {
					//userLogin.setLastIp(request.getRemoteAddr());
					userLoginService.register(userLogin,session);
					setSessionUser(request, userLogin);
					log.info("----------注册成功----------");
				} catch (UserExistException e) {
					mav.addObject("errorMsg", "用户名已存在，请选择其他的名字");
					mav.setViewName("forward:/register.jsp");
					log.info("----------所注册用户名已存在----------");
				} catch (ValidateCodeExpireException e) {
					mav.addObject("errorMsg", "验证码过期");
					mav.setViewName("forward:/register.jsp");
					log.info("----------验证码过期----------");
				} catch (ValidateCodeErrorException e) {
					mav.addObject("errorMsg", "验证码错误");
					mav.setViewName("forward:/register.jsp");
					log.info("----------验证码错误----------");
				} catch (EmailConflictException e) {
					mav.addObject("errorMsg", "注册邮箱与发送验证码使用的邮箱不一致");
					mav.setViewName("forward:/register.jsp");
					log.info("----------注册邮箱与发送验证码使用的邮箱不一致----------");
				} 
				
				return mav;
	}
	
	@RequestMapping(value = "/email", method = RequestMethod.GET)
	@ResponseBody
	public JSONObject email(HttpServletRequest request, UserLogin userLogin,String tempEmail) {
		JSONObject jsonObject = new JSONObject() ;
		//发送验证码
		try {
			userLoginService.sendValidateCode(userLogin, tempEmail);
			//把验证码和邮箱保存到session中，用于判断验证码是否一致和邮箱是否一致
			HttpSession session = request.getSession() ;
			session.setAttribute("code", EmailUtil.getVerifyCode());
			session.setAttribute("email", tempEmail);
			
			//定时任务，验证码过期后把session中的code改为""
			new TimerClear(session, CommonConstant.EXPIRE_TIME) ;
			
			jsonObject.put("code", 1) ;
			log.info("----------向正在注册用户: " + userLogin.getName() + " 的邮箱: " + userLogin.getEmail() + " 发送验证码----------");
		}catch(EmailExistException e) {
			jsonObject.put("code", 0) ;
			log.info("----------邮箱已注册----------");
		}
		
		return jsonObject ;
	}
}

class TimerClear{
	Timer timer ;
	
	/**
	 * 清除session中的验证码
	 * @param session
	 * @param time 单位为秒
	 */
	public TimerClear(HttpSession session, int time) {
		timer = new Timer() ;
		timer.schedule(new TimerTaskClear(session), time * 1000);
	}
}

class TimerTaskClear extends TimerTask {
	HttpSession session ;
	
	public TimerTaskClear(HttpSession session) {
		this.session = session ;
	}
	
	@Override
	public void run() {
		session.setAttribute("code", "");
	}
}
