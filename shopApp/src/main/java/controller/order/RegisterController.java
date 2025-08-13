package controller.order;

import java.io.IOException;

import dto.CustomerDTO;
import dto.OrderDTO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import service.OrderService;

@WebServlet("/order/register.do")
public class RegisterController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	private OrderService service = OrderService.instance;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String prodNo = req.getParameter("prodNo");
		String prodCount = req.getParameter("prodCount");
		
		// 현재 사용자 세션 가져오기 (orderID set하기 위해)
		HttpSession session = req.getSession();
		CustomerDTO sessUser = (CustomerDTO) session.getAttribute("sessUser");
		
		//DTO 생성
		OrderDTO dto = new OrderDTO();
		dto.setOrderProduct(prodNo);
		dto.setOrderCount(prodCount);
		// 사용자 세션 attribute에서 가져옴
		dto.setOrderId(sessUser.getCustId());
		
		service.register(dto);
		
		// 뷰 포워드
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/order/list.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	
	}
}
