<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Enumeration"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<title>ページが見つかりません</title>
<meta charset="UTF-8">
<meta http-equiv="refresh" content="5; url=<%=request.getContextPath()%>">
<link rel="stylesheet"
    href="<%=request.getContextPath()%>/css/commonStyle.css">
<link rel="stylesheet"
    href="<%=request.getContextPath()%>/css/formStyle.css">
</head>
<body>

エラーが発生しました。<br>
5秒後にログイン画面に遷移します。<br>
ページが自動で切り替わらない場合は<a href="<%=request.getContextPath()%>">こちら</a>


</body>
</html>