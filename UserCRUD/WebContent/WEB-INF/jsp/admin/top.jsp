<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<title></title>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/commonStyle.css">
</head>
<body>
	<%@include file="/WEB-INF/jsp/parts/header.jsp"%>

	<p>
		とりあえずのログイン成功ページ(admin)<br> validationテスト<br>
	</p>
	
	<form action="${pageContext.servletContext.contextPath}/check1.html" method="POST">
		<input type="text" name="id"><form:errors path="id"/><br>
		<input type="password" name="pass"><form:errors path="pass"/><br>
		<input type="password" name="passConf"><form:errors path="passConf"/><form:errors path="passConfValid"/><br>
		<input type="text" name="tel"><form:errors path="tel"/><form:errors path="telValid"/><br>
		<input type="text" name="zip"><form:errors path="id"/><form:errors path="zipValid"/><br>
		<input type="radio" name="sex" value="0">男性
		<input type="radio" name="sex" value="1">女性<form:errors path="sex"/><br>
		
		<input type="submit" value="send">
	</form>
	
	
	<form action="${pageContext.servletContext.contextPath}/check2.html" method="POST">
		<input type="text" name="parameter"><form:errors path="parameter"/><br>
		
		<input type="submit" value="send">
	</form>

</body>
</html>