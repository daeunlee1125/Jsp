<%@page import="service.User1Service"%>
<%@page import="dto.User1DTO"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@ page contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>user1::list</title>
	</head>
	<body>
		<h3>User1 수정</h3>
		
		<a href="/ch10">처음으로</a>
		<a href="/ch10/user1/list.do">목록이동</a>
		
		<form action="/ch10/user1/modify.do" method="post">
			<table border="1">
				<tr>
					<td>아이디</td>
					<td><input type="text" name="uid" readonly value="${user1DTO.uid}" placeholder="아이디 입력"></td>
				</tr>
				<tr>
					<td>이름</td>
					<td><input type="text" name="name" value="${user1DTO.name}" placeholder="이름 입력"></td>
				</tr>
				<tr>
					<td>휴대폰</td>
					<td><input type="text" name="hp" value="${user1DTO.hp}" placeholder="휴대폰 입력(- 포함)"></td>
				</tr>
				<tr>
					<td>나이</td>
					<td><input type="number" name="age" value="${user1DTO.age}" placeholder="숫자 입력"></td>
				</tr>
				<tr>
					<td colspan="2" align="right">
						<input type="submit" value="수정하기">
					</td>
				</tr>
			
			</table>
		</form>
	
	</body>
</html>