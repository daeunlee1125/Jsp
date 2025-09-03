package jboard.controller.article;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jboard.dto.ArticleDTO;
import jboard.dto.PagenationDTO;
import jboard.service.ArticleService;

@WebServlet("/article/list.do")
public class ListController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private ArticleService articleService = ArticleService.INSTANCE;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 페이지 번호 수신
		String pg = req.getParameter("pg");
		
		PagenationDTO pagenationDTO = articleService.getPagenationDto(pg);
		
		
		
		// 글 목록 조회
		List<ArticleDTO> dtoList = articleService.findAll(pagenationDTO.getStart());
		
		// request 공유참조(JSP에서 출력)
		req.setAttribute("dtoList", dtoList);
		req.setAttribute("lastPageNum", pagenationDTO.getLastPageNum());
		req.setAttribute("pageGroupStart", pagenationDTO.getPageGroupStart());
		req.setAttribute("pageGroupEnd", pagenationDTO.getPageGroupEnd());
		req.setAttribute("currentPageStartNum", pagenationDTO.getCurrentPageStartNum());
		req.setAttribute("currentPage", pagenationDTO.getCurrentPage());
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/article/list.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}

}
