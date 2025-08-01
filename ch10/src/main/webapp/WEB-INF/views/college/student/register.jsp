<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>College/Student::register</title>
	</head>
	<body>
		<h3>학생 목록</h3>
		
		<a href="/ch10/index">처음으로</a>
		<a href="/ch10/college/student/list.do">목록이동</a>
		
		<form action="/ch10/college/student/register.do" method="post">
			<table border="1">
				<tr>
					<td>학번</td>
					<td><input type="text" name="stdno" placeholder="아이디 입력"></td>
				</tr>
				<tr>
					<td>이름</td>
					<td><input type="text" name="name" placeholder="이름 입력"></td>
				</tr>
				<tr>
					<td>생년월일</td>
					<td><input type="date" name="birth" placeholder="생년월일 입력"></td>
				</tr>
				<tr>
					<td>전공</td>
					<td>
						<select name="major">
							<option>국문학과</option>
							<option>영문학과</option>
							<option>일문학과</option>
							<option>중문학과</option>
							<option>컴공학과</option>
							<option>통계학과</option>
							<option>수학학과</option>
						</select>
					</td>
				</tr>
				<tr>
					<td>입학일</td>
					<td><input type="date" name="enr_date" placeholder="입학일 입력"></td>
				</tr>
				<tr>
					<td colspan="2" align="right">
						<input type="submit" value="등록하기">
					</td>
				</tr>
			
			</table>
		</form>
	
	</body>
</html>