<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<h3 style="width: 230px">정말로 탈퇴하시겠습니까?</h3>
		<div style="width: 200px">
			<a href="/ErdBank/customer/delete.do?c_no=${c_no}"><button>Yes</button></a>
			&nbsp;&nbsp;
			<a href="/ErdBank/customer/redirect.do"><button>No</button></a>
			
		</div>
	</body>
</html>