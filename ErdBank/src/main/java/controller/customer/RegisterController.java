package controller.customer;

import java.io.IOException;

import dto.CustomerDTO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.CustomerService;

@WebServlet("/customer/register.do")
public class RegisterController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	CustomerService service = CustomerService.INSTANCE;
	

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String c_no = req.getParameter("c_no");
		String c_name = req.getParameter("c_name");
		String c_dist = req.getParameter("c_dist");
		String c_phone = req.getParameter("c_phone");
		String c_addr = req.getParameter("c_addr");
		
		CustomerDTO dto = new CustomerDTO();
		dto.setC_no(c_no);
		dto.setC_name(c_name);
		dto.setC_dist(c_dist);
		dto.setC_phone(c_phone);
		dto.setC_addr(c_addr);
		
		service.regist(dto);
		
		resp.sendRedirect("/ErdBank");
		
	}

}
