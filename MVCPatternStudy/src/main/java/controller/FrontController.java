package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.CommandInterface;
import command.SimpleFactory;

@WebServlet("*.do")
public class FrontController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");

		String requestUri = req.getServletPath();  // 요청 서블릿 URI 추출.
		
		CommandInterface commander = null;
		SimpleFactory sFact = SimpleFactory.getInstance();
		commander = sFact.getCommand(requestUri);
		
		String targetUrl = commander.executeCommand(req, resp);
		
		if (targetUrl != null) {
			RequestDispatcher dispatcher = req.getRequestDispatcher(targetUrl);
			dispatcher.forward(req, resp);
		}
		
	}
	
}


