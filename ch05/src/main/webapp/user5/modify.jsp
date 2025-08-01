<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>User5::modify</title>
	</head>
	<body>
		<h3>User5::modify</h3>
		<a href="/ch05/jdbc.jsp">처음으로</a>
		<a href="/ch05/user5/list.jsp">목록으로</a>
		
		<form action="./proc/modify.jsp" method="post">
			<table>
				<tr>
					<td><input readonly type="text" name="name" placeholder="이름 입력"></td>
				</tr>
				<tr>
					<td><select name="gender"></select></td>
				</tr>
			
			</table>
		</form>
	</body>
</html>