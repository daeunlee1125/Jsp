<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>forward1</title>
	</head>
	<body>
		<h3>forward1 페이지</h3>
		<%
			// forward는 자원 내에서의 페이지 이동이기 때문에, 타서버 이동 안 됨
			pageContext.forward("../1_request.jsp");
		%>
	</body>
</html>