<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="vo.User5VO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	List<User5VO> users = new ArrayList<>();

	String host = "jdbc:oracle:thin:@localhost:1521:xe";
	String user = "daeunlee1125";
	String pass = "1234";
	
	try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection conn = DriverManager.getConnection(host, user, pass);
		
		String sql = "SELECT * FROM USER5";
		Statement stmt = conn.createStatement();
		
		ResultSet rs = stmt.executeQuery(sql);
		while (rs.next()){
			User5VO vo = new User5VO();
			vo.setName(rs.getString(1));
			vo.setGender(rs.getString(2));
			vo.setAge(rs.getInt(3));
			vo.setAddr(rs.getString(4));
			
			users.add(vo);
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
		<title>User5::List</title>
	</head>
	<body>
		<h3>User5::List</h3>
		<a href="../jdbc.jsp">처음으로</a>
		<a href="./register.jsp">등록하기</a>
		
		<table border="1">
			<tr>
				<th>이름</th>
				<th>성별</th>
				<th>나이</th>
				<th>주소</th>
				<th>관리</th>
			</tr>
			<% for (User5VO us : users) {%>
			<tr>
				<td> <%= us.getName() %> </td>
				<td> <%= us.getGender() %> </td>
				<td> <%= us.getAge() %> </td>
				<td> <%= us.getAddr() %> </td>
				<td>
					<a href="./modify.jsp">수정</a>
					<a href="./delete.jsp">삭제</a>
				</td>
			</tr>
			<% } %>
		</table>
	
	</body>
</html>