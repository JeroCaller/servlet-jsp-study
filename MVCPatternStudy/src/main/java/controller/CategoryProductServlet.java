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

import model.db.ProductDAO;
import model.db.ProductDTO;

//@WebServlet("/products.do")
public class CategoryProductServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		// 사용자 요청 정보 추출
		String command = req.getParameter("command");
		String category = null;
		
		HttpSession session = req.getSession();
		
		// DB 로직.
		ProductDAO productDao = new ProductDAO();

		if (command != null && command.equals("CATEGORY")) {
			category = req.getParameter("category");
			productDao.setSelectedCategory(category);
			
			// shop.jsp로부터 다른 종류의 요청이 들어와도 선택된 카테고리의 
			// 물품들은 그대로 테이블에 보이도록 하기 위해 선택된 카테고리명을 세션 context에 저장한다. 
			session.setAttribute("selectedCategory", category);
		} else {
			category = (String)session.getAttribute("selectedCategory");
			productDao.setSelectedCategory(category);
		}
		
		// 선택된 카테고리에 해당하는 모든 물품 정보들을 세션에 저장.
		List<ProductDTO> products = productDao.getAllproducts();
		session.setAttribute("products", products);
		
		// 포워딩으로 페이지 이동
		String targetUrl = "/shop.jsp";
		RequestDispatcher dispatcher = req.getRequestDispatcher(targetUrl);
		dispatcher.forward(req, resp);
	}
	
}
