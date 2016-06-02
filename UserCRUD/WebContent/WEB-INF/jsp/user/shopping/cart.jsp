<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<title></title>
<meta charset="UTF-8">
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/commonStyle.css">
</head>
<body>

        <c:choose>
                <c:when test="${empty goodsInCartList}">
                        <div class="paragraph">
                                カートにはまだ何も入っていません<br>
                                メニューから「商品検索」をクリックし、買い物を始めましょう！
                        </div>
                </c:when>
                <c:otherwise>
                        <div class="paragraph">
                        <table class="general">
                                                <tr>
                                                        <th class="goodsName">商品名</th>
                                                        <th class="goodsExp">商品詳細</th>
                                                        <th class="maker">メーカー</th>
                                                        <th class="price">価格</th>
                                                        <th class="count">個数</th>
                                                        <th class="buy">小計</th>
                                                </tr>
                                                <c:forEach var="goods" items="${goodsInCartList}">
                                                        <tr>
                                                                <td>${goods.goodsName}</td>
                                                                <td>${goods.goodsExp}</td>
                                                                <td>${goods.maker}</td>
                                                                <td class="centering">￥${goods.goodsPrice}</td>
                                                                <td class="centering">${cart.count[goods.goodsNum]}</td>
                                                                <td class="centering">${goods.goodsPrice * cart.count[goods.goodsNum]}</td>
                                                        </tr>
                                                </c:forEach>
                                                <tr>
                                                        <td colspan="5" class="right">合計金額</td>
                                                        <td class="centering"><span id="totalPrice">${totalPrice}</span></td>
                                                </tr>
                                        </table>
                        </div>
                </c:otherwise>
        </c:choose>

        ${loginInfo.userName}さんのカート




</body>
</html>