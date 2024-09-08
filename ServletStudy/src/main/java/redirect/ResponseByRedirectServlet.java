package redirect;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/response.do")
public class ResponseByRedirectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("euc-kr");
		
		PrintWriter out = response.getWriter();
		
		out.println("<h1>redirect된 곳입니다.</h1>");
		out.println("redirect의 요청 방식 : " + request.getMethod());
		out.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("euc-kr");
		
		PrintWriter out = response.getWriter();
		
		out.println("<h1>redirect된 곳입니다.</h1>");
		out.println("redirect의 요청 방식 : " + request.getMethod());
		out.close();
	}

}
