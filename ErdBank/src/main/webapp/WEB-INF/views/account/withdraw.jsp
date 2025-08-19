<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>계좌출금</h3>
		
	<a href="/ErdBank">처음으로</a>
	<a href="/ErdBank/account/list.do">목록이동</a>
	
	<form action="/ErdBank/account/withdraw.do" method="post">
		<table border="1">
			<tr>
				<td>계좌번호</td>
				<td><input type="text" name="a_no" value="${account.a_no}"></td>
			</tr>
			<tr>
				<td>계좌주</td>
				<td><input type="text" name="c_name" placeholder="이름 입력"></td>
			</tr>
			<tr>
				<td>출금액</td>
				<td><input type="number" name="t_amount" placeholder="10000"></td>
			</tr>
			
			<tr>
				<td colspan="2" align="right">
					<input type="submit" value="출금하기">
				</td>
			</tr>
		
		</table>
	</form>
</body>
</html>