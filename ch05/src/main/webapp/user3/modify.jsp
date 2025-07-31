<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.beans.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="vo.User3VO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	String user_id = request.getParameter("user_id");
	
	String host = "jdbc:oracle:thin:@localhost:1521:xe";
	String user = "daeunlee1125";
	String pass = "1234";
	
	User3VO user3VO = null;
	
	try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection conn = DriverManager.getConnection(host, user, pass);
		
		String sql = "SELECT * FROM USER3 WHERE user_id=?";
		PreparedStatement psmt = conn.prepareStatement(sql);
		psmt.setString(1, user_id);
		
		ResultSet rs = psmt.executeQuery();
		
		if (rs.next()){
			user3VO = new User3VO();
			user3VO.setUser_id(rs.getString(1));
			user3VO.setName(rs.getString(2));
			user3VO.setHp(rs.getString(3));
			user3VO.setAge(rs.getInt(4));
		}
		
		
		rs.close();
		psmt.close();
		conn.close();
		
	} catch (Exception e) {
		e.printStackTrace();
	}

%>
    
    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>User3::modify</title>
	</head>
	<body>
		<h3>User3 수정</h3>
		<a href = "../jdbc.jsp">처음으로</a>
		<a href = "./list.jsp">목록이동</a>
		
		<form action="./proc/modify.jsp" method="post">
			<table border=1>
				<tr>
					<td>아이디</td>
					<td><input type="text" name="user_id" readonly value= <%= user3VO.getUser_id() %> placeholder="아이디 입력"></td>
				</tr>
				<tr>
					<td>이름</td>
					<td><input type="text" name="name" value=<%= user3VO.getName() %> placeholder="이름 입력"></td>
				</tr>
				<tr>
					<td>휴대폰 번호(- 포함)</td>
					<td><input type="text" name="hp" value=<%= user3VO.getHp() %> placeholder="휴대폰 번호 입력"></td>
				</tr>
				<tr>
					<td>나이</td>
					<td><input type="number" name="age" value=<%= user3VO.getAge() %> placeholder="나이 입력"></td>
				</tr>
				<tr>
					<td><input type="submit" value="수정하기"></td>
				</tr>						
			
			</table>
		</form>
		
		
	</body>
</html>