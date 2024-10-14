<%@page import="model.db.UserDAO"%>
<%@page import="model.db.UserDTO"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입 결과</title>
<link rel="stylesheet" href="/MVCPatternStudy/css/style.css">
</head>
<body>
	<%
		// business, DB logic
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		UserDTO oneUser = new UserDTO();
		oneUser.setId(id);
		oneUser.setPassword(pw);
		
		UserDAO userDao = new UserDAO();
		boolean isSuccess = userDao.insertUser(oneUser);
		
		if (isSuccess) {
			// Presentation logic
	%>
			<p>회원가입에 성공하였습니다. 로그인 화면으로 돌아가 로그인해주세요.</p>
			<a href="/MVCPatternStudy/login.html">로그인 화면으로 돌아가기</a>
	<%
		} else {
	%>
			<p>회원가입에 실패했습니다. 다시 회원가입 해주세요.</p>
			<a href="/MVCPatternStudy/signup.html">회원가입 창으로 되돌아가기</a>
	<%
		}
	%>
</body>
</html>