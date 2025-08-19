package controller.account;

import java.io.IOException;

import dto.AccountDTO;
import dto.CustomerDTO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import service.AccountService;

@WebServlet("/account/register.do")
public class RegisterController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	AccountService service = AccountService.INSTANCE;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/account/register.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String a_no = req.getParameter("a_no");
		String a_item_name = req.getParameter("a_item_name");
		String a_item_dist = "";
		if (a_item_name.equals("자유저축예금")) {
			a_item_dist = "S1";
		}else if (a_item_name.equals("정기저축예금")) {
			a_item_dist = "S3";
		}
		
		HttpSession session = req.getSession();
		CustomerDTO customer = (CustomerDTO) session.getAttribute("sessCustomer");
		
		String a_c_name = customer.getC_name();
		String a_c_no = customer.getC_no();
		int a_balance = 0;
		
		AccountDTO acc = new AccountDTO();
		acc.setA_no(a_no);
		acc.setA_item_name(a_item_name);
		acc.setA_item_dist(a_item_dist);
		acc.setA_c_no(a_c_no);
		acc.setA_balance(a_balance);
		
		service.regist(acc);
		
		resp.sendRedirect("/ErdBank/account/list.do");
	}

}
