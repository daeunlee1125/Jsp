<%@page import="java.sql.PreparedStatement"%>
<%@page import="javax.sql.DataSource"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="javax.naming.Context"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    
<%
	String cid = request.getParameter("cid");
	String name = request.getParameter("name");
	String hp = request.getParameter("hp");
	String address = request.getParameter("address");
    String rdate = request.getParameter("rdate");
	

	
	try {
		
		Context ctx = (Context) new InitialContext().lookup("java:comp/env"); // 환경 객체 생성
		DataSource ds = (DataSource) ctx.lookup("jdbc/daeunlee1125"); // jdbc/daeunlee1125 커넥션풀 객체 검색
		
		Connection conn = ds.getConnection();
		Statement stmt = conn.createStatement();
		
		String sql = "UPDATE CUSTOMER SET NAME=?, HP=?, ADDRESS=?, RDATE=? WHERE CID=?";
		PreparedStatement psmt = conn.prepareStatement(sql);
		psmt.setString(1, name);
		psmt.setString(2, hp);
		psmt.setString(3, address);
		psmt.setString(4, rdate);
		psmt.setString(5, cid);

		psmt.executeUpdate();
		
		psmt.close();
		conn.close();
		
	} catch (Exception e){
		e.printStackTrace();
	}
	
	response.sendRedirect("../list.jsp");
	
    
    %>