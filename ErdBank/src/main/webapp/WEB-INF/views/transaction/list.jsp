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
		<title>거래목록</title>
	</head>
	<body>
		<h3>거래내역</h3>
		
		<a href="/ErdBank">처음으로</a>
		
		<table border="1">
			<tr>
				<th>거래번호</th>
				<th>계좌주</th>
				<th>분류</th>
				<th>거래금액</th>
				<th>거래일자</th>

			</tr>
			<c:forEach var ="dto" items="${dtoList}"> 
			<tr>
				<td>${dto.t_no}</td>
				<td>${dto.t_a_no }</td>
				<td>${dto.t__dist }</td> 
				<td>${dto.t_amount }</td> 
				<td>${dto.t_datetime }</td>

			</tr>
			</c:forEach>
		</table>
	
	</body>
</html>