<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
    <head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
		<title>guys</title>
		<link rel="stylesheet" href="layui-v2.3.0/layui/css/layui.css" media="all">
    </head>

    <body>
    	<!-- 头部 -->
    	<%@include file="top.jsp" %>

		<!--主体-->
		<div class="layui-container layui-row" style="width:1024px;height:658px;background-image:url(images/2.jpg);position:relative">
			<div class="layui-form layui-container layui-col-md3 layui-col-md-offset8" style="width:256px;height:300px;background-color:white;position:absolute;top:30%">
				<h2 style="text-align:center">登录</h2>
				<div class="layui-form-item">
					<label class="layadmin-user-login-icon layui-icon layui-icon-username"></label>
					<input class="layui-input" id="username" lay-verify="required" name="username" placeholder="用户名" type="text" />
				</div>
				<div class="layui-form-item">
					<label class="layadmin-user-login-icon layui-icon layui-icon-password"></label>
					<input class="layui-input" id="password" lay-verify="required" name="password" placeholder="密码" type="password" />
				</div>
				<div class="layui-form-item" style="margin-bottom: 20px;">
					<input lay-skin="primary" name="remember" title="记住密码" type="checkbox" />
					<div class="layui-unselect layui-form-checkbox" lay-skin="primary">记住密码<i class="layui-icon layui-icon-ok"></i></div>
					<a class="layadmin-user-jump-change" style="margin-top: 8px;" href="forget.html">忘记密码？</a>
                </div>
				<div class="layui-form-item">
					<button class="layui-btn layui-btn-fluid" id="login-submit" lay-filter="login-submit" lay-submit="">登 录</button>
				</div>
				<div class="layui-trans layui-form-item layadmin-user-login-other">
					<label>社交账号登入</label>
					<a href="javascript:layer.msg(&#39;敬请期待&#39;);"><i class="layui-icon layui-icon-login-qq"></i></a>
					<a href="javascript:layer.msg(&#39;敬请期待&#39;);"><i class="layui-icon layui-icon-login-wechat"></i></a>
					<a href="javascript:layer.msg(&#39;敬请期待&#39;);"><i class="layui-icon layui-icon-login-weibo"></i></a>

					<a class="layadmin-user-jump-change" href="register.html" style="color:#009688">注册帐号</a>
				</div>
			</div>
		</div>
    		
    	<!-- 页脚 -->
    	<%@include file="foot.jsp" %>

		<ul class="layui-fixbar">
			<li class="layui-icon layui-fixbar-top" lay-type="top" style="background-color:rgb(0,150,136);display:list-item">
			<a href="#top">↑</a></li>
		</ul>
    </body>
</html>