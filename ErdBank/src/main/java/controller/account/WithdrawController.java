package controller.account;

import java.io.IOException;


import dto.AccountDTO;
import dto.CustomerDTO;
import dto.TransactionDTO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import service.AccountService;
import service.TransactionService;

@WebServlet("/account/withdraw.do")
public class WithdrawController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	AccountService service = AccountService.INSTANCE;
	TransactionService tservice = TransactionService.INSTANCE;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);
		CustomerDTO cusdto = (CustomerDTO) session.getAttribute("sessCustomer");
		AccountDTO accdto = service.findById(cusdto.getC_no());
		req.setAttribute("account", accdto);
		
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/account/withdraw.jsp");
		dispatcher.forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String a_no = req.getParameter("a_no");
		String c_name = req.getParameter("c_name");
		String t_amount = req.getParameter("t_amount");
		
		AccountDTO dto = service.findByAcc(a_no);
		
		TransactionDTO tdto = new TransactionDTO();
		tdto.setT_a_no(a_no);
		tdto.setT__dist(2);
		tdto.setT_amount(t_amount);
		
		service.withdraw(dto, Integer.parseInt(t_amount));
		tservice.addTrans(tdto);
		
		resp.sendRedirect("/ErdBank/account/list.do");
	}
	
	
}
