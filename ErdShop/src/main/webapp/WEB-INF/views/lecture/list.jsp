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
		<title>강좌목록</title>
	</head>
	<body>
		<h3>강좌목록</h3>
		
		<a href="/ErdCollege">처음으로</a>
		<a href="/ErdCollege/lecture/register.do">등록하기</a>
		
		<table border="1">
			<tr>
				<th>아이디</th>
				<th>이름</th>
				<th>휴대폰</th>
				<th>주소</th>
				<th>가입일</th>
				<th>관리</th>
			</tr>
			<%-- <c:forEach var ="customer" items="${dtoList}"> --%>
			<tr>
				<td>a101<%--  ${customer.cid}--%></td>
				<td>홍길동 <%-- ${customer.name }--%></td>
				<td>010-2222-3333<%-- ${customer.hp }--%></td> 
				<td>부산</td> 
				<td>3월 2일</td>
				<td>
					<!-- 수정하고자 하는 사용자 아이디를 modify.jsp에 파라미터로 전송 -->
					<a href="">수정</a>
					<a href="">삭제</a>
				</td>
			</tr>
			<%-- </c:forEach> --%>
		</table>
	
	</body>
</html>