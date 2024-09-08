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
	
	<%
		if (request.getMethod().equalsIgnoreCase("GET")) {
	%>
		<form action="showUserSay.jsp" method="post">
			<ul>
				<li>
					<label for="nickname">닉네임: </label>
					<input type="text" name="userName" />
				</li>
				<li>
					<label for="say">하고 싶은 말 한 줄: </label>
					<input type="text" name="say" />
				</li>
			</ul>
			<button type="submit">제출</button>
		</form>
	<%
		} else { 
			request.setCharacterEncoding("utf-8");
	%>

	<jsp:useBean id="user2" class="com.jsp_study.UserSay"/>
	<jsp:setProperty property="userName" name="user2"/>
	<jsp:setProperty property="say" name="user2"/>
	
	<h1>말말말</h1>
	
	<ul>
		<li>
			닉네임: <jsp:getProperty property="userName" name="user2"/>
		</li>
		<li>
			남긴 말: <jsp:getProperty property="say" name="user2"/>
		</li>
		<li>
			말을 한 날짜 및 시각 : <jsp:getProperty property="currentDateTime" name="user2"/>
		</li>
	</ul>
	
	<%
		}
	%>
</body>
</html>