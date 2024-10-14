package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.db.UserDAO;
import model.db.UserDTO;

//@WebServlet("/signupProc.do")
public class SignUpProcServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		// 회원 가입 로직 처리
		String id = req.getParameter("id");
		String pw = req.getParameter("pw");
		
		UserDTO oneUser = new UserDTO();
		oneUser.setId(id);
		oneUser.setPassword(pw);
		
		UserDAO userDao = new UserDAO();
		boolean isSuccess = userDao.insertUser(oneUser);
		
		req.setAttribute("isSignUpSuccess", isSuccess);
		
		// 페이지 이동.
		String targetUrl = "/signupView.jsp";
		RequestDispatcher dispatcher = req.getRequestDispatcher(targetUrl);
		dispatcher.forward(req, resp);
	}
	
}
