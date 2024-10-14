package command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 회원가입 페이지로 이동하는 커맨드 클래스. 
 */
public class SignUpViewCommand implements CommandInterface {

	@Override
	public String executeCommand(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		return "/signup.html";
	}
	
}
