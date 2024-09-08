<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<jsp:useBean id="user" class="com.jsp_study.UserSay" scope="session">
		<%= "bean 객체 초기화" %>
		<jsp:setProperty property="onlyOne" name="user" value="bean 객체 최초 생성 시에만 보인다."/>
		<jsp:getProperty property="onlyOne" name="user"/>
	</jsp:useBean>
	<jsp:setProperty property="userName" name="user" value="개발자"/>
	<jsp:setProperty property="say" name="user" value="반갑구리~"/>
	
	<h1>말말말</h1>
	
	<h3>개발자의 말</h3>
	<ul>
		<li>
			닉네임: <jsp:getProperty property="userName" name="user"/>
		</li>
		<li>
			남긴 말: <jsp:getProperty property="say" name="user"/>
		</li>
		<li>
			말을 한 날짜 및 시각 : <jsp:getProperty property="currentDateTime" name="user"/>
		</li>
	</ul>
</body>
</html>