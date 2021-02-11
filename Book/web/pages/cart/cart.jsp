<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>购物车</title>
	<%--静态包含base标签、css文件、js文件--%>
	<%@include file="/pages/common/header.jsp"%>
	<script>
		$(function () {
			$("a.deleteItem").click(function () {
			    return confirm("你确认删除【" +  $(this).parent().parent().find("td:first").text() + "】吗？");
            });
            $("#clearCart").click(function () {
                return confirm("你确认清空购物车吗？");
            });
            $("input.updateCount").change(function () {
				var bookId = $(this).attr("bookId");
				var bookName = $(this).parent().parent().find("td:first").text();
				var count = this.value;
				if(confirm("你确认将【" + bookName + "】商品的数量修改为" + count + "吗？")){
					location.href = "cart?action=updateCount&id=" + bookId + "&count=" + count;
				}else{
					this.value = this.defaultValue;
				}
            });
        });
	</script>
</head>
<body>
	
	<div id="header">
			<img class="logo_img" alt="" src="static/img/logo.gif" >
			<span class="wel_word">购物车</span>
		<%@include file="/pages/common/login_success_menu.jsp"%>
	</div>
	
	<div id="main">
	
		<table>
			<tr>
				<td>商品名称</td>
				<td>数量</td>
				<td>单价</td>
				<td>金额</td>
				<td>操作</td>
			</tr>
			<c:if test="${empty sessionScope.cart.items}">
				<td colspan="5"><a href="${basePath}">亲，你的购物车为空，快去首页采购吧！</a></td>
			</c:if>
			<c:if test="${not empty sessionScope.cart.items}">
				<c:forEach items="${sessionScope.cart.items}" var="entry">
					<tr>
						<td>${entry.value.name}</td>
						<td>
							<input class="updateCount" type="text" bookId="${entry.value.id}"
								   value="${entry.value.count}" style="width: 80px;">
						</td>
						<td>${entry.value.price}</td>
						<td>${entry.value.totalPrice}</td>
						<td>
							<a class="deleteItem" href="${basePath}cart?action=deleteItem&id=${entry.value.id}">删除</a>
						</td>
					</tr>
				</c:forEach>
			</c:if>
		</table>
		<c:if test="${not empty sessionScope.cart.items}">
			<div class="cart_info">
				<span class="cart_span">购物车中共有<span class="b_count">${sessionScope.cart.totalCount}</span>件商品</span>
				<span class="cart_span">总金额<span class="b_price">${sessionScope.cart.totalPrice}</span>元</span>
				<span class="cart_span"><a id="clearCart" href="cart?action=clear">清空购物车</a></span>
				<span class="cart_span"><a href="order?action=createOrder">去结账</a></span>
			</div>
		</c:if>
	</div>

	<%--静态包含尾部信息--%>
	<%@include file="/pages/common/footer.jsp"%>
</body>
</html>