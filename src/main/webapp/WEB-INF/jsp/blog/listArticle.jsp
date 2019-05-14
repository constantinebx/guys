<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
    <head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
		<title>博客主页</title>
    </head>

    <body>
    	<%--头部--%>
    	<%@include file="../top.jsp"%>

		<%--主体--%>
		<div id="main" class="layui-container layui-bg-gray">
			<div class="layui-row layui-layui-col-space10">
				
				<%--左边分类模块--%>
				<div id="lefttype" class="layui-side-scroll layui-col-md2">
					<h2>分类</h2>
					<ul class="layui-nav layui-nav-tree">
						<li class="layui-nav-item">
							<a href="javascript:;">IT技术</a>
							<dl class="layui-nav-child">
						      <dd><a href="javascript:;">java</a></dd>
						      <dd><a href="javascript:;">python</a></dd>
						      <dd><a href="">c++</a></dd>
						      <dd><a href="">其他</a></dd>
						    </dl>
						</li>
						<li class="layui-nav-item">
							<a href="javascript:;">语言</a>
							<dl class="layui-nav-child">
						      <dd><a href="javascript:;">英语</a></dd>
						      <dd><a href="javascript:;">日语</a></dd>
						      <dd><a href="">法语</a></dd>
						      <dd><a href="">其他</a></dd>
						    </dl>
						</li>
						<li class="layui-nav-item"><a href="">随笔</a></li>
						<li class="layui-nav-item"><a href="">分享</a></li>
					</ul>
				</div>

				<%--中间主题部分--%>
				<div id="mainbody" class="layui-col-md8">
					<%-- 导航 --%>
			    	<span class="guide layui-breadcrumb" lay-separator="|">
			    		<a class="blog-bread layui-this" href="<c:url value="/blog/listArticle.html"/>" style="font-size:18px;">博客主页</a>
						<a class="blog-bread" href="<c:url value="/blog/editor.html"/>" style="font-size:18px;">写文章</a>
						<a class="blog-bread" href="javascript:;" style="font-size:18px;">我的文章</a>
						<a class="blog-bread" href="javascript:;" style="font-size:18px;">搜索文章</a>
					</span>
					<%--主题内容 --%>
					<div class = "layui-row">
						<c:forEach var="article" items="${articles}">
							<div class="article layui-col-md12" style="padding-left:10px;padding-right:10px;margin-bottom:10px;width:auto; height:auto; margin:0pa auto;background-color:#FFFFFF">
								<div class="article-content">
									<h2><a class="article-title" href="javascript::">${article.title}</a></h2>
									<div class="articel-brief">&nbsp;&nbsp;&nbsp;&nbsp;${article.description}</div>
								</div>
								<div class="article-underline"></div>
								<div class="article-foot">
									<span class="layui-badge layui-bg-blue">${article.crt_time}</span>
									<span class="layui-badge layui-bg-blue">作者</span>
									<span class="layui-badge layui-bg-blue">标签</span>
									<span class="layui-badge layui-bg-blue">浏览量</span>
									<a class="layui-icon layui-icon-praise" style="float:right;margin-right:10px;" href="javascript::">1</a>
									<a class="layui-icon layui-icon-star" style="float:right;margin-right:10px;" href="javascript::">1</a>
								</div>
							</div>
						</c:forEach>
					</div>
				</div>

				<%--右边模块--%>
				<div id="right" class="layui-col-md2">
					<h2>推荐</h2>
					<ul class="layui-nav layui-nav-tree">
						<li class="layui-nav-item"><a>Java</a></li>
						<li class="layui-nav-item"><a>Java</a></li>
						<li class="layui-nav-item"><a>Java</a></li>
						<li class="layui-nav-item"><a>Java</a></li>
						<li class="layui-nav-item"><a>Java</a></li>
						<li class="layui-nav-item"><a>Java</a></li>
						<li class="layui-nav-item"><a>Java</a></li>
						<li class="layui-nav-item"><a>Java</a></li>
						<li class="layui-nav-item"><a>Java</a></li>
						<li class="layui-nav-item"><a>Java</a></li>
						<li class="layui-nav-item"><a>Java</a></li>
					</ul>
				</div>
			</div>
		</div>
    		
    	<%-- 页脚 --%>
    	<%@include file="../foot.jsp" %>

    </body>
</html>