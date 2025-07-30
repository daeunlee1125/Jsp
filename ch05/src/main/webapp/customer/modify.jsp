<%@page import="java.sql.Statement"%>
<%@page import="javax.sql.DataSource"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="javax.naming.Context"%>
<%@page import="vo.CustomerDTO"%>
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
		Statement stmt = conn.createStatement();
		
		
		String sql = "SELECT * FROM CUSTOMER WHERE CID=?";
		PreparedStatement psmt = conn.prepareStatement(sql);
		psmt.setString(1, cid);
		
		ResultSet rs = psmt.executeQuery();
		
		if (rs.next()){
			dto = new CustomerDTO();
			dto.setCid(rs.getString(1));
			dto.setName(rs.getString(2));
			dto.setHp(rs.getString(3));
			dto.setAddress(rs.getString(4));
			dto.setRdate(rs.getString(5));
		}

		rs.close();
		psmt.close();
		conn.close();
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	System.out.println(dto);
%>
    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>customer::list</title>
	</head>
	<body>
		<h3>CUSTOMER1 수정</h3>
		
		<a href="../dbcp.jsp">처음으로</a>
		<a href="./list.jsp">목록이동</a>
		
		<form action="./proc/modify.jsp" method="post">
			<table border="1">
				<tr>
					<td>아이디</td>
					<td><input type="text" name="cid" readonly value="<%= dto.getCid() %>" placeholder="아이디 입력"></td>
				</tr>
				<tr>
					<td>이름</td>
					<td><input type="text" name="name" value="<%= dto.getName() %>" placeholder="이름 입력"></td>
				</tr>
				<tr>
					<td>휴대폰</td>
					<td><input type="text" name="hp" value="<%= dto.getHp() %>" placeholder="휴대폰 입력(- 포함)"></td>
				</tr>
				<tr>
					<td>주소</td>
					<td><input type="text" name="address" value="<%= dto.getAddress() %>" placeholder="주소 입력"></td>
				</tr>
				<tr>
					<td>등록일</td>
					<td><input type="date" name="rdate" value="<%= dto.getRdate() %>" placeholder="날짜 입력"></td>
				</tr>
				<tr>
					<td colspan="2" align="right">
						<input type="submit" value="수정하기">
					</td>
				</tr>
			
			</table>
		</form>
	
	</body>
</html>