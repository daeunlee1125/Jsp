<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Shop/order::register</title>
	</head>
	<body>
		<h3>주문 등록</h3>
		
		<a href="/shopApp">처음으로</a>
		<a href="/shopApp/order/list.do">목록이동</a>
		
		<form action="/shopApp/customer/register.do" method="post">
			<table border="1">
				<tr>
					<td>아이디</td>
					<td><input type="text" name="orderno" placeholder="아이디 입력"></td>
				</tr>
				<tr>
					<td>이름</td>
					<td><input type="text" name="orderid" placeholder="이름 입력"></td>
				</tr>
				<tr>
					<td>휴대폰</td>
					<td><input type="text" name="orderproduct" placeholder="휴대폰 입력(- 포함)"></td>
				</tr>
				<tr>
					<td>주소</td>
					<td><input type="text" name="ordercount" placeholder="주소 입력"></td>
				</tr>
				<tr>
					<td>등록일</td>
					<td><input type="date" name="orderdate" placeholder="날짜 입력"></td>
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