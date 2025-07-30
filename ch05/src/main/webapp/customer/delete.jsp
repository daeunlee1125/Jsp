<%@page import="vo.CustomerDTO"%>
<%@page import="javax.sql.DataSource"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="javax.naming.Context"%>
<%@page import="vo.User1VO"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@ page contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	// 전송 데이터 수신
	String cid = request.getParameter("cid");

	
	CustomerDTO dto = null;

	try{
		
		Context ctx = (Context) new InitialContext().lookup("java:comp/env"); // 환경 객체 생성
		DataSource ds = (DataSource) ctx.lookup("jdbc/daeunlee1125"); // jdbc/daeunlee1125 커넥션풀 객체 검색
		
		Connection conn = ds.getConnection();
		
		String sql = "DELETE FROM CUSTOMER WHERE CID=?";
		PreparedStatement psmt = conn.prepareStatement(sql);
		psmt.setString(1, cid);
		
		psmt.executeUpdate();
		
		psmt.close();
		conn.close();
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	response.sendRedirect("./list.jsp");
%>
    
