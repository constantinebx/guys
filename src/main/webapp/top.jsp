<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="header layui-bg-black layui-header" name = "top">
	<div class="layui-logo">
		<a href="<c:url value="/index.jsp"/>">
			<img src="images/5.jpg" width="100" height="50"></img>
		</a>
	</div>
	<!-- 头部区域（可配合layui已有的水平导航） -->
	<ul class="layui-nav layui-layout-left">
	  <li class="layui-nav-item"><a href="<c:url value="/index.jsp"/>">首页</a></li>
	  <li class="layui-nav-item"><a href="<c:url value="/blog.jsp"/>">博客</a></li>
	  <li class="layui-nav-item"><a href="">资源</a></li>
	  <li class="layui-nav-item"><a href="<c:url value="/tobecontinue.jsp"/>">待续</a></li>
	</ul>
	<ul class="layui-nav layui-layout-right">
	  <c:if test="${!empty USER_CONTEXT.userName}">
		${USER_CONTEXT.userName}(${USER_CONTEXT.credit}),欢迎您的到来,
		<a href="<c:url value="/login/doLogout.html"/>">注销</a> ${USER_CONTEXT.userType}
	  </c:if>
	  &nbsp;&nbsp;
	  <c:if test="${empty USER_CONTEXT.userName}">
		<li class="layui-nav-item"><a href="<c:url value="/login.jsp"/>">登录</a></li>&nbsp;&nbsp;
		<li class="layui-nav-item"><a href="<c:url value="/register.jsp"/>">注册</a></li>
	  </c:if>
	</ul>
</div>
