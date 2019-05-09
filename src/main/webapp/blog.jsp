<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
    <head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
		<title>guys</title>
		<link rel="stylesheet" href="layui-v2.3.0/layui/css/layui.css" media="all">
    </head>

    <body>
    	<%--头部--%>
    	<%@include file="top.jsp"%>

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
			    		<a class="blog-bread">博客主页</a>
						<a class="blog-bread">写文章</a>
						<a class="blog-bread">我的文章</a>
						<a class="blog-bread">搜索文章</a>
					</span>
					<%--主题内容 --%>
					<div class = "layui-row">
						<div class="article layui-col-md12" style="padding-left:10px;padding-right:10px;margin-bottom:10px;width:auto; height:auto; margin:0pa auto;background-color:#FFFFFF">
							<div class="article-content">
								<a class="article-title" href="javascript::">docker</a>
								<div class="articel-brief">&nbsp;&nbsp;&nbsp;&nbsp;Docker是一个开源的应用容器引擎，
								让开发者可以打包他们的应用以及依赖包到一个可移植的容器中，
								然后发布到任何流行的 Linux 机器上，也可以实现虚拟化。
								容器是完全使用沙箱机制，相互之间不会有任何接口。</div>
							</div>
							<div class="article-underline"></div>
							<div class="article-foot">
								<span class="layui-badge layui-bg-blue">日期</span>
								<span class="layui-badge layui-bg-blue">作者</span>
								<span class="layui-badge layui-bg-blue">标签</span>
								<span class="layui-badge layui-bg-blue">浏览量</span>
								<span class="layui-badge layui-bg-blue">点赞量</span>
								<a class="layui-icon layui-icon-praise" style="float:right;margin-right:10px;" href="javascript::">1</a>
								<a class="layui-icon layui-icon-star" style="float:right;margin-right:10px;" href="javascript::">1</a>
							</div>
						</div>
						<div class="article layui-col-md12" style="padding-left:10px;padding-right:10px;margin-bottom:10px;width:auto; height:auto; margin:0pa auto;background-color:#FFFFFF">
							<div class="article-content">
								<div class="article-title">docker</div>
								<div class="articel-brief">&nbsp;&nbsp;&nbsp;&nbsp;Docker是一个开源的应用容器引擎，
								让开发者可以打包他们的应用以及依赖包到一个可移植的容器中，
								然后发布到任何流行的 Linux 机器上，也可以实现虚拟化。
								容器是完全使用沙箱机制，相互之间不会有任何接口。</div>
							</div>
							<div class="article-underline"></div>
							<div class="article-foot">
								<span class="layui-badge layui-bg-blue">日期</span>
								<span class="layui-badge layui-bg-blue">作者</span>
								<span class="layui-badge layui-bg-blue">标签</span>
								<span class="layui-badge layui-bg-blue">浏览量</span>
								<span class="layui-badge layui-bg-blue">点赞量</span>
								<a class="layui-icon layui-icon-praise" style="float:right;margin-right:10px;" href="javascript::">1</a>
								<a class="layui-icon layui-icon-star" style="float:right;margin-right:10px;" href="javascript::">1</a>
							</div>
						</div>
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
    	<%@include file="foot.jsp" %>

		<script src="layui-v2.3.0/layui/layui.js"></script>
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
		</script>
    </body>
</html>