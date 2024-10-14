package command;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.Item;

/**
 * 물품 목록 중 사용자가 특정 물품의 "장바구니" 버튼 클릭 시 
 * 사용자의 장바구니 목록에 추가하는 커맨드. 
 */
public class ProductCartCommand implements CommandInterface {

	@Override
	public String executeCommand(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String productName = null;
		String priceStr;
		int price = -1;
		
		HttpSession session = req.getSession();
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
		
		return "/shop.jsp";
	}
	
}
