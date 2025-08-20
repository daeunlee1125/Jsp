<%@page import="java.sql.Statement"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>


<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>고객목록</title>
	</head>
	<body>
		<h3>고객목록</h3>
		
		<a href="/ErdBank">처음으로</a>
		
		<table border="1">
			<tr>
				<th>주민번호</th>
				<th>이름</th>
				<th>고객분류</th>
				<th>전화번호</th>
				<th>주소</th>
				<th>관리</th>
			</tr>
			<c:forEach var ="dto" items="${dtoList}">
			<tr>
				<td>${dto.c_no }</td>
				<td>${dto.c_name}</td>
				<td>${dto.c_dist }</td> 
				<td>${dto.c_phone }</td> 
				<td>${dto.c_addr }</td>
				<c:if test="${sessCustomer.c_no eq dto.c_no}">
				<td>
					<a href="/ErdBank/customer/modify.do"><button>수정</button></a>
					<button onclick="openPopup()">탈퇴</button>
				</td>
				</c:if>
			</tr>
			</c:forEach> 
		</table>
		
		<script>
			function openPopup() {
				var popupWidth = 240;
				var popupHeight = 120;
				var popupLeft = (window.screen.width - popupWidth) / 2;
	            var popupTop = (window.screen.height - popupHeight) / 2;
	            var popupOptions = "width=" + popupWidth + ",height=" + popupHeight + ",left=" + popupLeft + ",top=" + popupTop;
	            
	            window.open("/ErdBank/customer/deletePopup.do?c_no=${sessCustomer.c_no}", "popupWindow", popupOptions);
	            
			}
		</script>
	</body>
</html>