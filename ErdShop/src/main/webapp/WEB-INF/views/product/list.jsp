<%@page import="java.sql.Statement"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>


<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>shop/product::list</title>
	</head>
	<body>
		<h3>상품 목록</h3>
		
		<a href="/shopApp">처음으로</a>
		<a href="/shopApp/product/register.do">등록하기</a>
		
		<c:if test="${empty sessUser}">
			<form action="/shopApp/customer/login.do" method="post">
				<input type="text" name="custId" style="width:100px"/>
				<input type="submit" value="로그인"/>
			</form>
		</c:if>
		
		<c:if test="${not empty sessUser}">
			<p>
				${sessUser.name}(${sessUser.custId})님 반갑습니다.
				<a href="/shopApp/customer/logout.do">로그아웃</a>
			</p>
		</c:if>
		<table border="1">
			<tr>
				<th>상품번호</th>
				<th>상품명</th>
				<th>재고량</th>
				<th>가격</th>
				<th>제조사</th>
				<th>수량</th>
				<th>주문</th>
			</tr>
			<c:forEach var ="product" items="${dtoList}"> 
				<form action="/shopApp/order/register.do">
					<tr>
						<td>${product.prodNo}</td>
						<td>${product.prodName}</td>
						<td>${product.stock}</td> 
						<td>${product.price}</td>
						<td>${product.company}</td>
						<td>
							<input type="hidden" name="prodNo" value="${product.prodNo}">
							<%-- 우리 눈에는 안 보이지만 서버에 전송됨! --%>
							<input type="number" name="prodCount" style="width: 40px"/>
						</td>
						
						<td>
							<!-- 수정하고자 하는 사용자 아이디를 modify.jsp에 파라미터로 전송 -->
							<input type="submit" value="주문하기">
						</td>
					</tr>
				</form>
			</c:forEach>
		</table>
	
	</body>
</html>