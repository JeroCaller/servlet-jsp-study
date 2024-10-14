package command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface CommandInterface {
	/**
	 * 
	 * @param req
	 * @param resp
	 * @return 포워딩 대상 URI
	 * @throws ServletException
	 * @throws IOException
	 */
	String executeCommand(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException;
}
