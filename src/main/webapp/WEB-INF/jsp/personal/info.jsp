<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
    <head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
		<title>个人中心</title>
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
						<li class="layui-nav-item  layui-nav-itemed layui-this"><a href="javascript:;">个人资料</a></li>
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
						
						<div class="file-box">
						    <img id="preview" src="${USER_CONTEXT.portrait}"/>
						    <input type="file" name="file" id = "input_file" accept="image/gif,image/jpeg,image/jpg,image/png,image/svg" onChange="imgPreview(this)" >	
						</div>
						
					</div>
				</div>

			</div>
		</div>
    		
    	<%-- 页脚 --%>
    	<%@include file="../foot.jsp" %>
    	
    	<script>
    	//预览并上传图片
    	function imgPreview(fileDom) {
    		//判断是否支持FileReader
    		if(window.FileReader) {
    			var reader = new FileReader();
    		} else {
    			alert("您的设备不支持图片预览功能，如需该功能请升级您的设备！");
    		}
    		//获取文件
    		var file = fileDom.files[0];
    		var imageType = /^image\//;
    		//是否是图片
    		if(!imageType.test(file.type)) {
    			alert("请选择图片！");
    			return;
    		}
    		//读取完成
    		reader.onload = function(e) {
    			//获取图片dom
    			var img = document.getElementById("preview");
    			//图片路径设置为读取的图片
    			img.src = e.target.result;
    		};
    		reader.readAsDataURL(file);
    		
    		var formData = new FormData(); 
	    	formData.append('myFileName', $('#input_file')[0].files[0]);  //添加图片信息的参数
	    	formData.append('sizeid',123);  //添加其他参数
	    	$.ajax({
	    	    url: '<c:url value="/picture/upload.html"/>',
	    	    type: 'POST',
	    	    cache: false, //上传文件不需要缓存
	    	    data: formData,
	    	    processData: false, // 告诉jQuery不要去处理发送的数据
	    	    contentType: false, // 告诉jQuery不要去设置Content-Type请求头
	    	    success: function (data) {
	    	        var rs = eval("("+ data+ ")");
	    	        if(rs.state==1){
	    	            alert('上传成功！');
	    	        }else{
	    	            alert(rs.msg);
	    	        }
	    	    },
	    	    error: function (data) {
	    	        alert("上传失败");
	    	    }
	    	})  
    	}
    	</script>
    	
    </body>
</html>