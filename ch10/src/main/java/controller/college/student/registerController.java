package controller.college.student;

import java.io.IOException;

import dto.college.StudentDTO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.college.StudentService;

@WebServlet("/college/student/register.do")
public class registerController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	// 서비스 객체 가져오기
	private StudentService service = StudentService.INSTANCE;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/college/student/register.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String stdno = req.getParameter("stdno");
		String name = req.getParameter("name");
		String birth = req.getParameter("birth");
		String major = req.getParameter("major");
		String enr_date = req.getParameter("enr_date");
		
		StudentDTO dto = new StudentDTO();
		dto.setStdno(stdno);
		dto.setName(name);
		dto.setBirth(birth);
		dto.setMajor(major);
		dto.setEnr_date(enr_date);
		
		service.register(dto);
		
		resp.sendRedirect("/ch10/college/student/list.do");
		
	}
	
}
