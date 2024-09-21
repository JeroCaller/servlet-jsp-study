<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:set var="num1" value="10"/>
	<p>${ num1 }</p>
	
	<c:set var="num2" value="20"></c:set>
	<p>${ num2 }</p>
	
	<c:set var="total" value="${ num1 + num2 }" />
	<p>${ total }</p>
	
	<!-- scope 속성 테스트. -->
	<c:set var="wow" value="빡빡이 친구들!"/>
	<c:set var="bow" value="월월!" scope="session" />
	
	<a href="coreSetScope.jsp">Go to other page</a>
</body>
</html>