<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>ログインしてください</title>
<meta charset="UTF-8">
<link rel="stylesheet"
    href="<%=request.getContextPath()%>/css/common.css">
</head>
<body>
    <div class="fieldwrapper">
        <div class="paragraph">Please log in.</div>
        <form action="login.html" method="POST">
            <table>
                <tr>
                    <td class="inForm">User ID</td>
                    <td class="inForm">PASSWORD</td>
                </tr>
                <tr>
                    <td class="inForm">
                      <input type="text" name="userId" placeholder="less than 8 characters" class="textInput" required>
                    </td>
                    <td class="inForm">
                      <input type="password" name="pass" placeholder="less than 8 characters" class="textInput" required>
                    </td>
                </tr>

                <tr>
                    <td colspan="2" class="inForm"><input type="submit" value="LOG IN" class="formButton"></td>
                </tr>
            </table>
        </form>
    </div>
</body>
</html>