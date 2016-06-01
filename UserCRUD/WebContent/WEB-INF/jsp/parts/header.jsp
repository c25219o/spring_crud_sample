<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div class="menu">

</div>

<div class="userInfo">
    ${loginInfo.userName} さん<br>
    <a href="<%=request.getContextPath()%>/logout.html">ログアウト</a>
</div>