<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<head>
	<link rel="stylesheet" href="../resource/css/guys.css" media="all">
	<link rel="stylesheet" href="../layui-v2.3.0/layui/css/layui.css" media="all">
</head>

<div class="header layui-bg-black layui-header" name = "top">
	<div class="layui-logo">
		<a href="<c:url value="/index.jsp"/>">
			<img src="../images/5.jpg" width="100" height="50"></img>
		</a>
	</div>
	<!-- 头部区域（可配合layui已有的水平导航） -->
	<ul class="layui-nav layui-layout-left">
	  <li id="index" class="layui-nav-item"><a href="<c:url value="/index.jsp"/>">首页</a></li>
	  <li id="blog" class="layui-nav-item"><a href="<c:url value="/blog.jsp"/>">博客</a></li>
	  <li class="layui-nav-item"><a href="">资源</a></li>
	  <li class="layui-nav-item"><a href="<c:url value="/tobecontinue.jsp"/>">待续</a></li>
	</ul>
	<ul class="layui-nav layui-layout-right">
	  <c:if test="${!empty USER_CONTEXT.name}">
	    
		<li class="layui-nav-item">
			<a>
				<img src="../${USER_CONTEXT.portrait}" class="layui-nav-img">
				${USER_CONTEXT.name}
			</a>
			<dl class="layui-nav-child">
		      <dd><a href="/personal/info.html">个人中心</a></dd>
		      <dd><a href="javascript:;">安全管理</a></dd>
		    </dl>
		</li>
		<li class="layui-nav-item"><a href="<c:url value="/login/doLogout.html"/>">注销</a></li>
	  </c:if>
	  &nbsp;&nbsp;
	  <c:if test="${empty USER_CONTEXT.name}">
		<li class="layui-nav-item"><a href="<c:url value="/login.jsp"/>">登录</a></li>&nbsp;&nbsp;
		<li class="layui-nav-item"><a href="<c:url value="/register.jsp"/>">注册</a></li>
	  </c:if>
	</ul>
	
</div>
<div>
	<marquee behavior="scroll" direction="right" style="color:red;"> 通知:网站建设中！</marquee>
</div>

<script src="../layui-v2.3.0/layui/layui.js"></script>
<script>
	//JavaScript代码区域
	layui.use('carousel', function(){
	  var carousel = layui.carousel;
	  carousel.render({
		  elem: '#test1'
			,width: '100%' //设置容器宽度
			,arrow: 'always' //始终显示箭头
			//,anim: 'updown' //切换动画方式
	  }) ;
	});
	//注意：导航 依赖 element 模块，否则无法进行功能性操作
	layui.use('element', function(){
	  var element = layui.element;
	  
	  //…
	});
	layui.use('form', function(){
	  var form = layui.form;
	  
	  //监听提交
	  form.on('submit(formDemo)', function(data){
	    layer.msg(JSON.stringify(data.field));
	    return false;
	  });
	});
</script>
