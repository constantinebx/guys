<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
    <head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
		<title>guys</title>
		<link rel="stylesheet" href="../layui-v2.3.0/layui/css/layui.css" media="all">
    </head>

    <body>
    	<%--头部--%>
    	<%@include file="../top.jsp"%>

		<%--主体--%>
		<div id="main" class="layui-container layui-bg-gray">
			<div class="layui-row layui-layui-col-space10">
				
				<%--左边分类模块--%>
				<div id="lefttype" class="layui-side-scroll layui-col-md2">
					<ul class="layui-nav layui-nav-tree">
						<li class="layui-nav-item  layui-nav-itemed"><a href="javascript:;">个人资料</a></li>
						<li class="layui-nav-item"><a href="javascript:;">我的收藏</a></li>
						<li class="layui-nav-item"><a href="javascript:;">我的关注</a></li>
						<li class="layui-nav-item"><a href="javascript:;">我的粉丝</a></li>
						<li class="layui-nav-item"><a href="javascript:;">我的好友</a></li>
					</ul>
				</div>

				<%--中间主题部分--%>
				<div id="mainbody" class="layui-col-md10">
					<%--头部题目 --%>
			    	<h2>&nbsp;&nbsp;&nbsp;&nbsp;个人资料</h2>
			    	<div class="personal-title-underline"></div>
					<%--内容 --%>
					<div class = "layui-row">
						<div><label class="personal-left-blank">ID:123</label></div>
						
						<div>
							<label class="personal-left-blank">关注 0</label>
							<label>粉丝 0</label>
							<label>金币 0</label>
						</div>
						
						<div class="personal-title-underline"></div>
						<label class="personal-left-blank">昵称 ：no</label></br>
						<label class="personal-left-blank">性别 ：</label></br>
						<label class="personal-left-blank">签名 ： </label></br>
						
					</div>
				</div>

			</div>
		</div>
    		
    	<%-- 页脚 --%>
    	<%@include file="../foot.jsp" %>

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
		</script>
    </body>
</html>