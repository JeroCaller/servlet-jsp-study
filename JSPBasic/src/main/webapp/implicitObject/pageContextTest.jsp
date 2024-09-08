<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		/*
			페이지 영역 내부라고 해서 모든 데이터가 page context 내부에 
			저장되는 건 아니다. 
			pageContext의 attribute란 이름이 붙은 
			메서드를 이용하여 데이터 저장, 검색, 삭제를 할 수 있는 것이다.
		*/
		String name = "kimquel";
	
		pageContext.setAttribute("name", "Jas Park");
	%>
	<p><%=(String)pageContext.getAttribute("name") %></p>
	
	<a href="pageContextTest2.jsp">다른 페이지로 이동하기</a>
</body>
</html>