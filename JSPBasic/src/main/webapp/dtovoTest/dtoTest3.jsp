<%@page import="com.design_pattern.DTO3"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%
	DTO3 dto3 = new DTO3();

	dto3.setUserName("Javas");
	dto3.setEmail("javas@javascript.com");
	System.out.println(dto3);
	
	// 값 변경 시도.
	dto3.setUserName("Naython");
	dto3.setEmail("Naython@python.com");
	System.out.println(dto3);
%>