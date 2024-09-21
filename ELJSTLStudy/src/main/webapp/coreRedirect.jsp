<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<p>로그인</p>
	<form method="post">
		<p>닉네임: <input type="text" name="nickname" /></p>
		<p>이메일: <input type="email" name="email" /></p>
		<input type="submit" value="로그인"/>
	</form>
	
	<% request.setCharacterEncoding("utf-8"); %>
	<c:if test="${!empty param.nickname and !empty param.email }">
		<c:redirect url="coreRedirectDest.jsp">
			<c:param name="nickname" value="${ param.nickname }"></c:param>
			<c:param name="email" value="${ param.email }"></c:param>
		</c:redirect>
	</c:if>
</body>
</html>