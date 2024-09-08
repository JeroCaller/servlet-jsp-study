<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page session="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>당신의 세션 아이디</h1>
	
	<% HttpSession session = request.getSession(); %>
	<%= session.getId() %>
</body>
</html>