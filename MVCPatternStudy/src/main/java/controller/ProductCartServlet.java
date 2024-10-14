package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.Item;

//@WebServlet("/cart.do")
public class ProductCartServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		
		// business, DB logic
		String command = req.getParameter("command");
		String productName = null;
		String priceStr;
		int price = -1;
		
		HttpSession session = req.getSession();

		if (command != null && command.equals("CART")) {
			List<Item> items = (ArrayList<Item>)session.getAttribute("items");
			
			productName = req.getParameter("productName");
			priceStr = req.getParameter("price");
			price = Integer.parseInt(priceStr);
			
			// 사용자가 선택한 물품 정보 담기
			Item selectedItem = new Item();
			selectedItem.setProductName(productName);
			selectedItem.setPrice(price);
			selectedItem.setEa(1);
			
			// 사용자가 선택한 물품을 장바구니에 담기.
			if (items == null) {
				items = new ArrayList<Item>();
				items.add(selectedItem);
			} else {
				if (items.contains(selectedItem)) {
					// 사용자가 선택한 물품이 이미 장바구니에 있을 경우 수량을 추가. 
					// 총 수량에 맞게끔 총 가격도 수정. 
					Item alreadyExistItem = items.get(items.indexOf(selectedItem));
					alreadyExistItem.setEa(
						alreadyExistItem.getEa() + selectedItem.getEa()
					);
					alreadyExistItem.setPrice(
						alreadyExistItem.getPrice() + selectedItem.getPrice()
					);
				} else {
					items.add(selectedItem);
				}
			}
			// 세션에 장바구니 정보 저장. 
			session.setAttribute("items", items);
		}
		
		// 포워딩으로 페이지 이동
		String targetUrl = "/shop.jsp";
		RequestDispatcher dispatcher = req.getRequestDispatcher(targetUrl);
		dispatcher.forward(req, resp);
	}
	
}
