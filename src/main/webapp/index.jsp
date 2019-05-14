<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
    <head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
		<title>guys</title>
    </head>

    <body>
    	<%--头部--%>
    	<%@include file="top.jsp"%>
		
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

    </body>
</html>