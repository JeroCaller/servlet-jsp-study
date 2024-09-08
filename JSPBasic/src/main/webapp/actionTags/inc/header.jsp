<%@ page contentType="text/html; charset=UTF-8"%>

<%
	int myNum = 10;
%>

<h1>WELCOME TO MY PAGE</h1>
<p>My number: <%= myNum %></p>
<p><%= request.getParameter("headerSay") %></p>
<hr/>
