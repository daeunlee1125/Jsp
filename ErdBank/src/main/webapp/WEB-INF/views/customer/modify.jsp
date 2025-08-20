<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<h2>개인정보 수정</h2>
		<a href="/ErdBank/customer/list.do">⬅ 뒤로가기</a>
		<form action="/ErdBank/customer/modify.do" method="post">
			<table border="1">
				<tr>
					<td>주민번호</td>
					<td><input type="text" name="c_no" value="${sessCustomer.c_no}" readonly></td>
				</tr>
				<tr>
					<td>이름</td>
					<td><input type="text" name="c_name" value="${sessCustomer.c_name}"></td>
				</tr>
				<tr>
					<td>전화번호</td>
					<td><input type="text" name="c_phone" value="${sessCustomer.c_phone}"></td>
				</tr>
				<tr>
					<td>주소</td>
					<td>
						<input type="text" name="c_addr" value="${sessCustomer.c_addr}">
					</td>
					
				</tr>
				<tr>
					
					<td colspan="2" align="right"><input type="submit" value="수정하기"></td>
				</tr>

			
			</table>
		</form>
		
	</body>
</html>