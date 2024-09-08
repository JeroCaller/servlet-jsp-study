<%@page import="java.util.Date"%>
<%@ page contentType="text/html; charset=UTF-8"%>

<%
	String name = "jas Park";
%>

<hr/>

<h1>만나서 반갑습니다. </h1>
<p>오늘은 <%= new Date().toLocaleString() %> 입니다.</p>
<p><%=name %> </p>
<hr/>