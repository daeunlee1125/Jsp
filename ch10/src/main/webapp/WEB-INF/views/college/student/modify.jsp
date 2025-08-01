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
		<title>modify</title>
	</head>
	<body>
		<h3>학생 정보 수정</h3>
		
		<a href="/ch10/index">처음으로</a>
		<a href="/ch10/college/student/list.do">목록이동</a>
		
		<form action="/ch10/college/student/modify.do" method="post">
			<table border="1">
				<tr>
					<td>학번</td>
					<td><input type="text" name="stdno" readonly value="${dto.stdno}" placeholder="아이디 입력"></td>
				</tr>
				<tr>
					<td>이름</td>
					<td><input type="text" name="name" value="${dto.name}" placeholder="이름 입력"></td>
				</tr>
				<tr>
					<td>생년월일</td>
					<td><input type="date" name="birth" value="${dto.birth}"></td>
				</tr>
				<tr>
					<td>전공</td>
					<td><input type="text" name="major" value="${dto.major}" placeholder="숫자 입력"></td>
				</tr>
				<tr>
					<td>입학일</td>
					<td><input type="date" name="enr_date" value="${dto.enr_date}" placeholder="숫자 입력"></td>
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