package com.cola.web.test;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/session.do")
public class SessionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("euc-kr");
		
		HttpSession session = request.getSession();
		
		PrintWriter writer = response.getWriter();
		writer.println("<html><body>");
		writer.println("<h1> 사용자 세션 정보 </h1>");
		writer.println("<p>사용자 세션 ID: " + session.getId() + "</p>");
		writer.println("<p>사용자 접속 시각: " + new Date(session.getCreationTime()) + "</p>");
		if (session.isNew()) {
			writer.println("<p> 당신은 이곳에 처음 접속하셨습니다. </p>");
		} else {
			writer.println("<p> 당신은 이곳에 이미 접속한 적이 있습니다. </p>");
		}
		
		writer.println("<h2>사용자 정보</h2>");
		writer.println("<ul>");
		Enumeration<String> names = session.getAttributeNames();
		while (names.hasMoreElements()) {
			String name = names.nextElement();
			writer.println("<li>");
			writer.println(name + " : " + session.getAttribute(name));
			writer.println("</li>");
		}
		writer.println("</ul>");
		writer.println("</body></html>");
		writer.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("euc-kr");
		
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		
		// 사용자 요청 헤더의 쿠키 내 세션 ID가 있으면 해당 세션 객체 반환. 
		// 없으면 새로운 세션 객체 생성하여 반환.
		HttpSession session = request.getSession();
		
		session.setAttribute("id", id);
		session.setAttribute("password", password);
		
		PrintWriter writer = response.getWriter();
		writer.printf("""
				<html>
				<body>
					<h1> 사용자가 입력한 정보가 세션에 입력되었습니다. </h1>
					<p>사용자 세션 ID: %s</p>
					<a href="cookieSession.html">돌아가기</a>
				</body>
				</html>
				""", session.getId());
		writer.close();
	}

}
