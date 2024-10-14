package command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.db.UserDAO;
import model.db.UserDTO;

/**
 * 회원 가입 로직 처리 커맨드. 
 */
public class SignUpProcCommand implements CommandInterface {

	@Override
	public String executeCommand(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String id = req.getParameter("id"); 
		String pw = req.getParameter("pw");
		
		UserDAO userDao = new UserDAO();
		UserDTO oneUser = new UserDTO();
		
		// 회원 가입 로직 처리
		oneUser.setId(id);
		oneUser.setPassword(pw);
		
		boolean isSuccess = userDao.insertUser(oneUser);
		
		req.setAttribute("isSignUpSuccess", isSuccess);
		return "/signupView.jsp";
	}
	
}
