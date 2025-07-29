<%@page import="vo.UserVO"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%
	// 자동 로그인 여부 확인
	Cookie[] cookies = request.getCookies();
	
	if (cookies != null){
		for(Cookie cookie : cookies){
			if (cookie.getName().equals("auto")){
				String id = cookie.getValue();
				
				// 사용자 객체 생성
				UserVO vo = new UserVO();
				vo.setId(id);
				
				// 세션 처리
				session.setAttribute("sessUser", vo);
				
				// 로그인 성공 페이지 이동
				response.sendRedirect("./proc/sessionSuccess.jsp");
				return; // 처리 종료
			}
		}
	}

%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>session</title>
		<!-- 
			날짜 : 2025/07/29
			이름 : 이다은
			내용 : JSP 세션 실습하기
		 -->
	</head>
	<body>
		<h3>session 실습하기</h3>
		
		<h4>session ID 확인</h4>
		<p>
			<!-- 값이 똑같다! -->
			session : <%= session.getId() %> <br>
			request session : <%= request.getSession().getId() %>
		</p>
		
		<h4>세션 로그인</h4>
		<form action="./proc/sessionLogin.jsp" method="post">
			<input type="text" name="id" placeholder="아이디 입력"> <br>
			<input type="password" name="pw" placeholder="패스워드 입력"> <br>
			<label style="font-size: 12px"><input type="checkbox" name="auto" value="true">자동로그인</label> <br>
			<!-- submit을 누르면 action 주소로 위에 받은 input값이 전송된다! -->
			<input type="submit" value="로그인">
		</form>
		
			
	</body>
</html>