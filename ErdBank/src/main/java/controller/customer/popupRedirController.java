package controller.customer;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/customer/redirect.do")
public class popupRedirController extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.setContentType("text/html; charset=UTF-8");
        String main = req.getContextPath() + "/customer/list.do"; // 메인으로 이동
        resp.getWriter().printf(
            "<script>" +
            "if (window.opener && !window.opener.closed) {" +
            "  window.opener.location.href='%s';" +   // 부모창을 메인으로
            "}" +
            "window.close();" +                        // 팝업 닫기
            "</script>", main
        );
	}
}
