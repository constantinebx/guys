<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
    <head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
		<title>guys</title>
		<link rel="icon" href="images/title.jpeg" type="image/c-icon"></link>
		<link rel="stylesheet" href="layui-v2.3.0/layui/css/layui.css" media="all">
		<script src="resource/jquery.min.js"></script>
    </head>

    <body>
    	<%--头部--%>
    	<%@include file="top.jsp"%>
		
    	<%-- 公告 --%>
    	<div class="announcement">
    		
    	</div>

    	<%-- 导航 --%>
    	<div class="guidelayui-breadcrumb" layui-separator="|">
		</div>

		<%--主体--%>
		<div id="main" class="layui-container">
			<div id="editor">
				<p>欢迎使用<b>wangEditor</b>富文本编辑器</p>
			</div>
			<button id="editorSetBtn">设置内容</button>
			<button id="editorGetBtn1">获取内容1</button>
			<button id="editorGetBtn2">获取内容2</button>
		</div>
    		
    	<%-- 页脚 --%>
    	<%@include file="foot.jsp" %>

		<script src="layui-v2.3.0/layui/layui.js"></script>
		<script src="wangEditor/wangEditor.js"></script>
		<script>
		//JavaScript代码区域
		
		$(function() {
			var E = window.wangEditor ;
			var editor = new E("#editor") ;
			editor.create() ;
			
			$("#editorSetBtn").click(function() {
				editor.txt.html("内容设置完毕") ;
			}) ;
			$("#editorGetBtn1").click(function() {
				alert(editor.txt.html()) ;
			}) ;
			$("#editorGetBtn2").click(function() {
				alert(editor.txt.text()) ;
			}) ;
		});
		
		layui.use('carousel', function(){
		  var carousel = layui.carousel;
		  carousel.render({
			  elem: '#test1'
				,width: '100%' //设置容器宽度
				,arrow: 'always' //始终显示箭头
				//,anim: 'updown' //切换动画方式
		  }) ;
		});
		</script>
		
		<script>
		    document.addEventListener('visibilitychange', function () {
		    if (document.visibilityState == 'hidden') {
		        normal_title = document.title;
		        document.title = '你快回来！';
		    } else document.title = 'guys';
		});
		</script>

    </body>
</html>