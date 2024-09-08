<%@page import="java.util.Enumeration"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%!
		public String getParameterWithoutNull(HttpServletRequest req, String paramName, String replaceNull) {
			String strValue = req.getParameter(paramName);
			if (strValue == null) {
				strValue = replaceNull;
			}
			return strValue;
		}
	%>
	<%
		String userName = getParameterWithoutNull(request, "nickname", "anonymous");
		String say = getParameterWithoutNull(request, "say", "(해당 유저가 할 말을 입력하지 않았습니다.)");
		String devSay = getParameterWithoutNull(request, "devSay", "(개발자가 할 말이 없나봅니다.)");
	%>
	<h1>입력 결과</h1>
	<hr/>
	<p>닉네임: <%= userName %> </p>
	<p>하고 싶은 말 </p>
	<p><%=say %></p>
	<hr/>
	<p>개발자의 말 </p>
	<p><%=devSay %> </p>
	
	<hr/>
	
	<p>모든 파라미터 name-value 값 출력</p>
	<ul>
	<%
		Enumeration<String> names = request.getParameterNames();
		while(names.hasMoreElements()) {
			String name = names.nextElement();
			String value = request.getParameter(name);
	%>
		<li><%=name %> : <%=value %></li>
	<% 
		}
	%>
	</ul>
	
</body>
</html>