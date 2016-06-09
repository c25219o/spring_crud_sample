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
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/goodsTableStyle.css">
<title>商品一覧</title>
</head>
<body>
        <%@include file="/WEB-INF/jsp/parts/header.jsp"%>

        <div>
                <form action="<%=request.getContextPath()%>/${loginInfo.authority}/add.html">
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
                <c:if test="${pageNum != 1}">
                        <form action="<%=request.getContextPath()%>/${loginInfo.authority}/shopping.html"
                                method="POST" name="previous" class="inline">
                                <input type="hidden" name="pagingAction" value="previous"> <input type="hidden"
                                        name="currentPage" value="${pageNum}">
                                <input type="submit" value="前へ" class="textSubmit">
                        </form>
                </c:if>
                <c:if test="${!isLastPage}">
                        <form action="<%=request.getContextPath()%>/${loginInfo.authority}/shopping.html"
                                method="POST" name="next" class="inline">
                                <input type="hidden" name="pagingAction" value="next"> <input type="hidden"
                                        name="currentPage" value="${pageNum}">
                                <input type="submit" value="次へ" class="textSubmit">
                        </form>
                </c:if>
        </div>
        <div>
                <c:choose>
                        <c:when test="${empty goodsList}">
                                <div class="paragraph">
                                        条件に一致する商品が見つかりませんでした。<br> もう一度検索しなおしてください。
                                </div>
                        </c:when>
                        <c:otherwise>
                                <form action="${pageContext.servletContext.contextPath}/${loginInfo.authority}/addToCart.html" method="POST">
                                        <table class="general">
                                                <tr>
                                                        <th class="goodsName">商品名</th>
                                                        <th class="goodsExp">商品詳細</th>
                                                        <th class="maker">メーカー</th>
                                                        <th class="price">価格</th>
                                                        <th class="count">個数</th>
                                                        <th class="buy">購入</th>
                                                </tr>
                                                <c:forEach var="goods" items="${goodsList}">
                                                        <tr>
                                                                <td>${goods.goodsName}</td>
                                                                <td>${goods.goodsExp}</td>
                                                                <td>${goods.maker}</td>
                                                                <td class="centering">￥${goods.goodsPrice}</td>
                                                                <td class="centering"><input type="number" name="count" value="0"
                                                                        class="shortNumber"></td>
                                                                <td class="centering"><input type="checkbox" name="goodsNum"
                                                                        value="${goods.goodsNum}"></td>
                                                        </tr>
                                                </c:forEach>
                                                <tr>
                                                        <td colspan="3" class="right">合計金額</td>
                                                        <td class="centering"><span id="totalPrice">＊合計価格＊</span></td>
                                                        <td colspan="2" class="centering"><input type="submit" value="カートに追加する"></td>
                                                </tr>
                                        </table>
                                </form>
                        </c:otherwise>
                </c:choose>
        </div>
</body>
</html>