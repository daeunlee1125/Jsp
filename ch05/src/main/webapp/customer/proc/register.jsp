<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="javax.sql.DataSource"%>
<%@page import="javax.naming.Context"%>
<%@page import="javax.naming.InitialContext"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    
<%
	// 전송 데이터 수신
	String cid = request.getParameter("cid");
	String name = request.getParameter("name");
	String hp = request.getParameter("hp");
	String address = request.getParameter("address");
	String rdate = request.getParameter("rdate");
	
	try{
		// DBCP 커넥션풀 객체 가져오기
		Context initCtx = new InitialContext(); // 환경 객체 생성
		Context ctx = (Context) initCtx.lookup("java:comp/env"); // java 기본 환경 객체 검색
		DataSource ds = (DataSource) ctx.lookup("jdbc/daeunlee1125"); // jdbc/daeunlee1125 커넥션풀 객체 검색
		
		// 커넥션풀에서 접속 커넥션 가져오기
		Connection conn = ds.getConnection();
		
		// 여기부터 그냥 똑같음! SQL 실행객체 생성
		String sql = "INSERT INTO CUSTOMER VALUES(?,?,?,?,?)";
		PreparedStatement psmt = conn.prepareStatement(sql);
		psmt.setString(1, cid);
		psmt.setString(2, name);
		psmt.setString(3, hp);
		psmt.setString(4, address);
		psmt.setString(5, rdate);
		
		psmt.executeUpdate();
		
		psmt.close();
		conn.close();
		
	} catch (Exception e){
		e.printStackTrace();
	}
	
	response.sendRedirect("../list.jsp");
%>
    