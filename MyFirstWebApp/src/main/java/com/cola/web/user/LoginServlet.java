package com.cola.web.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
    	System.out.println("=== 로그인을 위한 서블릿 인스턴스가 생성되었습니다. ===");  // 변경된 코드.
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("=== GET 요청을 서블릿에서 처리하였습니다. ===");  // 변경된 코드.
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("=== POST 요청을 서블릿에서 처리하였습니다. ===");  // 변경된 코드.
	}
	
	//
	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		System.out.println("==== service() 메서드를 호출하여 요청을 처리하였습니다. =====");
	}

	@Override
	public void destroy() {
		System.out.println("==== 서블릿 객체를 삭제하였습니다. ====");
	}

	@Override 
	public void init() throws ServletException {
		System.out.println("==== 서블릿 객체의 맴버 변수가 초기화되었습니다. ====");
	}
	
	

}
