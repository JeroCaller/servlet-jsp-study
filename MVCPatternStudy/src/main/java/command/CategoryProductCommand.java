package command;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.db.ProductDAO;
import model.db.ProductDTO;

/**
 * 사용자가 특정 카테고리 클릭 시 해당 카테고리에 있는 모든 물품 데이터를 
 * 화면에 출력할 수 있도록 세션에 저장하는 커맨드. 
 */
public class CategoryProductCommand implements CommandInterface {

	@Override
	public String executeCommand(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// 사용자 요청 정보 추출
		String category = null;
		ProductDAO productDao = new ProductDAO();
		category = req.getParameter("category");
		HttpSession session = req.getSession();
		
		if (category != null) {
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
		
		return "/shop.jsp";
	}
	
}
