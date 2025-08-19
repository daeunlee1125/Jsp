<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>계좌등록</title>
	</head>
	<body>
		<h3>계좌등록</h3>
		
		<a href="/ErdBank">처음으로</a>
		<a href="/ErdBank/account/list.do">목록이동</a>
		
		
		<form action="/ErdBank/account/register.do" method="post">
			<table border="1">
				<tr>
					<td>계좌번호</td>
					<td><input type="text" name="a_no" placeholder="101-11-OOOO"></td>
				</tr>
				<tr>
					<td>계좌분류</td>
					<td>
						<select name="a_item_name">
							<option>자유저축예금</option>
							<option>정기저축예금</option>
						</select>
					</td>
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