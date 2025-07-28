<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>responseFile</title>
	</head>
	<body>
		<h3>responseFile 페이지</h3>
		<%
			// 해당 페이지를 파일로 응답
			// responseFile 페이지 파일이 다운로드된다!
			response.setHeader("Content-type", "application/octet-stream");
		%>
	</body>
</html>