<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/commonStyle.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/formStyle.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/tableBorderStyle.css">
<title>商品一覧</title>
</head>
<body>
        <%@include file="/WEB-INF/jsp/parts/header.jsp"%>

        <div>
                <form action="<%=request.getContextPath()%>/${loginInfo.authority}/shopping.html">
                        <table>
                                <tr>
                                        <td>商品名<input type="text" name="goodsName"></td>
                                        <td>価格<input type="text" name="minPrice" class="midiumNumber">～<input
                                                type="text" name="minPrice" class="midiumNumber">
                                        </td>
                                </tr>
                                <tr>
                                        <td>商品内容<input type="text" name="goodsExp"></td>
                                        <td>メーカー<input type="text" name="maker"></td>
                                </tr>
                                <tr>
                                        <td colspan="2"><input type="submit" value="検索"></td>
                                </tr>
                        </table>
                </form>
        </div>
        <div>
                <c:choose>
                        <c:when test="${empty goodsList}">
                                <div class="paragraph">
                                        条件に一致する商品が見つかりませんでした。<br> もう一度検索しなおしてください。
                                </div>
                        </c:when>
                        <c:otherwise>
                                <form action="" method="POST">
                                        <table>
                                                <tr>
                                                        <th>商品名</th>
                                                        <th>商品詳細</th>
                                                        <th>価格</th>
                                                        <th>個数</th>
                                                        <th>購入</th>
                                                </tr>
                                                <c:forEach var="goods" items="${goodsList}">
                                                        <tr>
                                                                <td>${goods.goodsName}</td>
                                                                <td>${goods.goodsExp}</td>
                                                                <td class="centering">￥${goods.goodsPrice}</td>
                                                                <td class="centering"><input type="number" name="count[]" value="0" class="shortNumber"></td>
                                                                <td class="centering"><input type="checkbox" name="goodsNum[]" value="${goodsNum}"></td>
                                                        </tr>
                                                </c:forEach>
                                                <tr>
                                                        <td colspan="2">合計金額</td>
                                                        <td><span id="totalPrice">＊合計価格＊</span></td>
                                                        <td colspan="2"><input type="submit" value="カートに追加する"></td>
                                                </tr>
                                        </table>
                                </form>
                        </c:otherwise>
                </c:choose>
        </div>
</body>
</html>