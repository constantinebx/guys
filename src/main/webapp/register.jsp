<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
    <head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
		<title>注册</title>
		<link rel="stylesheet" href="layui-v2.3.0/layui/css/layui.css" media="all">
		<script src="https://cdn.bootcss.com/jquery/2.2.4/jquery.min.js"></script>
    </head>

    <body>
    	<!-- 头部 -->
    	<%@include file="top.jsp" %>

		<!--主体-->
		<div class="layui-container layui-row" style="width:1024px;height:658px;background-image:url(images/2.jpg);position:relative">
			<div class="layui-form layui-container layui-col-md4 layui-col-md-offset4" style="width:256px;height:390px;background-color:white;position:absolute;top:10%">
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
				<button id="getCode" class="layui-btn layui-btn-xs">获取验证码</button>
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
		
		<script>
			layui.use('form', function(){
			  var form = layui.form;
			});
		</script>
		
		<script>
			var TIME=60;
			var count=TIME;
			$('#getCode').on('click', function() {
				var obj=$('#getCode');
				setTime(obj);
				$.ajax( {
					type:"get",
					dataType:"text", 
					url:"<c:url value="/email.html" />", 
					data: {
						"tempEmail": $('#tempEmail').val()
					}
					, success:function(data) {
						obj=eval("("+ data+ ")");
						if(obj.code == 0) {
							alert("邮箱已注册") ;
							$('#tempEmail').val("") ;
							obj = $('#getCode');
							count = 0 ;
							setTimeout(obj) ;
							//obj.attr('disabled', false);
							//obj.html("获取验证码");
							//obj.backgroundColor = "#fe9900";
						}
					}
					, error:function(callback) {
						alert("error happened!please try again!");
					}
				});
			});
			
			function setTime(obj) {
				if(count == 0) {
					obj.attr('disabled', false);
					obj.html("获取验证码");
					obj.backgroundColor = "#fe9900";
					count = TIME;
					return false;
				} else {
					obj.attr('disabled', true);
					obj.html("重新发送(" + count + ")");
					obj.backgroundColor = "#8f8b8b";
					count--;
				}

				setTimeout(function() {
					setTime(obj)
				}, 1000);
			}
		</script>
    </body>
</html>