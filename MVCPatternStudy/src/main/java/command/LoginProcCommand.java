package command;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.db.UserDAO;
import model.db.UserDTO;

/**
 * 로그인 인증 로직 처리
 */
public class LoginProcCommand implements CommandInterface {

	@Override
	public String executeCommand(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String targetUrl = null;
		
		String id = req.getParameter("id"); 
		String pw = req.getParameter("pw");
		
		HttpSession session = req.getSession();
		
		UserDAO userDao = new UserDAO();
		UserDTO oneUser = new UserDTO();
		oneUser.setId(id);
		oneUser.setPassword(pw);
		
		List<UserDTO> allUsers = userDao.getAllUsers();
		
		if (allUsers.contains(oneUser)) {
			// 로그인한 현재 사용자의 정보를 세션에 저장.
			session.setAttribute("userInfo", oneUser);
			
			targetUrl = "/shop.jsp";
		} else {
			targetUrl = "/loginFailed.jsp";
		}
		
		return targetUrl;
	}
	
}
