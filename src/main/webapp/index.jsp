<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
    <head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
		<title>guys</title>
		<link rel="icon" href="images/title.jpeg" type="image/c-icon"></link>
		<link rel="stylesheet" href="layui-v2.3.0/layui/css/layui.css" media="all">
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
			<div class="layui-row layui-layui-col-space10">
				<%--左边分类模块--%>
				<div id="lefttype" class="layui-side-scroll layui-col-md3">
					<p>左边</p>
				</div>

				<%--中间主题部分--%>
				<div id="mainbody" class="layui-col-md6">
					<%-- 图片 --%>
					<div class="layui-carousel" id="test1">
					<div carousel-item>
					  <div><img src="images/planet.jpg"></img></div>
					  <div><img src="images/timg.jpg"></img></div>
					</div>
				</div>

				<%--右边模块--%>
				<div id="right" class="layui-col-md3">
					<p>右边</p>
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