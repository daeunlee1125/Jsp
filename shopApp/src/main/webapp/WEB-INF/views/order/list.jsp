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
		<title>shop/order::list</title>
	</head>
	<body>
		<h3>주문 목록</h3>
		
		<a href="/shopApp">처음으로</a>
		<a href="/shopApp/order/register.do">등록하기</a>
		
		<table border="1">
			<tr>
				<th>주문번호</th>
				<th>주문자</th>
				<th>주문상품</th>
				<th>주문수량</th>
				<th>주문일</th>
				<th>관리</th>
			</tr>
			<%--<c:forEach var ="customer" items="${dtoList}"> --%>
			<tr>
				<td>111<%--  ${customer.cid}--%></td>
				<td>홍길동 <%-- ${customer.name}--%></td>
				<td>초코파이<%-- ${customer.hp}--%></td> <!-- 표현언어에서는 getter 호출 대신 -->
				<td>23</td> <%-- 직접 이렇게 속성 참조해서 출력 가능 --%>
				<td>2000-10-01</td>
				<td>
					<!-- 수정하고자 하는 사용자 아이디를 modify.jsp에 파라미터로 전송 -->
					<a href="">수정</a>
					<a href="">삭제</a>
				</td>
			</tr>
			<%--</c:forEach>--%>
		</table>
	
	</body>
</html>