<%@page import="vo.CustomerDTO"%>
<%@page import="javax.sql.DataSource"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="javax.naming.Context"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="vo.User1VO"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	List<CustomerDTO> customers = new ArrayList<>();
	try {
		
		Context ctx = (Context) new InitialContext().lookup("java:comp/env"); // 환경 객체 생성
		DataSource ds = (DataSource) ctx.lookup("jdbc/daeunlee1125"); // jdbc/daeunlee1125 커넥션풀 객체 검색
		
		Connection conn = ds.getConnection();
		Statement stmt = conn.createStatement();
		
		ResultSet rs = stmt.executeQuery("SELECT * FROM CUSTOMER");
		
		while (rs.next()){
			CustomerDTO dto = new CustomerDTO();
			dto.setCid(rs.getString(1));
			dto.setName(rs.getString(2));
			dto.setHp(rs.getString(3));
			dto.setAddress(rs.getString(4));
			dto.setRdate(rs.getString(5));
			
			customers.add(dto);
		}
		
		rs.close();
		stmt.close();
		conn.close();
		
	} catch (Exception e) {
		e.printStackTrace();
	}

%>


<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>customer::list</title>
	</head>
	<body>
		<h3>customer 목록</h3>
		
		<a href="../dbcp.jsp">처음으로</a>
		<a href="./register.jsp">등록하기</a>
		
		<table border="1">
			<tr>
				<th>아이디</th>
				<th>이름</th>
				<th>휴대폰</th>
				<th>주소</th>
				<th>등록일</th>
				<th>관리</th>
			</tr>
			<%  for(CustomerDTO dto : customers) { %>
			<tr>
				<td><%= dto.getCid() %></td>
				<td><%= dto.getName() %></td>
				<td><%= dto.getHp() %></td>
				<td><%= dto.getAddress() %></td>
				<td><%= dto.getRdate().substring(0, 10) %></td>
				<td>
					<a href="/ch05/customer/modify.jsp?cid=<%= dto.getCid() %>">수정</a>
					<a href="#">삭제</a>
				</td>
			</tr>
			
			<% } %>
		
		</table>
	
	</body>
</html>