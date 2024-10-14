<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	boolean isSuccess = (boolean)request.getAttribute("isSignUpSuccess");

	if (isSuccess) {
		// Presentation logic
%>
	<p>회원가입에 성공하였습니다. 로그인 화면으로 돌아가 로그인해주세요.</p>
	<a href="/MVCPatternStudy/login.do">로그인 화면으로 돌아가기</a>
<%
	} else {
%>
	<p>회원가입에 실패했습니다. 다시 회원가입 해주세요.</p>
	<a href="/MVCPatternStudy/signup.do">회원가입 창으로 되돌아가기</a>
<%
	}
%>

</body>
</html>