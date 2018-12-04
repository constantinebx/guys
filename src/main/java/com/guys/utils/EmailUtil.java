package com.guys.utils;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Properties;
import java.util.Random;

import javax.mail.Authenticator;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 用于邮箱注册的工具类
 * @author 新地球
 *
 */
public class EmailUtil {
	/**
	 * 日志
	 */
	protected static Logger log = LoggerFactory.getLogger(EmailUtil.class);
	
	//发送邮件的邮箱
	private static final String FROM = "constantinebx@163.com" ;
	private static final String PASSWORD= "123caolilailai!" ;
	private static String verifyCode = "123456" ;
	
	public static void sendEmail(String to) {
		Properties props = new Properties() ;
		//指定发送的邮箱的邮箱协议
		props.setProperty("mail.transport.protocol", "smtp") ;
		//发件人邮箱的smtp服务器地址
		props.setProperty("mail.smtp.host", "smtp.163.com") ;
		//smtp服务器端口
		props.setProperty("mail.smtp.port", "25") ;
		//指定是否需要smtp验证
		props.setProperty("mail.smtp.auth", "true") ;
		
		//这里的session是邮箱库的session，不是网页中的session
		Session session = Session.getInstance(props, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(FROM,PASSWORD);
			}
		}) ;
		//打开debug模式，在控制台显示更多发送邮件的详细信息
		session.setDebug(true);
		
		//随机生成6位数验证码
		verifyCode = String.valueOf(new Random().nextInt(899999) + 100000);
		
		//创建一封邮件
		MimeMessage message = createMessage(session, FROM, to, verifyCode) ;
		
		//根据session获取邮件传输对象
		Transport transport = null ;
		try {
			transport = session.getTransport() ;
			
			transport.connect(FROM, PASSWORD);
			
			Transport.send(message,message.getAllRecipients());
		} catch (NoSuchProviderException e) {
			System.out.println("获取邮件传输对象失败");
			log.error("获取邮件传输对象失败");
		} catch (MessagingException e) {
			System.out.println("连邮箱失败");
			log.error("连邮箱失败");
		}finally {
			try {
				transport.close();
			} catch (MessagingException e) {
				System.out.println("关闭邮件传输对象失败");
				log.error("关闭邮件传输对象失败");
			}
		}
	}
	
	public static MimeMessage createMessage(Session session, String from, String to, String code) {
		//创建一封邮件
		MimeMessage message = new MimeMessage(session) ;
		//设置发件人
		try {
			message.setFrom(new InternetAddress(from,"guys","UTF-8"));
			//设置收件人
			message.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress(to,"用户","UTF-8"));
			//设置邮件主题
			message.setSubject("欢迎注册guys!", "UTF-8");
			//设置邮件内容
			message.setContent("尊敬的用户，您好！欢迎注册guys，您的激活码是</br><h2>" + code + "</h2>", "text/html;charset=UTF-8");
			//设置邮件发送时间
			message.setSentDate(new Date());
			//保存设置
			message.saveChanges();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return message ;
	}

	public static String getVerifyCode() {
		return verifyCode;
	}

	public static void setVerifyCode(String verifyCode) {
		EmailUtil.verifyCode = verifyCode;
	}
}
