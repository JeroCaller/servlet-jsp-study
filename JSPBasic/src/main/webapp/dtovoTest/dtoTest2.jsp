<%@page import="com.design_pattern.DTO2"%>
<%@ page contentType="text/html; charset=UTF-8"%>

<%
	DTO2 dto2 = new DTO2("Naython", "python@python.com");
	System.out.println(dto2);
	
	// 실수로 두 값이 뒤바뀌어 입력되어도 에러 없이 삽입됨. 
	DTO2 dto22 = new DTO2("Javas@Javascript.com", "Javas");
	System.out.println(dto22);
%>