package controller.user1;

import java.io.IOException;

import dto.User1DTO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.User1Service;

@WebServlet("/user1/register.do")
public class RegisterController extends HttpServlet {


	private static final long serialVersionUID = 1L;
	private User1Service service = User1Service.INSTANCE;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		/*
		 * View forward
		 * - jsp 파일에 직접 요청을 못하게 하기 위해 WEB-INF 폴더 하위에 view 페이지 작성
		 * - jsp 페이지로 Controller의 request와 response 객체 공유
		 */
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/user1/register.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// 전송 데이터 수신
		String uid = req.getParameter("uid");
		String name = req.getParameter("name");
		String hp = req.getParameter("hp");
		String age = req.getParameter("age");
		
		User1DTO dto = new User1DTO();
		dto.setUid(uid);
		dto.setName(name);
		dto.setHp(hp);
		dto.setAge(age);
		service.register(dto);
		
		resp.sendRedirect("/ch10/user1/list.do");
	}
	

}
