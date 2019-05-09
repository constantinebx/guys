<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>操作失败</title>
	</head>

	<body>
		<c:if test="${!empty errorMsg}">
			操作失败!错误信息：${errorMsg}
		</c:if>
		<c:if test="${empty errorMsg}">
			异常信息：${ex}
		</c:if>
		<br>
		<input type="button" value="返回" onClick="window.history.go(-1);">
	</body>

</html>