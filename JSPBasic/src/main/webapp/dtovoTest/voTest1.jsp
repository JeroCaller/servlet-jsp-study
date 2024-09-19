<%@page import="com.design_pattern.VO1"%>
<%@ page contentType="text/html; charset=UTF-8"%>

<%
	VO1 user1 = new VO1("kimquel");
	VO1 user2 = new VO1("kimquel");
	
	System.out.println(user1.equals(user2));
	System.out.println(user1 == user2);
%>