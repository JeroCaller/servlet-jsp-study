<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		int num = 0;
		boolean isNotNumError = false;
		try {
			num = Integer.parseInt(request.getParameter("number"));
		} catch (NumberFormatException e) {
			isNotNumError = true;
		}
	%>
	<%
		if (isNotNumError) {
	%>
		<p>오류! 아무것도 입력하지 않았거나 숫자가 아닌 문자를 입력하셨습니다.</p>
	
	<!-- return문 삽입. -->
	<%
		return;} 
	%>
	
	<p>당신이 입력한 숫자는 <%=num %> 입니다. </p>
</body>
</html>