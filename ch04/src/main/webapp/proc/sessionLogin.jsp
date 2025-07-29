<%@page import="vo.UserVO"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%
	// 전송 데이터 수신
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
		// 체크하면 true 반환, 체크 안 했으면 null이다!
	String auto = request.getParameter("auto");
	
	
	// 데이터베이스에서 사용자 조회 후, 사용자 객체(VO) 생성
	UserVO vo = null;
	
	if (id.equals("abc123") && pw.equals("1234")){
		vo = new UserVO();
		vo.setId(id);
		vo.setPw(pw);
		vo.setName("김유신");
		vo.setAge(23);
	}

	
	if (vo!= null){
		// 자동로그인 처리
		if (auto!=null){
			Cookie autoCookie = new Cookie("auto", id);
			autoCookie.setMaxAge(60 * 60 * 24 * 7); // 7일
			autoCookie.setPath("/");
			
			response.addCookie(autoCookie);
		}
		
		
		// 사용자가 회원이면, 세션에 사용자 객체 저장
		session.setAttribute("sessUser", vo);
		// 리다이렉트(페이지 이동)
		response.sendRedirect("./sessionSuccess.jsp");
	} else{
		// 사용자가 회원이 아니면, 다시 로그인 화면으로
		out.println("회원이 아닙니다.");
		response.sendRedirect("../session.jsp");
	}
%>