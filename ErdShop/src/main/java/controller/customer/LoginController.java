package controller.customer;

import java.io.IOException;

import dto.CustomerDTO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import service.CustomerService;

@WebServlet("/customer/login.do")
public class LoginController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	private CustomerService service = CustomerService.instance;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		
		// 뷰 포워드
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/customer/list.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String custId = req.getParameter("custId");
		
		// 회원이 아니면 null
		CustomerDTO customerDTO = service.findById(custId);
		
		if (customerDTO != null) {
			// 회원일 경우(세션처리)
			// 서버 관점에서 세션은 서버에 방문했던 클라이언트 명단임
			// DB에서 조회한 회원객체를 세션저장!
			HttpSession session = req.getSession();
			session.setAttribute("sessUser", customerDTO);
			
			// 상품목록 이동
			resp.sendRedirect("/shopApp/product/list.do?login=success");
		}else {
			
			// 회원이 아니면 상품목록 이동
			resp.sendRedirect("/shopApp/product/list.do?login=fail");
		}
		
	}
}
