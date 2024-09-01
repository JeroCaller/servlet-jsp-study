package com.cola.web.user;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cola.db.lib.DBDaoVo;
import com.cola.db.lib.DBVo;

/**
 * Servlet implementation class SignUpServlet
 */
public class SignUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		System.out.println("쿼리 스트링: " + request.getQueryString());
		
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		
		System.out.println("id: " + id);
		System.out.println("password: " + password); */
		/*
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("euc-kr");
		
		PrintWriter printToPage = response.getWriter();
		
		printToPage.println("<html><body>");
		printToPage.println("<ul>");
		Enumeration<String> names = request.getParameterNames();
		while(names.hasMoreElements()) {
			String name = names.nextElement();
			
			printToPage.print("<li>" + name + " : ");
			for (String value : request.getParameterValues(name)) {
				printToPage.print(value + " | ");
			}
			printToPage.println("</li>");  // 개행
		}
		
		printToPage.println("</ul>");
		printToPage.println("</body></html>");
		
		printToPage.close(); */
		
		// 데이터 인코딩 설정
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("euc-kr");
		
		// 사용자 입력 데이터 추출
		String userId = request.getParameter("id");
		String password = request.getParameter("password");
		String role = request.getParameter("role");
		int uniqueId = 4;
		
		// DB 연동 및 데이터 작업 처리
		DBVo vo = new DBVo();
		vo.setUniqueId(uniqueId);
		vo.setUserName(userId);
		vo.setPassword(password);
		vo.setRole(role);
		
		DBDaoVo daoVo = new DBDaoVo();
		System.out.println("기존 테이블 내용");
		daoVo.printAllRecords();
		System.out.println();
		
		System.out.println("데이터 추가 후");
		daoVo.insertOneRecord(vo);
		daoVo.printAllRecords();
		
		// 회원가입 성공 후 로그인 화면으로 리다이렉트한다. 
		response.sendRedirect("login.html");
	}

}
