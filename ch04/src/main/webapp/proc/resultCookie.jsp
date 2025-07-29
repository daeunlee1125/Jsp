<%@ page contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>resultCookie</title>
	</head>
	<body>
		<h3>쿠키 확인</h3>
		<%
			// 쿠키 출력 //
			Cookie[] cookies = request.getCookies();
		//하나는 디폴트 쿠키 나온당.
			for (Cookie c : cookies){
		%>
				<p>
					쿠키명 : <%= c.getName() %> <br>
					쿠키값 : <%= c.getValue() %> <br>
				</p>
		<%
			}
		%>
		
		<a href="../cookie.jsp">처음으로</a>
	
	</body>
</html>