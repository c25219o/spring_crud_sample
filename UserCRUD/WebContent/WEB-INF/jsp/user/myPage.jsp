<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/commonStyle.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/formStyle.css">
</head>
<body>

        <form action="<%=request.getContextPath()%>/user/changeExecute.html" name="passChange">
                <span id="errorMessage" class="errorMessage">${errorMessage}</span>

                <table>
                        <tr>
                                <td>現在のパスワード</td>
                                <td><input type="password" name="currentPassword" id="current"></td>
                                <td><span id="currentError" class="errorMessage"></span></td>
                        </tr>
                        <tr>
                                <td>新しいパスワード</td>
                                <td><input type="password" name="newPassword" id="newPass"></td>
                                <td><span id="newPassError" class="errorMessage"></span></td>
                        </tr>
                        <tr>
                                <td>新しいパスワード(再入力)</td>
                                <td><input type="password" name="newPassConfirm" id="newConf"></td>
                                <td><span id="newConfError" class="errorMessage"></span></td>
                        </tr>
                </table>
                <input type="submit" value="変更" onclick="return isValid()">

        </form>
        <script src="<%=request.getContextPath()%>/js/jquery-2.2.3.js"></script>
        <script src="<%=request.getContextPath()%>/js/passChange_validation.js"></script>
</body>
</html>