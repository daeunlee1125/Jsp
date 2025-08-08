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
		<title>user1::list</title>
	</head>
	<body>
		<h3>User1 목록</h3>
		
		<a href="/ch10">처음으로</a>
		<a href="/ch10/user1/register.do">등록하기</a>
		
		<table border="1">
			<tr>
				<th>아이디</th>
				<th>이름</th>
				<th>휴대폰</th>
				<th>나이</th>
				<th>관리</th>
			</tr>
			<c:forEach var="dto" items="${requestScope.dtoList}"> <!-- Controller에서 request 객체로 setAttribute 저장한 dtoList -->
			<tr>
				<td>${dto.uid}</td>
				<td>${dto.name}</td>
				<td>${dto.hp}</td> <!-- 표현언어에서는 getter 호출 대신 -->
				<td>${dto.age}</td> <!-- 직접 이렇게 속성 참조해서 출력 가능 -->
				<td>
					<!-- 수정하고자 하는 사용자 아이디를 modify.jsp에 파라미터로 전송 -->
					<a href="/ch10/user1/modify.do?uid=${dto.uid}">수정</a>
					<a href="/ch10/user1/delete.do?uid=${dto.uid}">삭제</a>
				</td>
			</tr>
			</c:forEach>
		
		</table>
	
	</body>
</html>