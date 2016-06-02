<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Enumeration"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<title>ログインしてください</title>
<meta charset="UTF-8">
<link rel="stylesheet"
    href="<%=request.getContextPath()%>/css/commonStyle.css">
<link rel="stylesheet"
    href="<%=request.getContextPath()%>/css/formStyle.css">
</head>
<body>
    <div class="fieldwrapper">
        <%
          Enumeration<String> iterator = request.getParameterNames();
          while (iterator.hasMoreElements()) {
        %>
        <c:out value="<%=iterator.nextElement()%>" />
        <%
          }
        %>
        <div class="paragraph">Please log in.</div>
        <form action="login.html" method="POST">
            <table class="inForm">
                <tr>
                    <td>User ID</td>
                    <td>PASSWORD</td>
                </tr>
                <tr>
                    <td><input type="text" name="userId" id="userId"
                        placeholder="more than 6 characters" class="textInput"
                        required autofocus></td>
                    <td><input type="password" name="password" id="password"
                        placeholder="more than 6 characters" class="textInput"
                        required></td>
                </tr>
                <tr>
                    <td><c:if test="${hasError}">
                            <span id="loginError" class="errorMessage">${errorMessage}</span>
                            </c:if>
                            <span id="idError" class="errorMessage"></span>
                    </td>
                    <td><span id="passError" class="errorMessage"></span></td>
                </tr>


                <tr>
                    <td colspan="2"><input type="submit" value="LOG IN"
                        class="formButton" onclick="return isValid()"></td>
                </tr>
            </table>
        </form>
    </div>
    <script src="js/jquery-2.2.3.js"></script>
    <script src="js/login_validation.js"></script>
</body>
</html>