<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
    <head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
		<title>写文章</title>
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
					<div class="layui-row">
						<div id="editor" style="background:white;">
							<p>欢迎使用<b>wangEditor</b>富文本编辑器</p>
						</div>
						<button id="confirm" class="layui-btn">确定</button>
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

		<script>
		//JavaScript代码区域
		
		$(function() {
			var E = window.wangEditor ;
			var editor = new E("#editor") ;
			//图片上传路径
			editor.customConfig.uploadImgServer = '<c:url value="/picture/upload.html"/>' ;
			//图片大小限制5M
			editor.customConfig.uploadImgMaxSize = 5 * 1024 * 1024;
			// 限制一次最多上传 10 张图片
			editor.customConfig.uploadImgMaxLength = 10 ;
			editor.customConfig.uploadFileName = 'myFileName';
			
			editor.customConfig.uploadImgHooks = {
		    	customInsert: function (insertImg, result, editor) {
	                // 图片上传并返回结果，自定义插入图片的事件（而不是编辑器自动插入图片！！！）
	                // insertImg 是插入图片的函数，editor 是编辑器对象，result 是服务器端返回的结果
	         
	                // 举例：假如上传图片成功后，服务器端返回的是 {url:'....'} 这种格式，即可这样插入图片：
	                var url =result.data;
	                insertImg(url);
	         
	                // result 必须是一个 JSON 格式字符串！！！否则报错
	            }
		    }
			
			editor.create() ;
			
			$("#confirm").click(function() {
				editor.txt.html("内容设置完毕") ;
			}) ;
			$("#editorGetBtn1").click(function() {
				alert(editor.txt.html()) ;
			}) ;
			$("#editorGetBtn2").click(function() {
				alert(editor.txt.text()) ;
			}) ;
		});
		
		
		</script>
    </body>
</html>