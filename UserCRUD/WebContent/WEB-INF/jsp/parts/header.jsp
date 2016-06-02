<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<head>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/headerStyle.css">
</head>

<div class="menu">
<a href="<%=request.getContextPath()%>/${loginInfo.authority}/shopping.html">商品検索</a>
<a href="<%=request.getContextPath()%>/${loginInfo.authority}/cart.html">カート</a>
<a href="<%=request.getContextPath()%>/${loginInfo.authority}/myPage.html">マイページ</a>
</div>

<div class="userInfo">
    ${loginInfo.userName} さん<br>
    <a href="<%=request.getContextPath()%>/logout.html">ログアウト</a>
</div>