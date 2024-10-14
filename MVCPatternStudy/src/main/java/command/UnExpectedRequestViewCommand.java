package command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 비정상적 요청에 대한 응답 페이지로 이동시키는 커맨드. 
 */
public class UnExpectedRequestViewCommand implements CommandInterface {

	@Override
	public String executeCommand(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		return "/unexpectedRequestPage.html";
	}
	
}
