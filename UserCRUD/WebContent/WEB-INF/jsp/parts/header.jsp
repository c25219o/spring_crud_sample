<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<head>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/headerStyle.css">
</head>

<div class="menu">
<a href="xxxxxxxxxxxxxxx">商品検索</a>
<a href="xxxxxxxxxxxxxxx">カート</a>
<a href="xxxxxxxxxxxxxxx">マイページ</a>
</div>

<div class="userInfo">
    ${loginInfo.userName} さん<br>
    <a href="<%=request.getContextPath()%>/logout.html">ログアウト</a>
</div>