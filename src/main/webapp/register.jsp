<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
    <head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
		<title>注册</title>
		<link rel="stylesheet" href="layui-v2.3.0/layui/css/layui.css" media="all">
    </head>

    <body>
    	<!-- 头部 -->
    	<%@include file="top.jsp" %>

		<!--主体-->
		<div class="layui-container layui-row" style="width:1024px;height:658px;background-image:url(images/2.jpg);position:relative">
			<div class="layui-form layui-container layui-col-md4 layui-col-md-offset4" style="width:256px;height:400px;background-color:white;position:absolute;top:10%">
				<h2 style="text-align:center">注册</h2>
				<div class="layui-form-item">
					<input class="layui-input" id="username" lay-verify="required" name="username" placeholder="昵称" type="text" />
				</div>
				<div class="layui-form-item">
					<input class="layui-input" id="password" lay-verify="required" name="password" placeholder="密码" type="password" />
				</div>
				<div class="layui-form-item">
					<input class="layui-input" id="confirm" lay-verify="required" name="password" placeholder="确认密码" type="password" />
				</div>
				<div class="layui-form-item">
					<input class="layui-input" id="email" lay-verify="required" name="email" placeholder="邮箱" type="text" />
				</div>
				<div class="layui-form-item">
					<input class="layui-input" id="validate" lay-verify="required" name="validate" placeholder="验证码" type="text" />
				</div>
				<div class="layui-form-item">
					<button class="layui-btn layui-btn-fluid" id="login-submit" lay-filter="login-submit" lay-submit="">注 册</button>
				</div>
				<div class="layui-trans layui-form-item layadmin-user-login-other">
					<label>社交账号登入</label>
					<a href="javascript:layer.msg(&#39;敬请期待&#39;);"><i class="layui-icon layui-icon-login-qq"></i></a>
					<a href="javascript:layer.msg(&#39;敬请期待&#39;);"><i class="layui-icon layui-icon-login-wechat"></i></a>
					<a href="javascript:layer.msg(&#39;敬请期待&#39;);"><i class="layui-icon layui-icon-login-weibo"></i></a>

					<a class="layadmin-user-jump-change" href="<c:url value="/login.jsp"/>" style="color:#009688">已有账号</a>
				</div>
			</div>
		</div>
    		
    	<!-- 页脚 -->
    	<%@include file="foot.jsp" %>

		<ul class="layui-fixbar">
			<li class="layui-icon layui-fixbar-top" lay-type="top" style="background-color:rgb(0,150,136);display:list-item">
			<a href="#top">↑</a></li>
		</ul>
		
		<script>
			layui.use('form', function(){
			  var form = layui.form;
			  
			  //监听提交
			  form.on('submit(formDemo)', function(data){
			    layer.msg(JSON.stringify(data.field));
			    return false;
			  });
			});
		</script>
    </body>
</html>