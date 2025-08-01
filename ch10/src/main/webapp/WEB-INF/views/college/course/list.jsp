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
		<title>college/student::list</title>
	</head>
	<body>
		<h3>college/Student 목록</h3>
		
		<a href="/ch10">처음으로</a>
		<a href="/ch10/college/student/list.do">등록하기</a>
		
		<table border="1">
			<tr>
				<th>학번</th>
				<th>이름</th>
				<th>생년월일</th>
				<th>전공</th>
				<th>입학일</th>
				<th>관리</th>
			</tr>
			
			<%--  
			<c:forEach var ="customer" items="${dtoList}">
			<tr>
				<td>${customer.cid}</td>
				<td>${customer.name }</td>
				<td>${customer.hp }</td> <!-- 표현언어에서는 getter 호출 대신 -->
				<td>${customer.address }</td> <!-- 직접 이렇게 속성 참조해서 출력 가능 -->
				<td>${customer.rdate }</td>
				<td>
					<!-- 수정하고자 하는 사용자 아이디를 modify.jsp에 파라미터로 전송 -->
					<a href="">수정</a>
					<a href="">삭제</a>
				</td>
			</tr>
			</c:forEach>
			--%>
			
			
		</table>
	
	</body>
</html>