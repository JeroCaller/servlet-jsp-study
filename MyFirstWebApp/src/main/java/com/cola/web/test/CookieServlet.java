package com.cola.web.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/cookie.do")
public class CookieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("euc-kr");
		
		// 요청 헤더에 있는 모든 쿠키 추출. 
		// 특정 쿠키 정보만 추출할 수는 없다고 한다. 
		Cookie[] cooks = request.getCookies();
		
		PrintWriter writer = response.getWriter();
		
		writer.println("<html><body>");
		writer.println("<h1>사용자 쿠키 정보</h1>");
		
		writer.println("<ul>");
		for (Cookie c : cooks) {
			writer.println("<li>");
			writer.println(c.getName() + " : " + c.getValue());
			writer.println("</li>");
		}
		
		writer.println("</ul>");
		writer.println("</body></html>");
		writer.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("euc-kr");
		
		// 요청으로부터 사용자가 전송한 데이터 추출.
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		
		// 추출한 데이터를 쿠키를 생성하여 저장. 
		Cookie idCook = new Cookie("id", id);
		Cookie passwordCook = new Cookie("password", password);
		
		// 클라이언트에 전송할 응답 헤더에 쿠키 포함.
		response.addCookie(idCook);
		response.addCookie(passwordCook);
		
		PrintWriter writer = response.getWriter();
		writer.println("""
				<html>
				<body>
					<h1>쿠키가 저장되었습니다.</h1>
					<a href="cookieSession.html">돌아가기</a>
				</body>
				</html>
				""");
		writer.close();
	}

}
