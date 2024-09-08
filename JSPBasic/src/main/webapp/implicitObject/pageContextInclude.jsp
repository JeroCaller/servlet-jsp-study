<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>메인 페이지입니다.</h1>
	<%
		pageContext.include("pageContextInclude2.jsp");
		String name = "kimquel";
	%>
	<p>
		<span>사이트 소개</span>
		<span> | </span>
		<span>오시는 길</span>
		<span> | </span>
		<span>연락처</span>
	</p>
	<p><%=name %></p>
</body>
</html>