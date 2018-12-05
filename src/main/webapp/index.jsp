<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
    <head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
		<title>guys</title>
		<link rel="stylesheet" href="layui-v2.3.0/layui/css/layui.css" media="all">
    </head>

    <body>
    	<!-- 头部 -->
    	<!-- <div class="header layui-bg-black layui-header" name = "top">
    		<div class="layui-logo"><a href="index.html"><img src="images/5.jpg" width="100" height="50"></a></img></div>
			头部区域（可配合layui已有的水平导航）
			<ul class="layui-nav layui-layout-left">
			  <li class="layui-nav-item layui-this"><a href="index.html">首页</a></li>
			  <li class="layui-nav-item"><a href="blog.html">博客</a></li>
			  <li class="layui-nav-item"><a href="">资源</a></li>
			  <li class="layui-nav-item"><a href="tobecontinue.html">待续</a></li>
			</ul>
			<ul class="layui-nav layui-layout-right">
			  <li class="layui-nav-item"><a href="login.html">登录</a></li>
			  <li class="layui-nav-item"><a href="">注册</a></li>
			</ul>
		  </div>
    	</div> -->
    	<%@include file="top.jsp"%>
		

    	<!-- 公告 -->
    	<div class="announcement">
    		
    	</div>

    	<!-- 导航 -->
    	<div class="guidelayui-breadcrumb" layui-separator="|">
		</div>

		<!--主体-->
		<div id="main" class="layui-container">
			<div class="layui-row layui-layui-col-space10">
				<!--左边分类模块-->
				<div id="lefttype" class="layui-side-scroll layui-col-md3">
					<p>左边</p>
				</div>

				<!--中间主题部分-->
				<div id="mainbody" class="layui-col-md6">
					<!-- 图片 -->
					<div class="layui-carousel" id="test1">
					<div carousel-item>
					  <div><img src="images/planet.jpg"></img></div>
					  <div><img src="images/timg.jpg"></img></div>
					</div>
				</div>

				<!--右边模块-->
				<div id="right" class="layui-col-md3">
					<p>右边</p>
				</div>
			</div>
		</div>
    		
    	<!-- 页脚 -->
    	<%@include file="foot.jsp" %>
    	<!-- <div id="footer">
    		<div class="foot">
				<div class="footmenu">
					<dl>
						<dt>没有蛀牙</dt>
						<dd>我行走于远方</dd>
						<dd>夜夜思量</dd>
						<dd>你的模样</dd>
					</dl>
					<dl>
						<dt>友情链接</dt>
						<dd>百度</dd>
						<dd>GitHub</dd>
						<dd>CSDN</dd>
					</dl>
					<dl>
						<dt>互动</dt>
						<dd>意见反馈</dd>
						<dd>投稿</dd>
						<dd>加入我们</dd>
					</dl>
					<dl>
						<dt>联系我们</dt>
						<dd>电话：电话是不可能电话的</dd>
						<dd>微信：见QQ签名</dd>
						<dd>QQ：见微信签名</dd>
					</dl>
				</div>
			</div>
    	</div>

		<style type="text/css">
        #footer {
            width: 100%;
            position: relative;
            background: #0f99f9;
            padding: 30px 0;
            overflow: hidden;
            
        }

        .foot {
            width: 1000px;
            margin: 0 auto;
            position: relative;
        }

        .footmenu {
            text-align:left;
            width: 100%;
            position: relative;
            overflow: hidden;
            padding-bottom: 20px;
            border-bottom: 1px solid #fff;
            margin-bottom: 10px;
        }

            .footmenu dl {
                width: 160px;
                margin-left: 20px;
                float: left;
            }

                .footmenu dl dt {
                    width: 100%;
                    height: 30px;
                    line-height: 30px;
                    color: #fff;
                    font-size: 16px;
                    margin-bottom: 10px;
                }

                .footmenu dl dd {
                    width: 100%;
                    font-size: 12px;
                    height: 30px;
                    line-height: 30px;
                    white-space: nowrap;
                    overflow: hidden;
                }

                    .footmenu dl dd a {
                        color: #fff;
                    }

        .foot p {
            width: 100%;
            text-align: center;
            font-size: 12px;
            line-height: 30px;
            color: #80b0d7;
        }
    </style> -->

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