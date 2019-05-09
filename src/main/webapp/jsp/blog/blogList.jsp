<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
    <head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
		<title>guys</title>
    </head>

    <body>
    	<%--头部--%>
    	<%@include file="../../../top.jsp"%>
		
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
					<%--主题内容 --%>
					<div>
						<div class="article">
							<div class="article-left">此处放图片</div>
							<div class="article-right">
								<div class="article-title">docker</div>
								<div class="articel-brief">Docker 是一个开源的应用容器引擎，
								让开发者可以打包他们的应用以及依赖包到一个可移植的容器中，
								然后发布到任何流行的 Linux 机器上，也可以实现虚拟化。
								容器是完全使用沙箱机制，相互之间不会有任何接口。</div>
							</div>
							<div class="article-foot">
								<span class="layui-badge layui-bg-gray">日期</span>
								<span class="layui-badge layui-bg-gray">作者</span>
								<span class="layui-badge layui-bg-gray">标签</span>
								<span class="layui-badge layui-bg-gray">浏览量</span>
								<span class="layui-badge layui-bg-gray">点赞量</span>
							</div>
						</div>
					</div>
				</div>

				<%--右边模块--%>
				<div id="right" class="layui-col-md3">
					<p>右边</p>
				</div>
			</div>
		</div>
    		
    	<%-- 页脚 --%>
    	<%@include file="../../../foot.jsp" %>

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
    </body>
</html>