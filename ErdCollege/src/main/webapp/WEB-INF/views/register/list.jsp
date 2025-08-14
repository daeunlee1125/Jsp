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
		<title>shop/customer::list</title>
	</head>
	<body>
		<h3>수강목록</h3>
		
		<a href="/ErdCollege">처음으로</a>
		<a href="/ErdCollege/enroll/register.do">등록하기</a>
		
		<table border="1">
			<tr>
				<th>학번</th>
				<th>강좌번호</th>
				<th>중간점수</th>
				<th>기말점수</th>
				<th>총점</th>
				<th>성적</th>
			</tr>
			<c:forEach var="dto" items="${dtoList}">
			<tr>
				<td>${dto.regStdNo}</td>
				<td>${dto.regLecNo}</td>
				<td>${dto.regMidScore }</td> 
				<td>${dto.regFinalScore}</td> 
				<td>${dto.regTotalScore}</td>
				<td>${dto.regGrade}</td>
				<td>
					<!-- 수정하고자 하는 사용자 아이디를 modify.jsp에 파라미터로 전송 -->
					<a href="">성적입력</a>
				</td>
			</tr>
			</c:forEach> 
		</table>
	
	</body>
</html>