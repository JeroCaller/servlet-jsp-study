<%@page import="java.util.List"%>
<%@page import="model.db.UserDTO"%>
<%@page import="model.db.UserDAO"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%
	// Business, DB logic
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	
	UserDTO inputUser = new UserDTO();
	inputUser.setId(id);
	inputUser.setPassword(pw);
	
	UserDAO userDao = new UserDAO();
	List<UserDTO> allUsers = userDao.getAllUsers();
	
	if (allUsers.contains(inputUser)) {
		// 로그인한 현재 사용자의 정보를 세션에 저장.
		session.setAttribute("userInfo", inputUser);
		
		String url = "/MVCPatternStudy/shop.jsp";
		response.sendRedirect(url);  // 페이지 이동
	} else {
		// presentation logic
%>
	<script>
		alert("아이디 또는 패스워드가 맞지 않습니다.");
		history.back();
	</script>
<%
	}
%>