<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<h2>거래 내역 조회</h2>
		<a href="/ErdBank/account/list.do">⬅ 뒤로가기</a>
		
		<table border="1">
			<tr>
				<th>거래일자</th>
				<th>거래분류</th>
				<th>거래금액</th>
			</tr>
			<c:forEach var="dto" items="${dtoList}" >
			<tr>
				<td>${dto.t_datetime}</td>
				<td>
					<c:if test="${dto.t__dist=='1'}">
						입금
					</c:if>
					<c:if test="${dto.t__dist=='2'}">
						출금
					</c:if>
					<c:if test="${dto.t__dist=='3'}">
						이체
					</c:if>
				
				
				</td>
				

				<td>${dto.t_amount}</td>
			</tr>
			</c:forEach>
		</table>
	</body>
</html>