<%@page import="model.db.UserDTO"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%
	// Business Logic
	UserDTO currentUser = (UserDTO) session.getAttribute("userInfo");
	String userName = null;
	
	if (currentUser == null) {
		userName = "guest";
	} else {
		userName = currentUser.getId();
	}
	
	// Presentation Logic
%>
<header>
	<span><a href="/MVCPatternStudy/index.html">JeroCaller's online shop</a></span>
	<span><%= userName %>님 환영합니다.</span>
</header>
<hr/>