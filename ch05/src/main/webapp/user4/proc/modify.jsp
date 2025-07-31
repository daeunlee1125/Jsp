<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="vo.User4VO"%>
<%@ page contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    
<%
	String name = request.getParameter("name");
	String gender = request.getParameter("gender");
	String age = request.getParameter("age");
	String addr = request.getParameter("addr");
	
	String host = "jdbc:oracle:thin:@localhost:1521:xe";
	String user = "daeunlee1125";
	String pass = "1234";
	
	User4VO user4VO = null;
	
	try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection conn = DriverManager.getConnection(host, user, pass);
		
		String sql = "UPDATE USER4 SET gender=?, age=?, addr=? WHERE name=?";
		PreparedStatement psmt = conn.prepareStatement(sql);
		psmt.setString(1, gender);
		psmt.setString(2, age);
		psmt.setString(3, addr);
		psmt.setString(4, name);
		
		psmt.executeUpdate();
		
		psmt.close();
		conn.close();
		
		
	} catch(Exception e) {
		e.printStackTrace();
	}
	
	response.sendRedirect("../list.jsp");

%>