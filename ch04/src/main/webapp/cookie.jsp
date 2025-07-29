<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>cookie</title>
		<!-- 
			날짜 : 2025/07/29
			이름 : 이다은
			내용 : JSP 쿠키 실습하기
		 -->
	</head>
	<body>
		<h3>쿠키 실습하기</h3>
		
		<form action="./proc/createCookie.jsp" method="post">
			<input type="text" name="id" placeholder="아이디 입력"> <br>
			<input type="password" name="pw" placeholder="패스워드 입력"> <br>
			<!-- submit을 누르면 action 주소로 위에 받은 input값이 전송된다! -->
			<input type="submit" value="로그인">
		</form>
		
			
	</body>
</html>