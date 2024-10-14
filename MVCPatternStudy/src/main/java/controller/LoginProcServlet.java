package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.db.UserDAO;
import model.db.UserDTO;

//@WebServlet("/loginProc.do")
public class LoginProcServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		
		// 로그인 인증 로직.
		String id = req.getParameter("id");
		String pw = req.getParameter("pw");
		
		UserDTO inputUser = new UserDTO();
		inputUser.setId(id);
		inputUser.setPassword(pw);
		
		UserDAO userDao = new UserDAO();
		List<UserDTO> allUsers = userDao.getAllUsers();
		
		HttpSession session = req.getSession();
		String targetUrl = "";
		
		if (allUsers.contains(inputUser)) {
			// 로그인한 현재 사용자의 정보를 세션에 저장.
			session.setAttribute("userInfo", inputUser);
			
			targetUrl = "/shop.jsp";
		} else {
			targetUrl = "/loginFailed.jsp";
		}
		
		RequestDispatcher dispatcher = req.getRequestDispatcher(targetUrl);
		dispatcher.forward(req, resp);
	}
	
}
