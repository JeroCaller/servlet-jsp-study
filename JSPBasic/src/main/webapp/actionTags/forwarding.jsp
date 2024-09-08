<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	ul {
		list-style: none;
		padding: 1em;
	}
	li {
		margin: 1em;
	}
</style>
</head>
<body>
	<form action="forwarding.jsp" method="post">
		<ul>
			<li>
				<label for="nickname">닉네임: </label>
				<input type="text" name="nickname" />
			</li>
			<li>
				<label for="say">하고 싶은 말 한 줄: </label>
				<input type="text" name="say" />
			</li>
		</ul>
		<button type="submit">제출</button>
	</form>
	
	<%
		if (request.getMethod().equalsIgnoreCase("POST")) {
			request.setCharacterEncoding("utf-8");
	%>
		<jsp:forward page="forwarded.jsp">
			<jsp:param value="배울 게 너무 많네요 ㅠㅠ" name="devSay"/>
		</jsp:forward>
	<%
		}
	%>
</body>
</html>