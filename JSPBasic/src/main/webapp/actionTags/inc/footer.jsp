<%@ page contentType="text/html; charset=UTF-8"%>

<%
	int myNum = 100;
%>

<hr/>
<span>사이트맵</span>
<span> | </span>
<span>오시는길</span>
<span> | </span>
<span>그외 정보</span>
<span> | </span>
<span>My number: <%=myNum %></span>

<p><%= request.getParameter("footerSay") %></p>