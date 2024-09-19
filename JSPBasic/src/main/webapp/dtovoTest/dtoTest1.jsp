<%@page import="com.design_pattern.DTO1"%>
<%@ page contentType="text/html; charset=UTF-8"%>

<%
	DTO1 dto1 = new DTO1();
	
	dto1.setUsername("Kimquel");
	dto1.setEmail("kimquel@coding.com");
	System.out.println(dto1.getUsername() + " : " + dto1.getEmail());
	
	// 값 변경 가능 : 가변성을 띔.
	dto1.setUsername("JeongDB");
	dto1.setEmail("JeongDB@db.com");
	System.out.println(dto1.getUsername() + " : " + dto1.getEmail());
%>