<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Bank</title>
		
	</head>
	
	<body>
		<h3>미니 뱅킹관리 프로젝트</h3>
		
		<c:if test="${empty sessionScope.sessCustomer }">
			<p>
				그린은행에 오신 것을 환영합니다.<br>
				계좌이체를 하려면 로그인을 하시기 바랍니다.<br>
				로그인을 해야 서비스를 이용할 수 있습니다.
			</p>
			
			<h4>로그인</h4>
			<form action="/ErdBank/customer/login.do" method="post">
				<table border="1">
					<tr>
						<td style="padding:5px;">주민번호</td>
						<td><input type="text" name="c_no" placeholder="주민번호 입력"></td>
					</tr>
					<tr>
						<td style="padding:5px;">이름</td>
						<td><input type="text" name="c_name" placeholder="이름 입력"></td>
					</tr>
					<tr>
						<td colspan="2" align="right">
							<input type="submit" value="로그인">
						</td>
					</tr>
				
				</table>
			</form>
			<h4>회원가입</h4>
			<form action="/ErdBank/customer/register.do" method="post">
				<table border="1">
					<tr>
						<td style="padding:5px;">주민번호</td>
						<td><input type="text" name="c_no" placeholder="주민번호 입력"></td>
					</tr>
					<tr>
						<td style="padding:5px;">이름</td>
						<td><input type="text" name="c_name" placeholder="이름 입력"></td>
					</tr>
					<tr>
						<td style="padding:5px;">고객 타입</td>
						<td>
							<select name="c_dist">
								<option value="1">개인</option>
								<option value="2">기업</option>
							</select>
						</td>
					</tr>
		
					<tr>
						<td style="padding:5px;">전화번호</td>
						<td><input type="text" name="c_phone" placeholder="휴대폰 번호(-포함)"></td>
					</tr>
					<tr>
						<td style="padding:5px;">주소</td>
						<td><input type="text" name="c_addr" placeholder="주소 입력"></td>
					</tr>
					<tr>
						<td colspan="2" align="right">
							<input type="submit" value="회원가입">
						</td>
					</tr>
				</table>
			</form>
		</c:if>
		
		<c:if test="${not empty sessionScope.sessCustomer }">
			<p>
				${sessCustomer.c_name }(${sessCustomer.c_no })님, 반갑습니다. 서비스를 이용하시기 바랍니다. <br>
				<a href="/ErdBank/customer/logout.do">로그아웃</a>
			</p>
		
			<a href="/ErdBank/account/list.do">계좌목록</a>
			<a href="/ErdBank/customer/list.do">고객목록</a>
			<a href="/ErdBank/transaction/list.do">거래내역</a>
		</c:if>
	</body>
</html>

