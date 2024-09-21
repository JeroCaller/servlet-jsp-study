<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form>
		<p>정수 입력: <input type="number" name="integer" /></p>
		<input type="submit" value="입력" />
	</form>
	
	<c:if test="${!empty param.integer }">
		<c:if test="${ param.integer % 2 == 0 }">
			<p>입력하신 ${ param.integer }이란 숫자는 짝수입니다.</p>
		</c:if>
		<c:if test="${ param.integer % 2 != 0 }">
			<p>입력하신 ${ param.integer }이란 숫자는 홀수입니다.</p>
		</c:if>
	</c:if>
</body>
</html>