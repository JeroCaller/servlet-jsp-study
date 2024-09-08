<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		int myNum = 0;
		
		request.setCharacterEncoding("utf-8");
	%>
	
	<jsp:include page="inc/header.jsp">
		<jsp:param value="반갑구리~" name="headerSay"/>
	</jsp:include>
	<h2>여기는 본문 영역입니다.</h2>
	<p>My number: <%= myNum %></p>
	<jsp:include page="inc/footer.jsp">
		<jsp:param value="바닥글이다구리~" name="footerSay"/>
	</jsp:include>
</body>
</html>